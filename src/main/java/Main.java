import java.util.List;

import dataStructures.ArrayNodeCollection;
import dataStructures.Node;
import dataStructures.Parameters;
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
    
        for(int i=0; i< Parameters.getNumberOfNodes() + 1; i++)
        {
        
        	for(int j= 0; j< Parameters.getNumberOfNodes()+1; j++)
        		System.out.print(Parameters.getDanger(i, j) + " ");
        System.out.println();
        }
      }
}
