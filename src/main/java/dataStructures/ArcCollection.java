package dataStructures;

/**
 * Created by Stefano on 09/02/2017.
 */
public interface ArcCollection {

    /*
    * Adds an arc to the data structure if it belongs to a feasible solution
    * @param head = head of candidate arc
    * @param tail = tail of candidate arc
     */
    void insertArc(Node head, Node tail);
}
