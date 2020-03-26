package edu.eci.arsw.coronaAPI.exceptions;


public class ServiceException extends Exception {

	private static final long serialVersionUID = 468187741104740422L;

	public ServiceException(String msg) {
        super(msg);
    }
	
	public ServiceException(String msg, Exception e) {
        super(msg,e);
    
    }
}