package dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefano on 09/02/2017.
 */
public class ArrayNodeCollection {
    private static ArrayNodeCollection instance;
    private List<Node> nodes;

    public ArrayNodeCollection()
    {
         nodes = new ArrayList<>( Parameters.getNumberOfNodes() );
    }

    public Node getNode(int index){
        return nodes.get(index);
    }

    public static ArrayNodeCollection getInstance(){
        if(instance == null){
            instance = new ArrayNodeCollection();
        }
        return instance;
    }

    public void add(int index, Node n)
    {
        nodes.add(index, n);
    }
    
    public List<Node> getNodes()
    {
    	return this.nodes;
    }


}
