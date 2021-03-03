package src;

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
    private final float UNDEFINED_FLOAT = -1;
    /**
     * is the default value used until value is set.
     */
    private final YarnType UNDEFINED_YARN_TYPE = null;
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
    private float needleSize = this.UNDEFINED_FLOAT;
    /**
     * is a YarnType that descripes the yarn in 
     * standard yarn weight term.
     */
    private YarnType yarnType = this.UNDEFINED_YARN_TYPE;

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

    /**
     * sets YarnType if unitWeight and meterage are set.
     * YarnType is defined by ratio of meters per grams.
     */
    public void setYarnType() {

        if (this.unitWeight != this.UNDEFINED_INT 
        && this.meterage != this.UNDEFINED_INT) {

            double metersPerHundredGrams = ((double) this.meterage / this.unitWeight) * 100;
            System.out.println(metersPerHundredGrams);
        }
    }
}

// End of File
