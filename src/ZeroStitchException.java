/**
 * ZeroStitchException is thrown when stitch count given is zero.
 */
class ZeroStitchException extends Exception {

    /** detail is the message to be printed when this exception is thrown */
    String detail;

    /**
     * constructor that takes in a custom message
     * @param message   String  The custom message.
     */
    public ZeroStitchException(String message) {
        this.detail = message;
    }

    /**
     * is used when exception has been caught
     * @return String   this.detail as a exception message
     */
    @Override
    public String getMessage() {
        return this.detail;
    }
    
}

// End of File.
