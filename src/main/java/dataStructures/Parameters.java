package dataStructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefano on 09/02/2017.
 * Class used to store global parameters like:
 * - number of nodes
 * - alpha
 */
public class Parameters {
    private static Parameters instance;
    Map<String, Double> parameterMap = new HashMap<>();

    public static Parameters getInstance()
    {
        if(instance == null){
            instance = new Parameters();
        }
        return instance;
    }

    public void setParameter(String key, Double value)
    {
        parameterMap.put(key, value);
    }

    public Double getValue(String key){
        return parameterMap.get(key);
    }
}
