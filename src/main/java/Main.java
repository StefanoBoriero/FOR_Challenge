import java.util.List;

import dataStructures.ArrayNodeCollection;
import dataStructures.Node;
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
        
        List<Node> nodes = ArrayNodeCollection.getInstance().getNodes();
        
        for (Node n : nodes)
        {
        	System.out.print("Node number " + n.index + " ");
        	System.out.println(n.toString());
        	
        }
    }
}
