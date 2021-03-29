/**
 * MeterageRange is a class that matches YarnTypes to their meterage. 
 * Extends RangedItem.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
public class MeterageRange extends RangedItem {
    
    /** are meterage ranges for different yarn types. */
    private final double[] RANGE_LACE = { 600, 9999 };
    private final double[] RANGE_FINGERING = { 500, 599 };
    private final double[] RANGE_SOCK = { 350, 499 };
    private final double[] RANGE_SPORT = { 250, 349 };
    private final double[] RANGE_DK = { 200, 249 };
    private final double[] RANGE_ARAN = { 120, 199 };
    private final double[] RANGE_CHUNKY = { 100, 119 };
    private final double[] RANGE_SUPER_CHUNKY = { 60, 99 };


    /**
     * the constructor
     */
    public MeterageRange() {
        /** set ranges regarding yarn types */
        final double[][] RANGES = { RANGE_LACE, RANGE_FINGERING, RANGE_SOCK, RANGE_SPORT, RANGE_DK, RANGE_ARAN, RANGE_CHUNKY, RANGE_SUPER_CHUNKY };
        setRanges(RANGES);
    }
}

// End of File.
