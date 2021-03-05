import java.util.*;

/**
 * Engine is used to run the UI, and the program at CLI.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
public class Engine {

    /** Scanner used for CLI input */
    private Scanner scanner;

    /** Printer used for CLI output */
    private Printer printer;

    /**
     * is constructor.
     */
    public Engine() {
        this.scanner = new Scanner(System.in);
        this.printer = new Printer();
    }


    /**
     * is used to run the program until user chooses to close it.
     */
    public void run() {
        boolean isOn = true;

        while (isOn) {
            printer.printMsg("Revving");
            isOn = false;
        }
        scanner.close();
        System.exit(0);
    }
}

// End of File.
