package main.java.exceptions;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class InvalidInputException extends Exception {
	public InvalidInputException() {
	}

	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException(Throwable cause) {
		super(cause);
	}

	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}
}
