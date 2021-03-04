/**
 * CustomYarn is used as the yarn to be fitted in place of the instructional
 * yarn. It is inherited from BaseYarn class.
 */
public class CustomYarn extends BaseYarn {

    /**
     * is the constructor. 
     * @param weight    int     The weight (per ball or skein) of the yarn to be
     *                          used.
     * @param meterage  int     The meterage (per ball or skein) of the yarn to
     *                          be used.
     */
    public CustomYarn(int weight, int meterage) {
        super(weight, meterage);
    }

}

// End of File.
