import dataStructures.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Stefano on 17/02/2017.
 */
public class BackwardSolver {
    private static NodePriorityQueue leafNodes;
    private static NodePriorityQueue unfixed;
    private static Node school;
    private static Comparator<Node> fwd_cmp = new ForwardComparator();
    private static Comparator<Node> bck_cmp = new BackwardComparator();
    private static boolean changed = false;

    public static void solve()
    {
        setup();
        leafNodes.sort();

        while( !unfixed.isEmpty() )
        {
            changed = false;

            // Add to solution nodes that have no feasible outgoing arc
            addCompulsory();

            // If there are, try to expand leaf nodes
            while (!leafNodes.isEmpty()) {
                NodeCollection.reduceForwardStars();
                NodeCollection.reduceBackwardStars();
                Node toAnalyze = leafNodes.pop();
                analyze(toAnalyze);
                leafNodes.sort();
                changed = true;
            }

            // If none of the previous procedures changes the solution, choose a node to add
            if( !changed )
            {
                //attachLessRisky();
                attachClosest();
            }
        }
    }

    private static void setup()
    {
        new Solution();
        school = Parameters.getSchool();

        // Leaves are sorted to get first those with narrower BS
        leafNodes = new NodePriorityQueue();
        leafNodes.setComparator( bck_cmp );

        // Unfixed are sorted to get first those with narrower FS
        unfixed = new NodePriorityQueue();
        unfixed.setQueue( NodeCollection.getNodes() );
        unfixed.setComparator( fwd_cmp );

        // Sets up feasible stars for the nodes
        NodeCollection.setStars();
        NodeCollection.reduceForwardStars();
        NodeCollection.reduceBackwardStars();
    }

    /*
     * Analyzes the backward star of a node to select which node attach to it
     */
    private static void analyze(Node head)
    {
        if( head.backwardStar.isEmpty() )
        {
            return;
        }

        NodePriorityQueue backwardStar = new NodePriorityQueue();
        backwardStar.setQueue(head.backwardStar);
        backwardStar.setComparator( fwd_cmp );


        //Backward star is sorted to get first the node with least possible connections
        backwardStar.sort();
        Node tail = backwardStar.pop();

        addToSolution(tail,head);
    }

/*
    private static int getLessConstraining( Node head )
    {
        List<Node> bs = head.backwardStar;
        double min_percentage = 1.0; // potential_path / max_feasible
        int index;
        int out = 0;

        for(index = 0; index < bs.size(); index++)
        {
            Node candidate = bs.get(index);
            double potential_distance = candidate.distance( head ) + head.pathToSchool;
            double max_feasible = candidate.distanceFromSchool * Parameters.getAlpha();
            double p = potential_distance / max_feasible;

            if( p < min_percentage )
            {
                out = index;
                min_percentage = p;
            }
        }
        return out;
    }
*/
    /*
     * Looks for nodes that can only be attached directly to the school and adds the arcs to the solution
     */
    private static void addCompulsory()
    {
        boolean stop = false;

        unfixed.sort();
        while( !stop && !unfixed.isEmpty() )
        {
            Node n = unfixed.pop();
            if(n.forwardStar.size() == 0)
            {
                addToSolution(n, school);
            }
            else
            {
                stop = true;
                unfixed.add(n);
            }
        }
    }

    private static void attachClosest()
    {
        int index = getClosest();
        Node tail = unfixed.get(index);

        addToSolution(tail, school);
    }

    private static int getClosest()
    {
        double min_dist = Double.MAX_VALUE;
        int out = 0;
        for(int index=0; index < unfixed.size(); index++)
        {
            Node n = unfixed.get(index);
            double dist = n.distance(school);
            if( dist < min_dist)
            {
                out = index;
                min_dist = dist;
            }
        }
        return out;
    }

    private static void attachLessRisky()
    {
        while( !unfixed.isEmpty() )
        {
            Node tail = unfixed.pop();
            int index = getLessRisky(tail, tail.forwardStar);
            Node head = tail.forwardStar.get(index);

            addToSolution(tail, head);
        }

    }

    private static int getLessRisky(Node n, List<Node> candidates)
    {
        int out = 0;
        int i;
        double minRisk = Double.MAX_VALUE;

        for(i=0; i<candidates.size(); i++)
        {
            Node next = candidates.get(i);
            double risk = Parameters.getDanger(n.index, next.index);
            if(risk < minRisk)
            {
                out = i;
                minRisk = risk;
            }
        }

        return out;
    }

    /*
     * Add the arc to the solution and modifies the interested nodes
     */
    public static void addToSolution(Node tail, Node head)
    {
        tail.setFixed(head);
        unfixed.remove(tail);

        leafNodes.add(tail);
        Solution.add( tail.index, head.index );

        changed = true;
        NodeCollection.reduceForwardStars();
        NodeCollection.reduceBackwardStars();
    }
}
