import dataStructures.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefano on 16/02/2017.
 */
public class Solver6 {
    public static Node school;

    static List<Node> leafNodes = new ArrayList<>();
    public static void solve()
    {
        new Solution();
        NodeCollection.setStars();
        NodePriorityQueue nodesToFix = new NodePriorityQueue();
        school = Parameters.getSchool();
        school.isFixed = true;
        school.isLeaf = true;
        school.pathToSchool = 0;
        nodesToFix.setQueue(NodeCollection.getNodes());
        nodesToFix.setComparator( new ForwardComparator() );
        nodesToFix.sort();

        while(!nodesToFix.isEmpty())
        {
            Node node = nodesToFix.pop();
            analyze(node);
            reduceForwardStars(nodesToFix);
            nodesToFix.sort();
        }

        return;
    }

    private static void analyze(Node node)
    {
        List<Node> fs = node.forwardStar;
        List<Node> leafCandidate = new ArrayList<>(fs.size());

        for(Node next: fs)
        {
            if(leafNodes.contains(next))
            {
                leafCandidate.add(next);
            }
        }
/*
        if(leafCandidate.size() == 0)
        {
            Node chosen = leafCandidate.get(0);
            chosen.isLeaf = false;
            node.isLeaf = true;
            node.isFixed = true;
            node.pathToSchool = node.distance(chosen) + chosen.pathToSchool;
            Solution.add(node.index, chosen.index);
        }
        */
        if(leafCandidate.size() > 0)
        {
            int i = getLessRisky(node, leafCandidate);
            Node chosen = leafCandidate.get(i);
            /*
            chosen.isLeaf = false;
            node.isLeaf = true;
            node.isFixed = true;
            node.pathToSchool = node.distance(chosen) + chosen.pathToSchool;
            Solution.add(node.index, chosen.index);
            */
            addToSolution(node, chosen);
        }
        else
        {
            /*
            Solution.add(node.index, school.index);
            node.isFixed = true;
            node.isLeaf = true;
            node.pathToSchool = node.distance(school);
            */
            addToSolution(node, school);
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

    private static void reduceForwardStars(NodePriorityQueue nodes)
    {
        for(Node n: nodes)
        {
            n.reduceForwardStar();
        }
    }

    public static void addToSolution(Node tail, Node head)
    {
        tail.setFixed(head);
        //unfixed.remove(tail);

        leafNodes.add(tail);
        Solution.add( tail.index, head.index );

        //changed = true;
        NodeCollection.reduceForwardStars();
        NodeCollection.reduceBackwardStars();
    }


}
