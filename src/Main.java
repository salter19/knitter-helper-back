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
        BaseYarn instructionalYarn = 
            new InstructionalYarn(BaseYarn.DEFAULT_WEIGHT_FIFTY, 150);

        BaseYarn customYarn = 
            new CustomYarn(BaseYarn.DEFAULT_WEIGHT_TWENTYFIVE, 150);
        
        Printer p = new Printer();
        p.printMsg("" + instructionalYarn.getYarnType());
        p.printMsg("" + customYarn.getYarnType());
    }
}

// End of File
