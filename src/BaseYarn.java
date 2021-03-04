import java.util.*;
import java.util.Map.Entry;


/**
 * BaseYarn is an abstract superclass for yarn.
 */
public abstract class BaseYarn {
    /**
     * DEFAULT_WEIGHT_HUNDRED is a standard weight in grams for a ball or
     * a skein of yarn.
     */
    public static final int DEFAULT_WEIGHT_HUNDRED = 100;
    /**
     * DEFAULT_WEIGHT_FIFTY is a standard weight in grams for a ball or
     * a skein of yarn.
     */
    public static final int DEFAULT_WEIGHT_FIFTY = 50;
    /**
     * DEFAULT_WEIGHT_TWENTYFIVE is a standard weight in grams for a ball or
     * a skein of yarn.
     */
    public static final int DEFAULT_WEIGHT_TWENTYFIVE = 25;


    private final int UNDEFINED_INT = -1;

    /**
     * is the weight (in grams) of the ball or skein of yarn.
     * Value is rounded int as there is no need for more precise value.
     */
    private int weight;

    /**
     * is the meterage (in meters) of the ball or skein of yarn.
     * Value is rounded to int as there is no need for more precise value.
     */
    private int meterage;

    /**
     * is the YarnType of the yarn.
     * Value is based on the thickness of the yarn (meters per 100 grams).
     */
    private YarnType yarnType;

    /**
     * is the standard gauge, stitches per ten cm, for the yarn based on its 
     * type. YarnType.LACE is an exception, as it has no standard gauge.
     * 
     */
    private int[] gauge;


    /** Initate helper object meterageRange. */
    private MeterageRange meterageRange = new MeterageRange();

    /**
     * is the constructor, which sets the weight and meterage of yarn in 
     * question.
     * @param weight        int value of weight of the ball or skein of yarn.
     * @param meterage      int value of meterage of the ball or skein of yarn.
     */
    public BaseYarn(int weight, int meterage) {

        this.weight = weight;
        this.meterage = meterage;
        this.yarnType = this.getYarnTypeBasedOnMeterage();
        this.gauge = new Gauge().getGauge(this.yarnType);
    }

    /**
     * private inner class Gauge is used to set the gauge for yarn in question 
     * based on its YarnType.
     */
    private class Gauge {
        /**
         * Standard gauge ranges for yarn types.
         */
        private final int[] RANGE_FINGERING = {33, 40};
        private final int[] RANGE_SOCK = {27, 32};
        private final int[] RANGE_SPORT = {24, 26};
        private final int[] RANGE_DK = {21, 23};
        private final int[] RANGE_ARAN = {16, 20};
        private final int[] RANGE_CHUNKY = {12, 15};
        private final int[] RANGE_SUPER_CHUNKY = {7, 11};

        /** Use RANGE_UNDEFINED, if no gauge range is or can be defined. */
        private final int[] RANGE_UNDEFINED = {};

        /** Match YarnType to its standard gauge */
        HashMap <YarnType, int[]> gaugeRanges = new HashMap<YarnType, int[]>();

        /**
         * is constructor for private inner class.
         */
        public Gauge() {
            setGaugeRanges();
        }

        /**
         * sets key - value pairs matching YarnType for its standard gauge.
         * 
         * YarnType.LACE is an exception. It is of a very fine thickness and 
         * as such, usually knitted with some what bigger needles. Thus, its 
         * gauge has no standard value.
         */
        private void setGaugeRanges() {

            this.gaugeRanges.put(YarnType.LACE, this.RANGE_UNDEFINED);
            this.gaugeRanges.put(YarnType.FINGERING, this.RANGE_FINGERING);
            this.gaugeRanges.put(YarnType.SOCK, this.RANGE_SOCK);
            this.gaugeRanges.put(YarnType.SPORT, this.RANGE_SPORT);
            this.gaugeRanges.put(YarnType.DK, this.RANGE_DK);
            this.gaugeRanges.put(YarnType.ARAN, this.RANGE_ARAN);
            this.gaugeRanges.put(YarnType.CHUNKY, this.RANGE_CHUNKY);
            this.gaugeRanges
                .put(YarnType.SUPER_CHUNKY, this.RANGE_SUPER_CHUNKY);
        }

        /**
         * returns the range of the gauge for given YarnType.
         * If YarnType cannot be computed, returns an empty array.
         * @param _yarnType YarnType
         * @return          int[]
         */
        int[] getGauge(YarnType _yarnType) {
            Iterator<Entry<YarnType, int[]>> iterator = 
                this.gaugeRanges.entrySet().iterator();

            while(iterator.hasNext()) {
                Map.Entry<YarnType, int[]> mapElement = 
                    (Map.Entry<YarnType, int[]>)iterator.next();
            
                YarnType yarnType =  (YarnType) mapElement.getKey();

                if (_yarnType == yarnType) {
                    return (int[]) mapElement.getValue();
                }
                
            }
            return this.RANGE_UNDEFINED;
        } 
    }

    /**
     * returns YarnType based on the meterage in hundred grams.
     * If neither weight nor meterage is set, returns YarnType.UNDEFINED.
     * 
     * @return  YarnType
     */
    private YarnType getYarnTypeBasedOnMeterage() {

        if (this.weight != this.UNDEFINED_INT 
        && this.meterage != this.UNDEFINED_INT) {

            double metersPerHundredGrams = 
                ((double) this.meterage / this.weight) * DEFAULT_WEIGHT_HUNDRED;
            return this.meterageRange.getYarnType((int)metersPerHundredGrams);
        }
        return YarnType.UNDEFINED;
    }

    /**
     * returns YarnType.
     * @return  YarnType
     */
    public YarnType getYarnType() {
        return this.yarnType;
    }

    /**
     * returns weight of the yarn in grams.
     * @return  int
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * returns the meterage of the yarn in meters.
     * @return  int
     */
    public int getMeterage() {
        return this.meterage;
    }

    /**
     * returns the gauge of the yarn.
     * @return int[]
     */
    public int[] getGauge() {
        return this.gauge;
    }

}

// End of File.
