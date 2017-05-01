package example.ws.handler;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * This SOAPHandler outputs the contents of the message context for inbound and
 * outbound messages.
 */
public class MessageContextHandler implements SOAPHandler<SOAPMessageContext> {

	//
	// Handler interface implementation
	//

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
		printMessageContext(smc);
		return true;
	}

	/** The handleFault method is invoked for fault message processing. */
	@Override
	public boolean handleFault(SOAPMessageContext smc) {
		printMessageContext(smc);
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

	private void printMessageContext(MessageContext map) {
		System.out.println("Message context: (scope,key,value)");
		try {
			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				Object key = it.next();
				Object value = map.get(key);

				String keyString;
				if (key == null)
					keyString = "null";
				else
					keyString = key.toString();

				String valueString;
				if (value == null)
					valueString = "null";
				else
					valueString = value.toString();

				Object scope = map.getScope(keyString);
				String scopeString;
				if (scope == null)
					scopeString = "null";
				else
					scopeString = scope.toString();
				scopeString = scopeString.toLowerCase();

				System.out.println("(" + scopeString + "," + keyString + "," + valueString + ")");
			}

		} catch (Exception e) {
			System.out.printf("Exception while printing message context: %s%n", e);
		}
	}

}
