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

        CustomYarn customYarn = 
            new CustomYarn(BaseYarn.DEFAULT_WEIGHT_TWENTYFIVE, 50);
        
        Printer p = new Printer();
        p.printMsg("" + instructionalYarn.getYarnType());
        p.printMsg("" + customYarn.getYarnType());

        Customizer customizer = new Customizer(customYarn, new Instruction(17, 235));

        p.printMsg("customized stitch count: " 
                    + customizer.getCustomStitchCount()
                    + " (the original stitch count: 235)");

        Engine engine = new Engine();
        engine.run();
    }
}

// End of File
