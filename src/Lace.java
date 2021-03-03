/**
 * Lace is a yarn type.
 * 
 * Yarn types are based on the thickness of the yarn.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
public class Lace extends BaseYarn {

    private final int DEFAULT_METERAGE = 800;
    
    /**
     *  Lace type yarn has no suggested needle size.
     */
    private final double[] UNDEFINED_NEEDLE_SIZE = {-1, -1};

    /**
     * Messages for exceptional state of needle size regarding
     * lace type of yarn.
     */
    private final String MSG_START = "Needle size for " 
                                    + YarnType.LACE 
                                    + " weight yarn is set by"
                                    + " the usage.";

    private final String MSG_GET_NEEDLE_SIZE = this.MSG_START 
                                            + "\nNo suggested"
                                            + " size available."; 
    private final String MSG_SET_NEEDLE_SIZE = this.MSG_START 
                                            + "\nCan\'t set size for "
                                            + YarnType.LACE;

    
    
    /**
     * is the constructor.
     */
    public Lace() {
        this.setUnitWeight(DEFAULT_WEIGHT);
        this.setMeterage(this.DEFAULT_METERAGE);
        setYarnType();
    }

    /**
     * is overridden as lace type of yarn has no 
     * suggested needle size.
     */
    @Override
    public void setNeedleSize(double[] size) {
        Printer p = new Printer();
        p.printMsg(this.MSG_SET_NEEDLE_SIZE);
    }

    /**
     * is overridden as lace type of yarn has no
     * suggested needle size.
     */
    @Override
    public double[] getNeedleSize() {
        Printer p = new Printer();
        p.printMsg(this.MSG_GET_NEEDLE_SIZE);
        return this.UNDEFINED_NEEDLE_SIZE;
    }
}

// End of File
