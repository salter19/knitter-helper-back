/**
 * NeedleSizeRange is a class used for setting the standard needle size based 
 * on yarn thickness (yarn type). Extends from RangedItem.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
public class NeedleSizeRange extends RangedItem {
    
    /** are needle size (mm) ranges for different yarn types. */
    
    private final double[] RANGE_LACE = { 1, 2 };
    private final double[] RANGE_FINGERING = { 1, 2 };
    private final double[] RANGE_SOCK = { 2.25, 3.25 };
    private final double[] RANGE_SPORT = { 3.5, 3.75 };
    private final double[] RANGE_DK = { 4, 4.25 };
    private final double[] RANGE_ARAN = { 4.5, 5.5 };
    private final double[] RANGE_CHUNKY = { 6, 8 };
    private final double[] RANGE_SUPER_CHUNKY = { 9, 13 };
    
    /**
     * is the constructor.
     */
    public NeedleSizeRange() {

        /** Set needle size ranges based on yarn type */
        final double[][] RANGES = { RANGE_LACE, RANGE_FINGERING, RANGE_SOCK, RANGE_SPORT, RANGE_DK, RANGE_ARAN, RANGE_CHUNKY, RANGE_SUPER_CHUNKY };
        setRanges(RANGES);
    }
}

// End of File.
