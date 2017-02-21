package dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefano on 09/02/2017.
 */
public class ArrayNodeCollection {
    private static ArrayNodeCollection instance;
    private List<Node> nodes;

    public ArrayNodeCollection()
    {
         nodes = new ArrayList<>( Parameters.getNumberOfNodes() );
    }

    public Node getNode(int index){
        return nodes.get(index);
    }

    public static ArrayNodeCollection getInstance(){
        if(instance == null){
            instance = new ArrayNodeCollection();
        }
        return instance;
    }

    public void add(int index, Node n)
    {
        nodes.add(n);
    }
    
    public List<Node> getNodes()
    {
    	return this.nodes;
    }

    public void setStars()
    {
        for(Node head: nodes)
        {
            addToStar(head, Parameters.getSchool());
            for(Node tail: nodes)
            {
                if(head != tail)
                {
                    addToStar(head, tail);
                }
            }
        }
    }
    private void addToStar(Node head, Node tail) {
        double arcLenght = head.distance(tail);
        double d1 = head.distance( Parameters.getSchool() );
        double d2 = tail.distance( Parameters.getSchool() );

        /*
        If going from the head to school through the head is too expensive, arc is not added
         */
        if ( Parameters.getAlpha() * d2 > arcLenght + d1)
        {
            tail.addToForwardStar( head );
            head.addToBackwardStar( tail );
        }
    }


}
