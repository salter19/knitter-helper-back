/**
 * This is the entry point class to run the program.
 * 
 * @author Terhi Salonen
 * @version 1.0
 * 
 */
public class Main {
    
    /**
     * Main method is the method that is used to run the program.
     * 
     * @param args    the command line arguments as a format
     *                of String array.
     */
    public static void main(String[] args) {

        Engine engine = new Engine();
        try {
            engine.run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

// End of File
