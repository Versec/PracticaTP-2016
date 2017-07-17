package com.gomez_juan_lopez_javier.exceptions;

public class DivByZeroException extends ExecutionErrorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1511409325431602239L;
	
	public DivByZeroException (String message){
		super(message);
	}

}
