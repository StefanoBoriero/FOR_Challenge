package dataStructures;

/**
 * Created by Stefano on 09/02/2017.
 */
public class Arc {
    Node head;
    Node tail;
    double lenght;
    double risk;

    public Arc(Node head, Node tail)
    {
        this.head = head;
        this.tail = tail;
        lenght = head.distance(tail);
    }
}
