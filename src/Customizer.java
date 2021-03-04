/**
 * Customizer is used to customize the knitting instruction to fit the custom
 * yarn instead of the yarn used in the instruction. 
 */
public class Customizer {

    /** is the width of the piece knitted in cm.*/
    private double widthInCm;
    
    /** is the gauge (stitches / 10 cm) with the yarn to be used. */
    private int customGauge;

    /** is the customized count of stitches needed. */
    private int customStitchCount;

    /**
     * is the constructor.
     * @param customYarn    CustomYarn      The yarn to be used.
     * @param instruction   Instruction     The instruction of the knit piece.
     */
    public Customizer(CustomYarn customYarn, Instruction instruction) {
        /** the smallest end of the gauge regarding the yarn to be used. */
        this.customGauge = customYarn.getGauge()[0];

        /** the width to aim at */
        this.widthInCm = instruction.getWidthInCm();


        int gaugeWidth = 10;

        /** lamda expression to implement functional interface Customizeable */
        Customizeable countStitches = 
            (double a, double b) -> a / gaugeWidth * b; 

        /** Call the above lamda expression */
        this.customStitchCount = 
            (int) countStitches
            .getCustomValue(this.widthInCm, this.customGauge);
    }

    /**
     * returns the customized stitch count.
     * @return  int The stitch count counted based on the custom yarn's gauge
     *              and width of the knit piece.
     */
    public int getCustomStitchCount() {
        return this.customStitchCount;
    }
    
}

// End of File.
