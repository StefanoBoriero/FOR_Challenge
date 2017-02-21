package dataStructures;

import java.util.*;

/**
 * Created by Stefano on 16/02/2017.
 * Collection of nodes organized in a queue with a customizable priority
 */
public class NodePriorityQueue implements Iterable<Node>{
    private List<Node> queue= new ArrayList<>(Parameters.getNumberOfNodes());
    private Comparator<Node> cmp;

    public void sort()
    {
        Collections.sort(queue, cmp);
    }

    public Node pop()
    {
        return queue.remove(0);
    }

    public void setQueue(List<Node> nodes)
    {
        queue = nodes;
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    @Override
    public Iterator<Node> iterator() {
        return queue.iterator();
    }

    @Override
    public String toString()
    {
        String out = "";
        for(Node n: queue)
        {
            String fs = "";
            for(Node node: n.forwardStar)
            {
                fs = fs + node.index + ", ";
            }
            out = out + n.index + " FS: " + fs + " ";

            String bs = "";
            for(Node node: n.backwardStar)
            {
                bs = bs + node.index + ", ";
            }
            out = out + "BS: " + bs + "\n";
        }
        return out;
    }

    public void add(Node n)
    {
        queue.add(n);
    }

    public void setComparator(Comparator<Node> cmp)
    {
        this.cmp = cmp;
    }

    public int size(){
        return queue.size();
    }

    public void remove(Node n)
    {
        queue.remove(n);
    }

    public void reduceForwardStar()
    {
        for(Node n: queue)
        {
            n.reduceForwardStar();
        }
    }

    public void reduceBackwardStar()
    {
        for(Node n: queue)
        {
            n.reduceBackwardStar();
        }
    }

    public Node get(int index)
    {
        return queue.get(index);
    }
}
