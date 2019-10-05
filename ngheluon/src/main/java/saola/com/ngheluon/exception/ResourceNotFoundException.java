package saola.com.ngheluon.exception;

/**
 * Exception for resource not found
 * @author namnt
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor.
     */
    public ResourceNotFoundException() {
    }

    /**
     * Constructor.
     * @param message error message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor.
     * @param cause error
     */
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor.
     * @param message error message
     * @param cause error
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     * @param message error message
     * @param cause error
     * @param enableSuppression enable suppression or not
     * @param writableStackTrace stack trace writable or not
     */
    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
