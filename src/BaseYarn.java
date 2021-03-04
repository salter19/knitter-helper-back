import java.util.*;
import java.util.Map.Entry;

/**
 * BaseYarn is an abstract superclass for different types of yarn.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */

public abstract class BaseYarn {

    /**
     * is the default value for a ball or skein of yarn.
     */
    static final int DEFAULT_WEIGHT = 100;
    /**
     * is the default value used until value is set.
     */
    private final int UNDEFINED_INT = -1;

    /**
     * is approximation of stitches per cm with given needle size. It is a tight
     * range with smallest stitches count and largest one.
     */
    private int[] gaugeForTenCm = new int[2];

    /** are meterage ranges for different yarn types. */
    private final int[] RANGE_LACE = { 600, 800 };
    private final int[] RANGE_FINGERING = { 500, 599 };
    private final int[] RANGE_SOCK = { 350, 499 };
    private final int[] RANGE_SPORT = { 250, 349 };
    private final int[] RANGE_DK = { 200, 249 };
    private final int[] RANGE_ARAN = { 120, 199 };
    private final int[] RANGE_CHUNKY = { 100, 119 };
    private final int[] RANGE_SUPER_CHUNKY = { 60, 99 };

    /**
     * is the collection that holds YarnTypes and matching ranges of meterage as a
     * key - value pair.
     */
    private HashMap<YarnType, int[]> rangesMetrage = new HashMap<>();

    /**
     * is the weight of yarn skein or ball in grams. It is rounded to integer value.
     * By default value is -1;
     */
    private int unitWeight = this.UNDEFINED_INT;
    /**
     * is the approximate length in meters of yarn per skein or ball. It is rounded
     * to integer value. By default value is -1;
     */
    private int meterage = this.UNDEFINED_INT;
    /**
     * is the suggested needle size in mm. It is an array with two values, smallest
     * and largest end of the scope.
     */
    private double[] needleSize = new double[2];
    /**
     * is a YarnType that descripes the yarn in standard yarn weight term.
     */
    private YarnType yarnType = YarnType.UNDEFINED;

    /**
     * is the constructor.
     */
    public BaseYarn() {
        this.setRangesMetrage();
    }

    /**
     * sets unitWeight for yarn.
     * 
     * @param unitWeight rounded to integer, the weight value of given skein or ball
     *                   of yarn.
     */
    public void setUnitWeight(int unitWeight) {
        this.unitWeight = unitWeight;
    }

    /**
     * sets meterage for yarn.
     * 
     * @param meterage rounded to integer, the length value of given skein or ball
     *                 of yarn.
     */
    public void setMeterage(int meterage) {
        this.meterage = meterage;
    }

    /**
     * sets the approximated number of stitches needed to cover ten cm in knit
     * surface.
     * 
     * @param start rounded to integer, the smallest number of stitches needed to
     *              cover ten cm in knit surface.
     * @param end   rounded to integer, the largest number of stitches needed to
     *              cover ten cm in knit surface.
     */
    public void setGaugeForTenCm(int start, int end) {
        this.gaugeForTenCm[0] = start;
        this.gaugeForTenCm[1] = end;
    }

    /**
     * sets suggested needle size for the yarn.
     * 
     * @param needleSize double[] with limit values of needle size.
     */
    public void setNeedleSize(double[] needleSize) {
        this.needleSize = needleSize;
    }

    /**
     * sets YarnType if unitWeight and meterage are set. YarnType is defined by
     * ratio of meters per grams.
     */
    public void setYarnType() {

        if (this.unitWeight != this.UNDEFINED_INT 
            && this.meterage != this.UNDEFINED_INT) {
            double metersPerHundredGrams = 
                ((double) this.meterage / this.unitWeight) * 100;
            this.yarnType = setYarnTypeByRatio((int) metersPerHundredGrams);
        }
    }

    /**
     * iterates through HashMap that holds YarnType as key and range of meterage for
     * that given YarnType as value (int[]) and searches for range where the given
     * value resides. If one is found, the key of the element is returned. If none
     * is found, YarnType.UNDEFINED is returned.
     * 
     * @param value int value of meters per hundred grams.
     * @return YarnType
     */
    private YarnType setYarnTypeByRatio(int value) {
        Iterator<Entry<YarnType, int[]>> iterator = 
            this.rangesMetrage.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<YarnType, int[]> mapElement = 
                (Map.Entry<YarnType, int[]>)iterator.next();
        
            int[] range =  (int[])mapElement.getValue();

            if (value >= range[0] && value <= range[1]) {
                return (YarnType) mapElement.getKey();
            }
            
        }
        return YarnType.UNDEFINED;
    }

    /**
     * sets elements into HashMap<YarnType, int[]> ranges.
     */
    private void setRangesMetrage() {
        rangesMetrage.put(YarnType.LACE, this.RANGE_LACE);
        rangesMetrage.put(YarnType.FINGERING, this.RANGE_FINGERING);
        rangesMetrage.put(YarnType.SOCK, this.RANGE_SOCK);
        rangesMetrage.put(YarnType.SPORT, this.RANGE_SPORT);
        rangesMetrage.put(YarnType.DK, this.RANGE_DK);
        rangesMetrage.put(YarnType.ARAN, this.RANGE_ARAN);
        rangesMetrage.put(YarnType.CHUNKY, this.RANGE_CHUNKY);
        rangesMetrage.put(YarnType.SUPER_CHUNKY, this.RANGE_SUPER_CHUNKY);
    }

    /**
     * returns unit weight rounded into int.
     * @return  int
     */
    public int getUnitWeight() {
        return this.unitWeight;
    }

    /**
     * returns meterage rounded into int.
     * @return  int
     */
    public int getMeterage() {
        return this.meterage;
    }

    /**
     * returns stitch count (gauge) for ten cm. 
     * int[] includes two values, the smallest count
     * and the largest one.
     * @return  int[]
     */
    public int[] getGauge() {
        return this.gaugeForTenCm;
    }

    /**
     * returns the suggested needle size.
     * @return  double[]
     */
    public double[] getNeedleSize() {
        return this.needleSize;
    }

    /**
     * returns YarnType of the yarn.
     * @return  YarnType
     */
    public YarnType getYarnType() {
        return this.yarnType;
    }

    /**
     * returns the YarnType in a string format.
     */
    @Override
    public String toString() {
        return this.yarnType + "";
    }
}

// End of File
