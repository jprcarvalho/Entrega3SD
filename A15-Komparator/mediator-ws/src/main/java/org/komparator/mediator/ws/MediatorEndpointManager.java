package org.komparator.mediator.ws;

import java.io.IOException;

import javax.xml.ws.Endpoint;

import org.komparator.mediator.ws.cli.MediatorClientException;

import pt.ulisboa.tecnico.sdis.ws.uddi.UDDINaming;

/** End point manager */
public class MediatorEndpointManager {

	/** UDDI naming server location */
	private String uddiURL = null;
	/** Web Service name */
	private String wsName = null;

	/** Get Web Service UDDI publication name */
	public String getWsName() {
		return wsName;
	}
	public void setWsURL(String url){
		this.wsURL = url;
		
	}
	public void setWsName(String name){
		this.wsName = name;
	}
	public void setUddiUrl(String url){
		this.uddiURL = url;
		
	}
	/** Web Service location to publish */
	private String wsURL = null;
	public String getuddiURL(){return this.uddiURL;}
	/** Port implementation */
// TODO uncomment after port implementation is done
	private MediatorPortImpl portImpl = new MediatorPortImpl(this);

	/** Obtain Port implementation */
// TODO uncomment after port implementation is done
	public MediatorPortType getPort() {
        return portImpl;
	}

	/** Web Service endpoint */
	private Endpoint endpoint = null;
	/** UDDI Naming instance for contacting UDDI server */
	private UDDINaming uddiNaming = null;

	/** Get UDDI Naming instance for contacting UDDI server */
	UDDINaming getUddiNaming() {
		return uddiNaming;
	}

	/** output option **/
	private boolean verbose = true;

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	/** constructor with provided UDDI location, WS name, and WS URL */
	public MediatorEndpointManager(String uddiURL, String wsName, String wsURL) {
		this.uddiURL = uddiURL;
		this.wsName = wsName;
		this.wsURL = wsURL;
	}

	/** constructor with provided web service URL */
	public MediatorEndpointManager(String wsURL) {
		if (wsURL == null)
			throw new NullPointerException("Web Service URL cannot be null!");
		this.wsURL = wsURL;
	}

	/* end point management */

	public void start() throws Exception {
		try {
			// publish end point
// TODO uncomment after port implementation is done
			endpoint = Endpoint.create(this.portImpl);
			if (verbose) {
				System.out.printf("Starting %s%n", wsURL);
			}
			endpoint.publish(wsURL);
		} catch (Exception e) {
			endpoint = null;
			if (verbose) {
				System.out.printf("Caught exception when starting: %s%n", e);
				e.printStackTrace();
			}
			throw e;
		}
			//only the first mediator publishes to uddi by default
			
			if(this.wsURL.equals("http://localhost:8071/mediator-ws/endpoint")){
				publishToUDDI();
				portImpl.setPrimary(true);
				publishToUDDI();
				}
			else{
				System.out.println("Only http://localhost:8071/mediator-ws/endpoint registers to UDDI by default, @MediatorEndpointManager");
				portImpl.setPrimary(false);
				};
				
			System.out.println("Mediator running as primary: " + portImpl.getPrimary());
	}

	public void awaitConnections() throws MediatorClientException {
		portImpl.LifeProofBoot();
		if (verbose) {
			System.out.println("Awaiting connections");
			System.out.println("Press enter to shutdown");
		}
		try {
			System.in.read();
		} catch (IOException e) {
			if (verbose) {
				System.out.printf("Caught i/o exception when awaiting requests: %s%n", e);
			}
		}
	}

	public void stop() throws Exception {
		try {
			if (endpoint != null) {
				// stop end point
				endpoint.stop();
				if (verbose) {
					System.out.printf("Stopped %s%n", wsURL);
				}
			}
		} catch (Exception e) {
			if (verbose) {
				System.out.printf("Caught exception when stopping: %s%n", e);
			}
		}
// TODO uncomment after port implementation is done
		this.portImpl.killLifeProof();
		this.portImpl = null;
		unpublishFromUDDI();
	}

	/* UDDI */

	void publishToUDDI() throws Exception {
		try {
			// publish to UDDI
			if (uddiURL != null) {
				if (verbose) {
					System.out.printf("Publishing '%s' to UDDI at %s%n", wsName, uddiURL);
				}
				uddiNaming = new UDDINaming(uddiURL);
				uddiNaming.rebind(wsName, wsURL);
			}
		} catch (Exception e) {
			uddiNaming = null;
			if (verbose) {
				System.out.printf("Caught exception when binding to UDDI: %s%n", e);
			}
			throw e;
		}
	}

	void unpublishFromUDDI() {
		try {
			if (uddiNaming != null) {
				// delete from UDDI
				uddiNaming.unbind(wsName);
				if (verbose) {
					System.out.printf("Unpublished '%s' from UDDI%n", wsName);
				}
				uddiNaming = null;
			}
		} catch (Exception e) {
			if (verbose) {
				System.out.printf("Caught exception when unbinding: %s%n", e);
			}
		}
	}

}
