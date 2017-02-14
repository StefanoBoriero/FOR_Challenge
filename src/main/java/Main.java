import file.DataParser;

/**
 * Created by Stefano on 17/01/2017.
 */
public class Main {
    public static void main(String[] args)
    {
        //String filename = args[0];

        String filename = "pedibus_10.dat";
        DataParser.parse(filename);
    }
}
