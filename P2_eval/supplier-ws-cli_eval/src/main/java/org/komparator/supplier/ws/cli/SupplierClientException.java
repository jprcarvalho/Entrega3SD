package org.komparator.supplier.ws.cli;

public class SupplierClientException extends Exception {

	private static final long serialVersionUID = 1L;

	public SupplierClientException() {
	}

	public SupplierClientException(String message) {
		super(message);
	}

	public SupplierClientException(Throwable cause) {
		super(cause);
	}

	public SupplierClientException(String message, Throwable cause) {
		super(message, cause);
	}

}
