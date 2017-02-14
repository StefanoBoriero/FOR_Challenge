package dataStructures;

/**
 * Created by Stefano on 09/02/2017.
 */
public class Node {
    public int x;
    public int y;
    public int index;

    public Node(int index, int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Double distance(Node destination)
    {
        double a = Math.pow( this.x - destination.x, 2);
        double b = Math.pow( this.y - destination.y, 2);

        return Math.sqrt(a+b);
    }

    @Override
    public String toString()
    {
        String out = "(" + x + "," + y + ")";
        return out;
    }
}
