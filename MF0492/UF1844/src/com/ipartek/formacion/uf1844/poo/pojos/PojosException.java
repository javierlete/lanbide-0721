package com.ipartek.formacion.uf1844.poo.pojos;

public class PojosException extends RuntimeException {

	private static final long serialVersionUID = 329732350553970810L;

	public PojosException() {
		super();
	}

	public PojosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PojosException(String message, Throwable cause) {
		super(message, cause);
	}

	public PojosException(String message) {
		super(message);
	}

	public PojosException(Throwable cause) {
		super(cause);
	}

}
