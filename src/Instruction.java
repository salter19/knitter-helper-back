/**
 * Instruction holds the instructional values of the knit piece.
 */
public class Instruction {

    /** is the number of stitches in the knit piece. */
    private int stitchCount;

    /** is the gauge that defines the stitch count. */
    private int gauge;

    /** is the width (cm) of the knit piece. */
    private double widthInCm;

    /**
     * is the constructor.
     * @param gauge         int The gauge in the instruction (stitches / 10 cm).
     * @param stitchCount   int The stitch count given in the instruction.
     */
    public Instruction( int gauge, int stitchCount ) {
        this.stitchCount = stitchCount;
        this.gauge = gauge;

        /** counts the width based on gauge and stitch count. */
        setWidthInCm();
    }

    /** counts the width in cm. */
    private void setWidthInCm() {
        int gaugeWidth = 10;
        this.widthInCm = (double) this.stitchCount / this.gauge * gaugeWidth;
    }

    /**
     * returns the stitch count.
     * @return  int
     */
    public int getStitchCount() {
        return this.stitchCount;
    }

    /**
     * returns the width in cm.
     * @return  double
     */
    public double getWidthInCm() {
        return this.widthInCm;
    }
}

// End of File.
