package com.ipartek.formacion.uf1845.dal;

public class DalException extends RuntimeException {

	private static final long serialVersionUID = -1039880700097977423L;

	public DalException() {
		super();
	}

	public DalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DalException(String message, Throwable cause) {
		super(message, cause);
	}

	public DalException(String message) {
		super(message);
	}

	public DalException(Throwable cause) {
		super(cause);
	}

	
}
