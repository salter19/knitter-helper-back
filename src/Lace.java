package src;

public class Lace extends BaseYarn {

    private final int DEFAULT_WEIGHT = 100;
    private final int DEFAULT_METERAGE = 800;
    private final int[] PLY = {1, 2};
    
    public Lace() {
        this.setUnitWeight(this.DEFAULT_WEIGHT);
        this.setMeterage(this.DEFAULT_METERAGE);
        this.setNeedleSize(1.5);
        //this.setYarnType();
    }
}
