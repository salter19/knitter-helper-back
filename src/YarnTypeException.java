/**
 * YarnTypeException is thrown when chosen yarn type is invalid for the type of
 * action it is to be used.
 */
class YarnTypeException extends Exception {

    /** detail is the message to be printed when this exception is thrown */
    String detail;

    /**
     * constructor that takes in a custom message
     * @param message   String  The custom message.
     */
    public YarnTypeException(String message) {
        this.detail = message;
    }
}
