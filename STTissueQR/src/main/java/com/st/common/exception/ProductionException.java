/**
 * 
 */
package com.st.common.exception;

/**
 * @author sbora
 *
 */
public class ProductionException extends  Exception{

	private String message=null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ProductionException() {
		super();
	}
	
	public ProductionException(String message) {
		super(message);
		this.message=message;
	}
	
	public ProductionException(Throwable throwable) {
		super(throwable);
		this.message=throwable.getMessage();
		
	}
	public ProductionException(String message,Throwable throwable) {
		super(message,throwable);
		this.message=message;
	}
	
	@Override
	public String toString() {
		return message;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}
}
