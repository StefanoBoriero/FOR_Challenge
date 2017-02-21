package dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefano on 09/02/2017.
 */
public class Node {
    public int x;
    public int y;
    public int index;
    public double distanceFromSchool;
    public List<Node> forwardStar;
    public List<Node> backwardStar;
    public double pathToSchool;
    public boolean isFixed = false;
    public boolean isLeaf = false;

    public Node(int index, int x, int y)
    {
    	this.index = index;
        this.x = x;
        this.y = y;

        this.forwardStar = new ArrayList<>();
        this.backwardStar = new ArrayList<>();

        if(index == 0)
        {
            this.distanceFromSchool = 0;
        }
        else
        {
            this.distanceFromSchool = distance(Parameters.getSchool());
        }

        this.pathToSchool = distanceFromSchool;
    }

    public Double distance(Node destination)
    {
        double a = Math.pow( this.x - destination.x, 2);
        double b = Math.pow( this.y - destination.y, 2);

        return Math.sqrt(a+b);
    }

    public void addToForwardStar(Node next)
    {
        this.forwardStar.add(next);
    }

    public void addToBackwardStar(Node prev)
    {
        this.backwardStar.add(prev);
    }

    @Override
    public String toString()
    {
        String out = "INDEX: "+ index + " COORD(" + x + "," + y + ")";
        return out;
    }

    public void setFixed(Node nextNode)
    {
        isFixed = true;
        pathToSchool = distance(nextNode) + nextNode.pathToSchool;
    }

    public void reduceForwardStar()
    {
        List<Node> toEliminate = new ArrayList<>();
        for(Node n:forwardStar)
        {
            double length = distance(n);
            if(Parameters.getAlpha() * this.distanceFromSchool < length + n.pathToSchool)
            {
                toEliminate.add(n);
            }
        }

        for(Node n: toEliminate)
        {
            forwardStar.remove(n);
        }
    }

    public void reduceBackwardStar()
    {
        List<Node> toEliminate =  new ArrayList<>();
        for(Node n: backwardStar) {
            if (n.isFixed) {
                toEliminate.add(n);
            }
            else
                {
                double length = distance(n);
                double alpha = Parameters.getAlpha();
                double max_feasible = alpha * n.distanceFromSchool;
                double potential = length + this.pathToSchool;
                if ( potential > max_feasible ) {
                    toEliminate.add(n);
                }
            }
        }

        for(Node n:toEliminate)
        {
            backwardStar.remove(n);
        }
    }

}
