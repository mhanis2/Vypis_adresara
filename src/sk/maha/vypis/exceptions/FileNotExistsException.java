package sk.maha.vypis.exceptions;

public class FileNotExistsException extends Exception {

	private static final long serialVersionUID = -9007821114141093871L;

	/**
	 * File does not exist.
	 * 
	 * @param message
	 */
	public FileNotExistsException(String message) {
		super(message);
		System.err.println(message);
	}

}
