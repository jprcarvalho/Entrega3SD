package org.komparator.supplier.ws;


/** Main class that starts the Supplier Web Service. */
public class SupplierApp {

	public static void main(String[] args) throws Exception {
		// Check arguments
		if (args.length < 3) {
			System.err.println("Argument(s) missing!");
			System.err.println("Usage: java " + SupplierApp.class.getName() + " wsURL , UDDIAddress,ServerName");
			return;
		}
		String wsURL = args[0];

		// Create server implementation object
		//SupplierEndpointManager endpoint = new SupplierEndpointManager(wsURL);
		// Create server using UDDI
		SupplierEndpointManager endpoint = new SupplierEndpointManager(wsURL, args[1], args[2]);
		try {
			endpoint.start();
			endpoint.awaitConnections();
		} finally {
			endpoint.stop();
		}

	}

}
