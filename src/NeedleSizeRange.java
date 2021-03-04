import java.util.*;
import java.util.Map.Entry;

public class NeedleSizeRange {
    
    /** are needle size (mm) ranges for different yarn types. */
    // private final int[] RANGE_LACE = { 600, 9999 };
    private final double[] RANGE_FINGERING = { 1, 2 };
    private final double[] RANGE_SOCK = { 2.25, 3.25 };
    private final double[] RANGE_SPORT = { 3.5, 3.75 };
    private final double[] RANGE_DK = { 4, 4.25 };
    private final double[] RANGE_ARAN = { 4.5, 5.5 };
    private final double[] RANGE_CHUNKY = { 6, 8 };
    private final double[] RANGE_SUPER_CHUNKY = { 9, 13 };

    private final double[] UNDEFINED_RANGE = {}; 
    
    /**
    * is the collection that holds YarnTypes and matching ranges of needle size
    * as a key - value pair.
    */
    private HashMap<YarnType, double[]> rangesNeedleSize = 
        new HashMap<YarnType, double[]>();

    /**
     * is the constructor.
     */
    public NeedleSizeRange() {
        setRangesNeedleSize();
    }
    /**
     * returns the standard needle size range of given YarnType.
     * @param   yarnType  YarnType given.
     * @return  double[]
     */
    public double[] getRange(YarnType yarnType) {
        Iterator<Entry<YarnType, double[]>> iterator = 
            this.rangesNeedleSize.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<YarnType, double[]> mapElement = 
                (Map.Entry<YarnType, double[]>)iterator.next();
        
            YarnType yarn = (YarnType)mapElement.getKey();

            if (yarnType == yarn) {
                return (double[]) mapElement.getValue();
            } 
        }
        return this.UNDEFINED_RANGE;
    }

    /**
     * sets elements into HashMap<YarnType, double[]> rangesNeedleSize.
     * 
     */
    private void setRangesNeedleSize() {
        rangesNeedleSize.put(YarnType.LACE, this.UNDEFINED_RANGE);
        rangesNeedleSize.put(YarnType.FINGERING, this.RANGE_FINGERING);
        rangesNeedleSize.put(YarnType.SOCK, this.RANGE_SOCK);
        rangesNeedleSize.put(YarnType.SPORT, this.RANGE_SPORT);
        rangesNeedleSize.put(YarnType.DK, this.RANGE_DK);
        rangesNeedleSize.put(YarnType.ARAN, this.RANGE_ARAN);
        rangesNeedleSize.put(YarnType.CHUNKY, this.RANGE_CHUNKY);
        rangesNeedleSize.put(YarnType.SUPER_CHUNKY, this.RANGE_SUPER_CHUNKY);
    }
}
