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

}
