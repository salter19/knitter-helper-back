import java.util.HashMap;

public class MeterageRange {
    
    /** are meterage ranges for different yarn types. */
    private final int[] RANGE_LACE = { 600, 800 };
    private final int[] RANGE_FINGERING = { 500, 599 };
    private final int[] RANGE_SOCK = { 350, 499 };
    private final int[] RANGE_SPORT = { 250, 349 };
    private final int[] RANGE_DK = { 200, 249 };
    private final int[] RANGE_ARAN = { 120, 199 };
    private final int[] RANGE_CHUNKY = { 100, 119 };
    private final int[] RANGE_SUPER_CHUNKY = { 60, 99 };

    /**
     * is the collection that holds YarnTypes and matching ranges of meterage
     * as a key - value pair.
     */
    private HashMap<YarnType, int[]> rangesMetrage = 
        new HashMap<YarnType, int[]>();

    public MeterageRange() {
        setRangesMetrage();

    }

    public void getRange(YarnType yarnType) {
        
    }

    /**
     * sets elements into HashMap<YarnType, int[]> rangesMeterage.
     */
    private void setRangesMetrage() {
        rangesMetrage.put(YarnType.LACE, this.RANGE_LACE);
        rangesMetrage.put(YarnType.FINGERING, this.RANGE_FINGERING);
        rangesMetrage.put(YarnType.SOCK, this.RANGE_SOCK);
        rangesMetrage.put(YarnType.SPORT, this.RANGE_SPORT);
        rangesMetrage.put(YarnType.DK, this.RANGE_DK);
        rangesMetrage.put(YarnType.ARAN, this.RANGE_ARAN);
        rangesMetrage.put(YarnType.CHUNKY, this.RANGE_CHUNKY);
        rangesMetrage.put(YarnType.SUPER_CHUNKY, this.RANGE_SUPER_CHUNKY);
    }

}
