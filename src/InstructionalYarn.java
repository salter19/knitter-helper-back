/**
 * InstructionalYarn is used as the yarn given in the knitting instruction. It
 * is inherited from BaseYarn.
 * 
 * @author Terhi Salonen
 * @version 1.0
 */
public class InstructionalYarn extends BaseYarn {

    /**
     * is the constructor.
     * @param weight        int     The weight of the ball or skein of the yarn
     *                              in question.
     * @param meterage      int     The metrage of the ball or skein of the yarn
     *                              in question.
     */
    public InstructionalYarn(int weight, int meterage) {
        super(weight, meterage);
    }
}
    
// End of File.
