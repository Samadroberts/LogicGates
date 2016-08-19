package exceptions;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class NoValidInputException extends Exception {
	public NoValidInputException() {
	}

	public NoValidInputException(String message) {
		super(message);
	}

	public NoValidInputException(Throwable cause) {
		super(cause);
	}

	public NoValidInputException(String message, Throwable cause) {
		super(message, cause);
	}
}
