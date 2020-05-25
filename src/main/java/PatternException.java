package src.main.java;

/**
 * This class is used to handle a PatternException.
 * This may occur when running the application.
 *
 * @author Michele Cattaneo
 */
public class PatternException extends Exception {

    /**
     * Constructor for the class PatternException.
     * @param message The message of the exception
     */
    public PatternException(final String message) {
        super(message);
    }
}
