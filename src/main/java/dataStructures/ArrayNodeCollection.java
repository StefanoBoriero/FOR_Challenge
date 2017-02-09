package dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefano on 09/02/2017.
 */
public class ArrayNodeCollection {
    private static ArrayNodeCollection instance;
    List<Node> nodes = new ArrayList<>();

    public ArrayNodeCollection()
    {

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

}
