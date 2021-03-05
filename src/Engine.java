import java.util.*;

/**
 * Engine is used to run the UI, and the program at CLI.
 */
public class Engine {

    private Scanner scanner;
    private Printer printer;

    public Engine() {
        this.scanner = new Scanner(System.in);
        this.printer = new Printer();
    }


    public void run() {
        boolean isOn = true;

        while (isOn) {
            printer.printMsg("Revving");
            isOn = false;
        }
    }
}

// End of File.
