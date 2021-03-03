package src;

import java.util.*;
import src.YarnType;
/**
 * BaseYarn is an abstract superclass for different
 * types of yarn. 
 */

public abstract class BaseYarn {
    /**
     * is the default value used until value is set.
     */
    private final int UNDEFINED_INT = -1;
    /**
     * is the default value used until value is set.
     */
    private final double UNDEFINED_DOUBLE = -1;

    /** are meterage ranges for different yarn types. */
    private final int[] RANGE_LACE = {600, 800};
    private final int[] RANGE_FINGERING = {500, 599};
    private final int[] RANGE_SOCK = {350, 499};
    private final int[] RANGE_SPORT = {250, 349};
    private final int[] RANGE_DK = {200, 249};
    private final int[] RANGE_ARAN = {120, 199};
    private final int[] RANGE_CHUNKY = {100, 119};
    private final int[] RANGE_SUPER_CHUNKY = {60,99};

    /** 
     * is the collection that holds YarnTypes and matching 
     * ranges of meterage as a key - value pair.
     */
    private HashMap<YarnType, int[]> ranges = new HashMap<>();

    /**
     * is the weight of yarn skein or 
     * ball in grams. It is rounded to integer value.
     * By default value is -1;
     */
    private int unitWeight = this.UNDEFINED_INT;
    /**
     * is the approximate length in meters of yarn per
     * skein or ball. It is rounded to integer value.
     * By default value is -1;
     */
    private int meterage = this.UNDEFINED_INT;
    /**
     * is approximation of stitches per cm with given
     * needle size. It is rounded to integer value.
     * By default value is -1;
     */
    private int gaugeForTenCm = this.UNDEFINED_INT;
    /**
     * is the suggested needle size in mm. It is 
     * a floating point value.
     * By default value is -1;
     */
    private double needleSize = this.UNDEFINED_DOUBLE;
    /**
     * is a YarnType that descripes the yarn in 
     * standard yarn weight term.
     */
    private YarnType yarnType = YarnType.UNDEFINED;

    public BaseYarn() {
        this.setRanges();
    }

    /**
     * sets unitWeight for yarn.
     * @param unitWeight    rounded to integer, the weight value of
     *                      given skein or ball of yarn.
     */
    public void setUnitWeight(int unitWeight) {
        this.unitWeight = unitWeight;
    }

    /**
     * sets meterage for yarn.
     * @param meterage  rounded to integer, the length value of
     *                  given skein or ball of yarn.
     */
    public void setMeterage(int meterage) {
        this.meterage = meterage;
    }

    /**
     * sets the approximated number of stitches needed to 
     * cover ten cm in knit surface.
     * 
     * @param stitchCount   rounded to integer, the number of
     *                      stitches for ten cm in knit.
     */
    public void setGaugeForTenCm(int stitchCount) {
        this.gaugeForTenCm = stitchCount;
    }

    /**
     * sets suggested needle size for the yarn.
     * @param needleSize    double value of needle size.
     */
    public void setNeedleSize(double needleSize) {
        this.needleSize = needleSize;
    }

    /**
     * sets YarnType if unitWeight and meterage are set.
     * YarnType is defined by ratio of meters per grams.
     */
    public void setYarnType() {

        if (this.unitWeight != this.UNDEFINED_INT 
        && this.meterage != this.UNDEFINED_INT) {
            double metersPerHundredGrams = ((double) this.meterage / this.unitWeight) * 100;
            this.yarnType = setYarnTypeByRatio((int)metersPerHundredGrams);
        }
    }

    /**
     * iterates through HashMap that holds YarnType as key and range
     * of meterage for that given YarnType as value (int[]) and searches 
     * for range where the given value resides. If one is found, the key 
     * of the element is returned. If none is found, YarnType.UNDEFINED 
     * is returned.
     * @param value int value of meters per hundred grams.
     * @return      YarnType
     */
    private YarnType setYarnTypeByRatio(int value) {
        Iterator iterator = this.ranges.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)iterator.next();
        
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
    private void setRanges() {
        ranges.put(YarnType.LACE, this.RANGE_LACE);
        ranges.put(YarnType.FINGERING, this.RANGE_FINGERING);
        ranges.put(YarnType.SOCK, this.RANGE_SOCK);
        ranges.put(YarnType.SPORT, this.RANGE_SPORT);
        ranges.put(YarnType.ARAN, this.RANGE_ARAN);
        ranges.put(YarnType.CHUNKY, this.RANGE_CHUNKY);
        ranges.put(YarnType.SUPER_CHUNKY, this.RANGE_SUPER_CHUNKY);
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
}

// End of File
