package src;

/**
 * BaseYarn is an abstract superclass for different
 * types of yarn. 
 */
public abstract class BaseYarn {
    /**
     * unitWeight is the weight of yarn skein or 
     * ball in grams. It is rounded to integer value.
     */
    private int unitWeight;
    /**
     * metrage is the approximate length in meters of yarn per
     * skein or ball. It is rounded to integer value.
     */
    private int meterage;
    /**
     * gauge is approximation of stitches per cm with given
     * needle size. It is rounded to integer value.
     */
    private int gauge;
    /**
     * needleSize is the suggested needle size in mm. It is 
     * a floating point value.
     */
    private float needleSize;
    /**
     * weightType is a String that descripes the yarn in 
     * standard yarn weight term, if one can be applied.
     */
    private String weightType;

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
}

// End of File
