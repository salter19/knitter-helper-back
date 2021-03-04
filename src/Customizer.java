/**
 * Customizer is used to customize the knitting instruction to fit the custom
 * yarn instead of the yarn used in the instruction. 
 */
public class Customizer {

    /** is the yarn used in the instruction. */
    private InstructionalYarn yarn;

    /** is the count of stitches used in the instruction. */
    private int stitchCount;

    /** is the width of the piece knitted in cm.*/
    private double widthInCm;
    
    /** is the custom yarn to be used. */
    private CustomYarn customYarn;

    /** is the customized count of stitches needed. */
    private int customStitchCount;

    /**
     * is the constructor.
     * @param yarn          InstructionalYarn   The yarn in the instruction.
     * @param customYarn    CustomYarn          The yarn of the user.
     * @param widthInCm     double              The width (cm) to be knitted.
     */
    public Customizer(
        InstructionalYarn yarn, 
        CustomYarn customYarn, 
        double widthInCm) {

        this.yarn = yarn;
        this.customYarn = customYarn;
        this.widthInCm = widthInCm;
    }

    
}

// End of File.
