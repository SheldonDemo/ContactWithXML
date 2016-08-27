package exception;

public class NameRepeatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NameRepeatException(String msg){
		super(msg);
	}
}
