package dataStructures;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Stefano on 09/02/2017.
 */
public class ArrayArcCollection implements ArcCollection{
    public List<Arc> arcs = new ArrayList<>();

    public ArrayArcCollection(){

    }

    @Override
    public void insertArc(Node head, Node tail) {
        double arcLenght = head.distance(tail);
        double d1 = tail.distance( ArrayNodeCollection.getInstance().getNode(0) );
        double d2 = head.distance( ArrayNodeCollection.getInstance().getNode(0));

        /*
        If going from the head to school through the head is too expensive, arc is not added
         */
        if ( Parameters.getInstance().getValue("ALPHA") * d2 > arcLenght + d1)
        {
            arcs.add( new Arc(head, tail));
        }
    }

    public Arc getArc(int index)
    {
        return arcs.get(index);
    }
}
