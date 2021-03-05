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

        printer.printMsg("Hello!\nThis is Stitch Counter 1.0");

        while (isOn) {
            input = getCommand();

            checkInputForNonCommand(input);

            isOn = checkInputForExitCommand(isOn, input); 

            if (isOn) {
                routeNextAction(input);
            }
            
        }
        scanner.close();
        System.exit(0);
    }


    /**
     * routes next action based on users command.
     */
    private void routeNextAction(String input) {

        if (input.equals(this.options.get(1))) {
            printer.printMsg("Set your chosen yarn");
            CustomYarn userYarn = getUserYarn();

            printer.printMsg("Set the instruction");
            Instruction instruction =  getInstruction();
            CustomCount(userYarn, instruction);

        } else if (input.equals(this.options.get(2))) {
            printer.printMsg("Set your chosen yarn");
            CustomYarn userYarn = getUserYarn();

            printer.printMsg("Set width counter");
            widthCounter(userYarn); 

        } else if (input.equals(this.options.get(3))) {
            printer.printMsg("invoke yarn type getter");
        } 
    }


    /**
     * counts the width achieved with given yarn and stitch count.
     * @param userYarn  CustomYarn  The yarn used for the knit piece.
     */
    private void widthCounter(CustomYarn userYarn) {
        printer.printMsg("\nWidth Counter");
        int gaugeWidth = 10;
        int stitchCount = -1;
        Customizeable countWidth = (a, b) -> a / b * gaugeWidth;

        printer.printMsgWithoutLn("Please, insert stitch count you need"
                                + " to convert to cm:\n> ");
        try {
            stitchCount = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Invalid value for stitch count.");
            System.err.println(e.getStackTrace());
        }
        if (stitchCount > 0) {

            int width = (int) countWidth.getCustomValue(stitchCount, userYarn.getGauge()[0]);

            printer.printMsg("The width with your yarn and given stitch"
                            + " count is approx.: " + width + " cm.");
        }
    }

    /**
     * is action option to output the custom stitch count for knit piece.
     * @param userYarn      CustomYarn      The yarn of the user.
     * @param instruction   Instruction     The instruction to be customized to
     *                                      fit user's yarn.
     */
    private void CustomCount(CustomYarn userYarn, Instruction instruction) {

        printer.printMsg("\nCustom Stitch Counter");

        if (userYarn != null && instruction != null) {
            Customizer customizer = new Customizer(userYarn, instruction);
            int customCount = customizer.getCustomStitchCount();

            printer.printMsg("The stitch count for your yarn is " 
                                + customCount 
                                + "\n(The stitch count in the instruction was " + instruction.getStitchCount() + ")");
        }
        
    }

    /**
     * returns CustomYarn object, if weight and meterage are acceptable.
     * Else returns null
     * @return  CustomYarn  Either CustomYarn based on weight and meterage
     *                      or null object.
     */
    private CustomYarn getUserYarn() {
        int weight;
        int meterage;
        CustomYarn userYarn;

        weight = this.getWeightFromUser();
        meterage = this.getMeterageFromUser();

        if (weight > 0 && meterage > 0) {
            userYarn = new CustomYarn(weight, meterage);
            printer.printMsg("Your yarn is " + userYarn.getYarnType());
        } else {
            return null;
        }
        return userYarn;
    }

    /**
     * returns Instruction object or null object depending on the given
     * instructional gauge and total stitch count.
     * @return  Instruction     Either Instruction based on gauge and total 
     *                          stitch count or null object.
     */
    private Instruction getInstruction() {
        int gauge = getGauge();
        int stitchCount = getTotalStitchCount();

        if (gauge > 0 && stitchCount > 0) {
            return new Instruction(gauge, stitchCount);
        }
        return null;
    }

    /**
     * returns total stitch count of the instruction.
     * @return  int     The total stitch count, or if cannot be computed, -1.
     */
    private int getTotalStitchCount() {
        int count = -1;
        printer.printMsgWithoutLn("Please, insert the amount of stitches in " 
                                + "the instruction in total:\n> ");

        try {
            // TODO: handle total stitch count zero
            count = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Not valid value for total stitch count");
            System.err.println(e.getStackTrace());
        }
        return count; 
    }

    /**
     * returns gauge for 10 cm or -1, if cannot compute.
     * @return int  The amount of stitches / 10 cm or -1, if cannot compute.
     */
    private int getGauge() {
        int gauge = -1;
        printer.printMsgWithoutLn("Please, insert the amount of stitches for "
                                + "10 cm (gauge) given in the instruction." 
                                + "\n> ");
        try {
            // TODO: handle stitches zero
            gauge = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Not valid value for stitch count for gauge.");
            System.err.println(e.getStackTrace());
        }

        return gauge;
    }


    /**
     * returns the initial meterage of the user's ball of yarn.
     * @return  int The meterage, returns -1, if not valid.
     */
    private int getMeterageFromUser() {
        int meterage = -1;
        printer.printMsgWithoutLn("Please insert the initial meterage of your yarn (meters):\n> ");

        try {
            // TODO: handle meterage zero
            meterage = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Not valid meterage.");
            System.err.println(e.getMessage());
        }
        return meterage;
    }


    /**
     * gets the initial weight of users ball of yarn.
     * @return  int The weight, returns -1, if not valid. 
     */
    private int getWeightFromUser() {
        
        printer.printMsgWithoutLn("Please insert the initial weight of your yarn (grams):\n> ");

        try {
            // TODO: handle weight zero
            return scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Not valid weight.");
            System.err.println(e.getMessage());
        }
        return -1;
    }


    /**
     * returns users command input.
     * @return  String  User input.
     */
    private String getCommand() {
        String input;
        printer.printMsg("\n" + this.CHOICES_MSG
        + "\n");
        printer.printMsgWithoutLn("What do you want to do?\n> ");
        input = scanner.nextLine();
        return input;
    }


    /**
     * checks whether the user has given a valid command. If so, outputs a
     * message informing the user and returns true.
     * @param   input   String      User input to be evaluated.
     * @return          boolean     Returns true if invalid command is given.
     */
    private boolean checkInputForNonCommand(String input) {
        if (!this.options.contains(input) 
            && !input.equals(this.options.get(0).toUpperCase())) {

            printer.printMsg("Invalid command, " + input + " cannot compute.");
            return true;
        }
        return false;
    }


    /**
     * checks whether the user wants to close the program.
     * @param isOn      boolean     Changes according to user input. State of
     *                              isOn is the value to be returned. 
     * @param input     String      User input.
     * @return          boolean     State of isOn after input valuation.
     */
    private boolean checkInputForExitCommand(boolean isOn, String input) {
        if ( input.equalsIgnoreCase(this.options.get(0)) ) {
            printer.printMsg("closing with command...");
            isOn = false;
        }
        return isOn;
    }
}

// End of File.
