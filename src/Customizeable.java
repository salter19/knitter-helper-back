/**
 * Customizeable is an interface for Objects that need a custom value counter.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
@FunctionalInterface
public interface Customizeable {
    /**
     * returns custom value (double) created based on two given values.
     * @param a double  The first value of the operation.
     * @param b double  The second value of the operation.
     * @return  double  The custom value.
     */
    double getCustomValue(double a, double b);
}

// End of File.
