/**
 * Printer is a util tool for CLI output.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
public class Printer {

    /**
     * outputs given message(msg) with line change at the end.
     * 
     * @param msg String format message given.
     */
    public void printMsg(String msg) {
        System.out.println(msg);
    }

    /**
     * outputs given value with line change at the end.
     * @param value int value given.
     */
    public void printInt(int value) {
        System.out.println(value);
    }

    /**
     * outputs given value with line change at the end.
     * @param value double value given.
     */
    public void printDouble(double value) {
        System.out.println(value);
    }

    /**
     * outputs given value without line change at the end.
     * @param msg   String  Message given in String format.
     */
    public void printMsgWithoutLn(String msg) {
        System.out.print(msg);
    }
}

// End of File
