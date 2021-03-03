package src;

/**
 * BaseYarn is an abstract superclass for different
 * types of yarn. 
 */
public abstract class BaseYarn {
    /**
     * is the weight of yarn skein or 
     * ball in grams. It is rounded to integer value.
     */
    private int unitWeight;
    /**
     * is the approximate length in meters of yarn per
     * skein or ball. It is rounded to integer value.
     */
    private int meterage;
    /**
     * is approximation of stitches per cm with given
     * needle size. It is rounded to integer value.
     */
    private int gaugeForTenCm;
    /**
     * is the suggested needle size in mm. It is 
     * a floating point value.
     */
    private float needleSize;
    /**
     * is a String that descripes the yarn in 
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
     * @param needleSize    float value of needle size.
     */
    public void setNeedleSize(float needleSize) {
        this.needleSize = needleSize;
    }

}

// End of File
