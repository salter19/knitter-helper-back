import java.util.*;
import java.util.Map.Entry;
/**
 * NeedleSizeRange is a class used for setting the standard needle size based 
 * on yarn thickness (yarn type). 
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
public class NeedleSizeRange extends YarnTypeRangedItem {
    
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

        final double[][] RANGES = { RANGE_FINGERING, RANGE_SOCK, RANGE_SPORT, RANGE_DK, RANGE_ARAN, RANGE_CHUNKY, RANGE_SUPER_CHUNKY };
        setRanges(RANGES);
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
     * gets YarnType based on the given needle size.
     * 
     * Compares given needleSize to rangesNeedleSize values and returns
     * key (YarnType) of the value range where given needle size resides.
     * Returns YarnType.UNDEFINED if given needle size cannot be found.
     * 
     * @param needleSize    double needle size given.
     * @return              YarnType
     */
    public YarnType getYarnType(double needleSize) {
        Iterator<Entry<YarnType, double[]>> iterator = 
            this.rangesNeedleSize.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<YarnType, double[]> mapElement = 
                (Map.Entry<YarnType, double[]>)iterator.next();
        
            double[] range =  (double[])mapElement.getValue();

            if (needleSize >= range[0] && needleSize <= range[1]) {
                return (YarnType) mapElement.getKey();
            }
        }
        return YarnType.UNDEFINED;
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

// End of File.
