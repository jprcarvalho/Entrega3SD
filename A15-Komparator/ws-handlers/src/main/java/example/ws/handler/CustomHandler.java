package example.ws.handler;

import java.io.File;
import static javax.xml.bind.DatatypeConverter.parseBase64Binary;
import static javax.xml.bind.DatatypeConverter.printBase64Binary;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.MessageContext.Scope;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.komparator.security.CryptoUtil;
import org.w3c.dom.Node;

import pt.ulisboa.tecnico.sdis.cert.CertUtil;


public class CustomHandler implements SOAPHandler<SOAPMessageContext> {

	public static final String CONTEXT_PROPERTY = "my.property";

	/**
	 * Gets the header blocks that can be processed by this Handler instance. If
	 * null, processes all.
	 */
	@Override
	public Set<QName> getHeaders() {
		return null;
	}

	/**
	 * The handleMessage method is invoked for normal processing of inbound and
	 * outbound messages.
	 */
	@Override
	public boolean handleMessage(SOAPMessageContext smc) {
		/*System.out.println(this.getClass().getSimpleName() + " Soap handler writting output to log.txt\n");
		try {
			System.setOut(new PrintStream(new FileOutputStream("log.txt"), true));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		System.out.println("AddHeaderHandler: Handling message.");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Boolean outboundElement = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		try {
			if (outboundElement.booleanValue()) {
				System.out.println("Writing header in outbound SOAP message...");
				String keyStoreFilePath = "A15_Mediator.jks";
				char[] keyStorePassword = "7Nhx1rNT".toCharArray();
				String keyAlias = "a15_mediator";
				char[] keyPassword ="7Nhx1rNT".toCharArray();
			
				// get SOAP envelope
				SOAPMessage msg = smc.getMessage();
				SOAPPart sp = msg.getSOAPPart();
				SOAPEnvelope se = sp.getEnvelope();

				// add header
				SOAPHeader sh = se.getHeader();
				//the first child always carries the message
				Node body = se.getBody().getFirstChild();
				CryptoUtil cryptkeeper = new CryptoUtil();
				//byte[] digitalSignature = cryptkeeper.createDigitalSignature(CertUtil.getPrivateKeyFromKeyStoreFile(keyStoreFilePath, keyStorePassword, keyAlias, keyPassword), body.toString().getBytes());
				//System.out.println(printBase64Binary(digitalSignature));
				/*
				System.out.println("TEST \n\n\n ");
				System.out.println(body.toString());
				System.out.println("TEST \n\n\n ");
				*/
				if (sh == null)
					sh = se.addHeader();

				// add header element (name, namespace prefix, namespace)
				Name name = se.createName("myHeader", "d", "http://demo");
				SOAPHeaderElement element = sh.addHeaderElement(name);

				// add header element value
			
				String valueString = LocalDateTime.now().format(formatter);//Integer.toString(value);
				element.addTextNode(valueString);

			} else {
				System.out.println("Reading header in inbound SOAP message...");
				
				// get SOAP envelope header
				
				SOAPMessage msg = smc.getMessage();
				SOAPPart sp = msg.getSOAPPart();
				SOAPEnvelope se = sp.getEnvelope();
				SOAPHeader sh = se.getHeader();

				// check header
				if (sh == null) {
					System.out.println("Header not found.");
					return true;
				}

				// get first header element
				Name name = se.createName("myHeader", "d", "http://demo");
				Iterator it = sh.getChildElements(name);
				// check header element
				if (!it.hasNext()) {
					System.out.println("Header element not found.");
					return true;
				}
				SOAPElement element = (SOAPElement) it.next();

				// get header element value

				String value = element.getValue();
				LocalDateTime dateTime = LocalDateTime.parse(value, formatter);
				long time = dateTime.until(LocalDateTime.now(), ChronoUnit.MILLIS);
				// print received header
				
				System.out.println("Header value is " + value);
				System.out.println("Message sent "+ time +" milliseconds ago");
				//failure test
				//time += 3000;
				//failure test
				if(time<=3000){
					System.out.println("Message accepted");
				}else{
					System.out.println("Message sent too long ago, rejecting");
					//implementar excecao mais especifica
					throw new java.lang.RuntimeException();
				}
				// put header in a property context
				smc.put(CONTEXT_PROPERTY, value);
				// set property scope to application client/server class can
				// access it
				smc.setScope(CONTEXT_PROPERTY, Scope.APPLICATION);

			}
		} catch (Exception e) {
			System.out.print("Caught exception in handleMessage: ");
			System.out.println(e);
			System.out.println("Continue normal processing...");
		}

		return true;
	}

	/** The handleFault method is invoked for fault message processing. */
	@Override
	public boolean handleFault(SOAPMessageContext smc) {
		System.out.println("Ignoring fault message...");
		return true;
	}

	/**
	 * Called at the conclusion of a message exchange pattern just prior to the
	 * JAX-WS runtime dispatching a message, fault or exception.
	 */
	@Override
	public void close(MessageContext messageContext) {
		// nothing to clean up
	}

}