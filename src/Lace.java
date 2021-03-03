public class Lace extends BaseYarn {

    private final int DEFAULT_WEIGHT = 100;
    private final int DEFAULT_METERAGE = 800;
    private final double UNDEFINED = -1;

    private final String MSG_START = "Needle size for " 
                                    + YarnType.LACE 
                                    + " weight yarn is set by"
                                    + " the usage.";

    private final String MSG_GET_NEEDLE_SIZE = this.MSG_START 
                                            + "\nNo suggested"
                                            + " size available."; 
    private final String MSG_SET_NEEDLE_SIZE = this.MSG_START 
                                            + "\nCan\'t set size for "
                                            + YarnType.LACE;

    
    
    public Lace() {
        this.setUnitWeight(this.DEFAULT_WEIGHT);
        this.setMeterage(this.DEFAULT_METERAGE);
    }

    @Override
    public void setNeedleSize(double size) {
        Printer p = new Printer();
        p.printMsg(this.MSG_SET_NEEDLE_SIZE);
    }

    @Override
    public double getNeedleSize() {
        Printer p = new Printer();
        p.printMsg(this.MSG_GET_NEEDLE_SIZE);
        return this.UNDEFINED;
    }
}

// End of File
