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

}
