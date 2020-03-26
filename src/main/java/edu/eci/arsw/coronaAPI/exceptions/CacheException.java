package edu.eci.arsw.coronaAPI.exceptions;


public class CacheException extends Exception {

	private static final long serialVersionUID = 468187741104740422L;

	public CacheException(String msg) {
        super(msg);
    }
	
	public CacheException(String msg, Exception e) {
        super(msg,e);
    
    }
}