package dataStructures;

import java.util.Comparator;

/**
 * Created by Stefano on 16/02/2017.
 * Compares nodes by mean of their feasible forward star size.
 * The greater the forward star, the heavier the node
 */
public class ForwardComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2)
    {
        if(o1.forwardStar.size() < o2.forwardStar.size())
        {
            return -1;
        }
        else if(o1.forwardStar.size() > o2.forwardStar.size())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
