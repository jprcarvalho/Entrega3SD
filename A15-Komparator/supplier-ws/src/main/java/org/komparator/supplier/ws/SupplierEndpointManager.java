package org.komparator.supplier.ws;

import java.io.IOException;

import javax.xml.ws.Endpoint;
import pt.ulisboa.tecnico.sdis.ws.uddi.UDDINaming;



/** End point manager */
public class SupplierEndpointManager {

	/** Web Service location to publish */
	private String wsURL = null;
	private String _UDDIAddress = null;
	private String _serverName = null;
	/** Port implementation */
	private SupplierPortImpl portImpl = new SupplierPortImpl(this);

// TODO
//	/** Obtain Port implementation */
//	public SupplierPortType getPort() {
//		return portImpl;
//	}

	/** Web Service end point */
	private Endpoint endpoint = null;
	private UDDINaming uddiNaming = null;
	/** output option **/
	private boolean verbose = true;

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	/** constructor with provided web service URL 
	public SupplierEndpointManager(String wsURL) {
		if (wsURL == null)
			throw new NullPointerException("Web Service URL cannot be null!");
		this.wsURL = wsURL;
	}
	*/
	public SupplierEndpointManager(String wsURL,String UDDIAddress , String serverName){
		if (wsURL == null)
			throw new NullPointerException("Web Service URL cannot be null!");
		this.wsURL = wsURL;
		if(UDDIAddress==null){throw new NullPointerException("Null UDDIAddress");}
		if(serverName==null){throw new NullPointerException("Null serverName");}
		this._serverName= serverName;
		this._UDDIAddress = UDDIAddress;
	}
	/* end point management */

	public void start() throws Exception {
		try {
			// publish end point
			endpoint = Endpoint.create(this.portImpl);
			if (verbose) {
				System.out.printf("Starting %s%n", wsURL);
			}
			endpoint.publish(wsURL);
			
			//UDDISTUFFS
			uddiNaming = new UDDINaming(_UDDIAddress);
			uddiNaming.rebind(_serverName, wsURL);
			System.out.printf("Publishing '%s' to UDDI at %s%n", _serverName, _UDDIAddress);

		} catch (Exception e) {
			endpoint = null;
			if (verbose) {
				System.out.printf("Caught exception when starting: %s%n", e);
				e.printStackTrace();
			}
			throw e;
		}
	}

	public void awaitConnections() {
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
		this.portImpl = null;
	}

}
