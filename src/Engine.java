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

    /** User's options */
    private final String CHOICES_MSG = "Your choices are:\n" 
                                    + "[1] Get custom stitch count\n" 
                                    + "[2] Get width\n" 
                                    + "[3] Get yarn type\n" 
                                    + "[x] Close program";
    private final String[] options_arr = { "x", "1", "2", "3" };
    private final List<String> options = new ArrayList<String>();

    /**
     * is constructor.
     */
    public Engine() {
        this.scanner = new Scanner(System.in);
        this.printer = new Printer();
        this.setOptionsArrayList();
    }


    private void setOptionsArrayList() {

        for(String s : this.options_arr) {
            this.options.add(s);
        }
    }


    /**
     * is used to run the program until user chooses to close it.
     */
    public void run() {
        boolean isOn = true;
        String input = "";

        printer.printMsg("Hello!\nThis is Stitch Counter 1.0\n");
        printer.printMsg(this.CHOICES_MSG);

        while (isOn) {
            input = getCommand();

            checkInputForNonCommand(input);

            isOn = checkInputForExit(isOn, input); 

            routeNextAction(isOn, input);
            
        }
        scanner.close();
        System.exit(0);
    }


    /**
     * routes next action based on users command.
     * @param isOn      boolean     If true, routing is taking place.
     * @param input     String      User input, the command.
     */
    private void routeNextAction(boolean isOn, String input) {
        if (isOn) {
            if (input.equals(this.options.get(1))) {
                printer.printMsg("invoke custom stitch counter");
            }
            if (input.equals(this.options.get(2))) {
                printer.printMsg("invoke width counter");
            }
            if (input.equals(this.options.get(3))) {
                printer.printMsg("invoke yarn type getter");
            }
        }
    }


    /**
     * returns users command input.
     * @return  String  User input.
     */
    private String getCommand() {
        String input;
        printer.printMsg("What do you want to do?");
        printer.printMsgWithoutLn("> ");
        input = scanner.nextLine();
        return input;
    }


    /**
     * checks whether the user has given a valid command. If so, outputs a
     * message informing the user and returns.
     * @param input String  User input to be evaluated.
     */
    private void checkInputForNonCommand(String input) {
        if (!this.options.contains(input) 
            && !input.equals(this.options.get(0).toUpperCase())) {

            printer.printMsg("Invalid command, cannot compute.");
            return;
        }
    }


    /**
     * checks whether the user wants to close the program.
     * @param isOn      boolean     Changes according to user input. State of
     *                              isOn is the value to be returned. 
     * @param input     String      User input.
     * @return          boolean     State of isOn after input valuation.
     */
    private boolean checkInputForExit(boolean isOn, String input) {
        if ( input.equalsIgnoreCase(this.options.get(0)) ) {
            printer.printMsg("closing with command...");
            isOn = false;
        }
        return isOn;
    }
}

// End of File.
