package dataStructures;

import java.util.Comparator;

/**
 * Created by Stefano on 17/02/2017.
 */
public class BackwardComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        if(o1.backwardStar.size() < o2.backwardStar.size())
        {
            return -1;
        }
        else if(o1.backwardStar.size() > o2.backwardStar.size())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
