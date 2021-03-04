/**
 * Sock is a yarn type.
 * 
 * Yarn types are based on the thickness of the yarn.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
public class Sock extends BaseYarn {

    /**
     * are standard default values for sock type of yarn.
     */
    private final int DEFAULT_METERAGE = 420;
    private final int MIN_STITCH_COUNT = 27;
    private final int MAX_STITCH_COUNT = 32;
    private final double MIN_NEEDLE_SIZE = 2;
    private final double MAX_NEEDLE_SIZE = 3;
    private final double[] NEEDLE_SIZE = 
        {this.MIN_NEEDLE_SIZE, this.MAX_NEEDLE_SIZE};

    /**
     * is the constructor.
     */
    public Sock() {
        setUnitWeight(DEFAULT_WEIGHT);
        setMeterage(this.DEFAULT_METERAGE);
        setGaugeForTenCm(this.MIN_STITCH_COUNT, this.MAX_STITCH_COUNT);
        setNeedleSize(this.NEEDLE_SIZE);
        setYarnType();
    }    
}

// End of File.
