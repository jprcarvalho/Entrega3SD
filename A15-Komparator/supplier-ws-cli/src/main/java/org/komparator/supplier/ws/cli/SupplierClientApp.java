package org.komparator.supplier.ws.cli;

/** Main class that starts the Supplier Web Service client. */
public class SupplierClientApp {

	public static void main(String[] args) throws Exception {
		// Check arguments
		//untested
		if (args.length < 3) {
			System.err.println("Argument(s) missing!");
			System.err.println("Usage: java " + SupplierClientApp.class.getName() + " wsURL , UDDIAddress , serverName");
			return;
		}
		String wsURL = args[0];

		// Create client
		System.out.printf("Creating client for server at %s , UDDIAddress is %s and serverName is %s%n", wsURL,args[1],args[2]);
		//untested
		SupplierClient client = new SupplierClient(wsURL,args[1],args[2]);

		// the following remote invocations are just basic examples
		// the actual tests are made using JUnit

		System.out.println("Invoke ping()...");
		String result = client.ping("client");
		System.out.print("Result: ");
		System.out.println(result);
	}

}
