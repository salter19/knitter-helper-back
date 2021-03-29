import java.util.*;
import java.util.Map.Entry;

/**
 * RangedItem is an item that has range that relates to a certain yarn type.
 */
class RangedItem {

    final double[] UNDEFINED_RANGE = {};    
    /**
     * is the collection that holds YarnTypes and matching ranges 
    * as a key - value pair.
    */
    private HashMap<YarnType, double[]> ranges = 
        new HashMap<YarnType, double[]>();

    /**
     * sets elements into HashMap<YarnType, double[]> ranges.
     * @param   double[][]  Range per yarn type.
     */
    void setRanges(double[][] range) {
        ranges.put(YarnType.LACE, range[0]);
        ranges.put(YarnType.FINGERING, range[1]);
        ranges.put(YarnType.SOCK, range[2]);
        ranges.put(YarnType.SPORT, range[3]);
        ranges.put(YarnType.DK, range[4]);
        ranges.put(YarnType.ARAN, range[5]);
        ranges.put(YarnType.CHUNKY, range[6]);
        ranges.put(YarnType.SUPER_CHUNKY, range[7]);
    }

    /**
     * returns the standard range of given YarnType.
     * @param   yarnType    YarnType given.
     * @return  double[]    Range to be returned.
     */
    public double[] getRange(YarnType yarnType) {
        Iterator<Entry<YarnType, double[]>> iterator = 
            this.ranges.entrySet().iterator();

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
     * gets YarnType based on the given item thickness.
     * 
     * Compares given itemThickness to ranges values and returns
     * key (YarnType) of the value range where given itemThickness resides.
     * Returns YarnType.UNDEFINED if given itemThickness cannot be found.
     * 
     * @param itemThickness     double   item thickness
     * @return                  YarnType
     */
    public YarnType getYarnType(double itemThickness) {
        Iterator<Entry<YarnType, double[]>> iterator = 
            this.ranges.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<YarnType, double[]> mapElement = 
                (Map.Entry<YarnType, double[]>)iterator.next();
        
            double[] range =  (double[])mapElement.getValue();

            if (itemThickness >= range[0] && itemThickness <= range[1]) {
                return (YarnType) mapElement.getKey();
            }
        }
        return YarnType.UNDEFINED;
    }
  
}
