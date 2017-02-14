import dataStructures.ArrayNodeCollection;
import dataStructures.Node;
import dataStructures.Parameters;
import dataStructures.Solution;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Stefano on 12/02/2017.
 */
public class Solver {

    public static void solve()
    {
        int non = Parameters.getNumberOfNodes();
        Solution solution = new Solution();
        List<Node> fixedNodes = new ArrayList<>(); //Nodes which exiting arc has been determined
        List<Node> nodesToFix = new ArrayList<>(); //Nodes which exiting arc hasn't been chosen yet

        nodesToFix.remove(0); //Removing School from the nodes to work on
        nodesToFix = ArrayNodeCollection.getInstance().getNodes();
        updateFixed(nodesToFix, fixedNodes);
        reduceForwardStar(nodesToFix);
        search(nodesToFix, fixedNodes);
    }

    /*
    If a node has only one possible output arc, that arc is added to the solution
    and the node is moved from a queue to the other
     */
    private static void updateFixed(List<Node> nodesToFix, List<Node> fixedNodes)
    {
        List<Node> nodesToRemove = new ArrayList<>();
        for(Node n: nodesToFix)
        {
            if(n.forwardStar.size() == 1)
            {
                Solution.add(n.index, n.forwardStar.get(0).index);
                n.setFixed(n.forwardStar.get(0));
                nodesToRemove.add(n);
                fixedNodes.add(n);
            }
        }

        for(Node n: nodesToRemove)
        {
            nodesToFix.remove(n);
        }
        return;
    }

    private static void reduceForwardStar(List<Node> nodes)
    {
        for(Node n:nodes)
        {
            n.reduceForwardStar();
        }
    }

    /*
    Searches in the BS of fixed nodes to create a longer branch
     */
    private static void search(List<Node>nodesToFix ,List<Node> fixedNodes)
    {
        List<Node> candidateList = new ArrayList<>();

        for(Node n: nodesToFix)
        {
            for(Node next: n.forwardStar)
            {
                if(next.isFixed)
                {
                    candidateList.add(next);
                }
            }

            if( candidateList.isEmpty() )
            {
                n.setFixed( ArrayNodeCollection.getInstance().getNode(0));
                Solution.add(n.index, 0); //If no candidate is found, attach to the School
            }
            else
            {
                double minRisk = Double.MAX_VALUE;
                Node chosen = null;
                for(Node candidate: candidateList)
                {
                    double risk = Parameters.getDanger( n.index, candidate.index);
                    if( risk < minRisk)
                    {
                        chosen = candidate;
                        minRisk = risk;
                    }
                }
                n.setFixed(chosen);
                Solution.add( n.index, chosen.index);
            }

        }
    }
}
