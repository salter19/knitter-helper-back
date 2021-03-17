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

    /** attribute for zero value */
    private final int ZERO = 0;

    /**
     * is constructor.
     */
    public Engine() {
        this.scanner = new Scanner(System.in);
        this.printer = new Printer();
        this.setOptionsArrayList();
    }


    /**
     * sets options from options_arr into options.
     */
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
            isOn = checkInputForExitCommand(isOn, input); 

            if (!checkInputForNonCommand(input) && isOn) {
                routeNextAction(input);
                isOn = false;
            } 
        }
        scanner.close();
        System.exit(0);
    }


    /**
     * routes next action based on users command.
     * 
     * @param input   String     User input. 
     */
    private void routeNextAction(String input) {

        if (input.equals(this.options.get(1))) {
            CustomYarn userYarn = userYarnSetter();

            printer.printMsg("Set the instruction");
            Instruction instruction =  getInstruction();
            CustomCount(userYarn, instruction);
            

        } else if (input.equals(this.options.get(2))) {
            CustomYarn userYarn = userYarnSetter();

            printer.printMsg("Set the width counter");

            try {
                widthCounter(userYarn);

            } catch (YarnTypeException e) {
                e.printStackTrace();
                System.exit(1);
            } 

        } else if (input.equals(this.options.get(3))) {
            CustomYarn userYarn = userYarnSetter();

            printer.printMsg("The type of your yarn seems to be " 
                            + userYarn.getYarnType());
        } 
    }

    /**
     * sets CustomYarn object. 
     * @return  CustomYarn  The users yarn specs.
     */
    private CustomYarn userYarnSetter() {
        printer.printMsg("Set your chosen yarn");
        CustomYarn userYarn = getUserYarn();
        return userYarn;
    }

    /**
     * counts the width achieved with given yarn and stitch count. Throws
     * YarnTypeException if user yarn is lace type, as lace type yarn has
     * no approximated gauge.
     * @param userYarn              CustomYarn  The yarn used in the knitpiece.
     * @throws YarnTypeException    YarnTypeException  
     */
    private void widthCounter(CustomYarn userYarn) throws YarnTypeException {
        printer.printMsg("\nWidth Counter");
        int gaugeWidth = 10;
        int stitchCount = -1;
        Customizeable countWidth = (a, b) -> a / b * gaugeWidth;

        printer.printMsgWithoutLn("Please, insert stitch count you need"
                                + " to convert to cm:\n> ");

        try {
            stitchCount = scanner.nextInt();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(1);
        }

        if (stitchCount > 0 && userYarn.getYarnType() != YarnType.LACE ) {

            int width = (int) countWidth.getCustomValue(stitchCount, userYarn.getGauge()[0]);

            printer.printMsg("The width with your yarn and given stitch"
                            + " count is approx.: " + width + " cm.");

        } else if (userYarn.getYarnType() == YarnType.LACE) {

            throw new YarnTypeException("Lace weight yarn has no gauge approximation. No width can be counted.");
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

        try {
            weight = this.getWeightFromUser();
            meterage = this.getMeterageFromUser();
        } catch (ZeroStitchException e) {
            e.printStackTrace();
            System.exit(1);
        }

        if (weight > 0 && meterage > 0) {
            userYarn = new CustomYarn(weight, meterage);
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

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(1);
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

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(1);
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
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return meterage;
    }


    /**
     * gets the initial weight of users ball of yarn.
     * @throws  
     * @return  int                 The weight, returns -1, if not valid. 
     * @throws  ZeroStitchException The exception thrown, if weight given is 
     *                              zero or less.
     */
    private int getWeightFromUser() throws ZeroStitchException {
        
        printer.printMsgWithoutLn("Please insert the initial weight of your yarn (grams):\n> ");
        int res = -1;

        try {
            res = scanner.nextInt();

            if (res <= this.ZERO) {
                throw new ZeroStitchException("Given weight is zero, no stitch can be counted from that");
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return res;
    }


    /**
     * returns users command input.
     * @return  String  User input.
     */
    private String getCommand() {

        printer.printMsg("\n" + this.CHOICES_MSG
        + "\n");
        printer.printMsg("What do you want to do?");
        String input = this.scanner.nextLine();
        
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
