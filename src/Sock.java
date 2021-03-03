class Sock extends BaseYarn {

    private final int DEFAULT_METERAGE = 420;
    private final int MIN_STITCH_COUNT = 27;
    private final int MAX_STITCH_COUNT = 32;
    private final double MIN_NEEDLE_SIZE = 2;
    private final double MAX_NEEDLE_SIZE = 3;
    private final double[] NEEDLE_SIZE = 
        {this.MIN_NEEDLE_SIZE, this.MAX_NEEDLE_SIZE};

    public Sock() {
        setUnitWeight(DEFAULT_WEIGHT);
        setMeterage(this.DEFAULT_METERAGE);
        setGaugeForTenCm(this.MIN_STITCH_COUNT, this.MAX_STITCH_COUNT);
        setNeedleSize(this.NEEDLE_SIZE);
    }    
}

// End of File.
