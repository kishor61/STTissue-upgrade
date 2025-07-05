/**
 * 
 */
package com.st.common.exception;

/**
 * @author sbora
 *
 */
public class TrackerException extends  Exception{

	private String message=null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TrackerException() {
		super();
	}
	
	public TrackerException(String message) {
		super(message);
		this.message=message;
	}
	
	public TrackerException(Throwable throwable) {
		super(throwable);
		this.message=throwable.getMessage();
	}
	public TrackerException(String message,Throwable throwable) {
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
