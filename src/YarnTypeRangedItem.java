import java.util.*;

class YarnTypeRangedItem {

    final double[] UNDEFINED_RANGE = {};    
    /**
     * is the collection that holds YarnTypes and matching ranges of needle size
    * as a key - value pair.
    */
    private HashMap<YarnType, double[]> ranges = 
        new HashMap<YarnType, double[]>();

    /**
     * sets elements into HashMap<YarnType, double[]> ranges.
     * 
     */
    private void setRanges(double[][] range) {
        ranges.put(YarnType.LACE, this.UNDEFINED_RANGE);
        ranges.put(YarnType.FINGERING, range[0]);
        ranges.put(YarnType.SOCK, range[1]);
        ranges.put(YarnType.SPORT, range[2]);
        ranges.put(YarnType.DK, range[3]);
        ranges.put(YarnType.ARAN, range[4]);
        ranges.put(YarnType.CHUNKY, range[5]);
        ranges.put(YarnType.SUPER_CHUNKY, range[6]);
    }
  
}
