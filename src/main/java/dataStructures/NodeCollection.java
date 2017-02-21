package dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefano on 09/02/2017.
 */
public class NodeCollection {
    private static List<Node> nodes;

    public NodeCollection()
    {
        nodes = new ArrayList<>( Parameters.getNumberOfNodes() );
    }

    public static void insertNode(Node newNode)
    {
        nodes.add(newNode);
    }

    public static void reduceForwardStars()
    {
        for(Node n:nodes)
        {
            n.reduceForwardStar();
        }
    }

    public static void reduceBackwardStars()
    {
        for(Node n:nodes)
        {
            n.reduceBackwardStar();
        }
    }

    public static List<Node> getNodes()
    {
        ArrayList<Node> clone = new ArrayList<>( nodes.size() );

        for(Node n:nodes)
        {
            clone.add(n);
        }
        return clone;
    }

    public static void setStars()
    {
        int i;
        int j;

        for(i=0; i<nodes.size(); i++)
        {
            Node n1 = nodes.get(i);
            for( j=0; j < nodes.size(); j++)
            {
                if( i != j) {
                    Node n2 = nodes.get(j);

                    n1.addToForwardStar(n2);
                    n1.addToBackwardStar(n2);
                }
            }
        }
    }


}
