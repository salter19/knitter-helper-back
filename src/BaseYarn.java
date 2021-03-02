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
    /**
     * metrage is the approximate length in meters of yarn per
     * skein or ball. It is rounded to integer value.
     */
    /**
     * gauge is approximation of stitches per cm with given
     * needle size. It is rounded to integer value.
     */
    /**
     * needleSize is the suggested needle size in mm. It is 
     * a floating point value.
     */
    /**
     * weightType is a String that descripes the yarn in 
     * standard yarn weight term, if one can be applied.
     */
    private int unitWeight, meterage, gauge;
    private float needleSize;
    private String weightType;


}
