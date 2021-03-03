/**
 * This is the entry point class to run the program.
 * 
 * @author Terhi Salonen
 * @version 1.0
 * 
 */
public class Main {
    /**
     * Main method is the method that is used to run the program.
     * 
     * @param args    the command line arguments as a format
     *                of String array.
     */
    public static void main(String[] args) {
        BaseYarn lace = new Lace();
        System.out.println(lace.getNeedleSize()[0]);

        BaseYarn sock = new Sock();
        System.out.println(sock.getNeedleSize()[0]);
        System.out.println(sock);
        
    }
}

// End of File
