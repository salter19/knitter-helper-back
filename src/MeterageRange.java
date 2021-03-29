import java.util.*;
import java.util.Map.Entry;

/**
 * MeterageRange is a class that matches YarnTypes to their meterage.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
public class MeterageRange {
    
    /** are meterage ranges for different yarn types. */
    private final double[] RANGE_LACE = { 600, 9999 };
    private final double[] RANGE_FINGERING = { 500, 599 };
    private final double[] RANGE_SOCK = { 350, 499 };
    private final double[] RANGE_SPORT = { 250, 349 };
    private final double[] RANGE_DK = { 200, 249 };
    private final double[] RANGE_ARAN = { 120, 199 };
    private final double[] RANGE_CHUNKY = { 100, 119 };
    private final double[] RANGE_SUPER_CHUNKY = { 60, 99 };

    private final double[] UNDEFINED_RANGE = {};

    /**
     * is the collection that holds YarnTypes and matching ranges of meterage
     * as a key - value pair.
     */
    private HashMap<YarnType, double[]> rangesMeterage = 
        new HashMap<YarnType, double[]>();

    /**
     * is the constructor.
     * 
     * Sets rangesMeterage keys and values.
     */
    public MeterageRange() {
        setRangesMetrage();
    }

    /**
     * returns the meterage range of given YarnType.
     * @param   yarnType  YarnType given.
     * @return  double[]
     */
    public double[] getRange(YarnType yarnType) {
        Iterator<Entry<YarnType, double[]>> iterator = 
            this.rangesMeterage.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<YarnType, double[]> mapElement = 
                (Map.Entry<YarnType, double[]>)iterator.next();
        
            YarnType yarn = (YarnType)mapElement.getKey();

            if (yarnType == yarn) {
                return (double[]) mapElement.getValue();
            }
            
        }
        return this.UNDEFINED_RANGE;
    }

    /**
     * gets YarnType based on the given meterage.
     * 
     * Compares given meterage to rangesMeterage values and returns
     * key (YarnType) of the value range where given meterage resides.
     * Returns YarnType.UNDEFINED if given meterage cannot be found.
     * 
     * @param meterage  int given meterage to be compared.
     * @return          YarnType
     */
    public YarnType getYarnType(double meterage) {
        Iterator<Entry<YarnType, double[]>> iterator = 
            this.rangesMeterage.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<YarnType, double[]> mapElement = 
                (Map.Entry<YarnType, double[]>)iterator.next();
        
            double[] range =  (double[])mapElement.getValue();

            if (meterage >= range[0] && meterage <= range[1]) {
                return (YarnType) mapElement.getKey();
            }
        }
        return YarnType.UNDEFINED;
    }

    /**
     * sets elements into HashMap<YarnType, double[]> rangesMeterage.
     */
    private void setRangesMetrage() {
        rangesMeterage.put(YarnType.LACE, this.RANGE_LACE);
        rangesMeterage.put(YarnType.FINGERING, this.RANGE_FINGERING);
        rangesMeterage.put(YarnType.SOCK, this.RANGE_SOCK);
        rangesMeterage.put(YarnType.SPORT, this.RANGE_SPORT);
        rangesMeterage.put(YarnType.DK, this.RANGE_DK);
        rangesMeterage.put(YarnType.ARAN, this.RANGE_ARAN);
        rangesMeterage.put(YarnType.CHUNKY, this.RANGE_CHUNKY);
        rangesMeterage.put(YarnType.SUPER_CHUNKY, this.RANGE_SUPER_CHUNKY);
    }

}

// End of File.
