package dataStructures;

/**
 * Created by Stefano on 09/02/2017.
 * Class used to store global parameters like:
 * - number of nodes
 * - alpha
 */
public class Parameters {
    private static int numberOfNodes;
    private static double alpha;
    private static double[][] danger;


    public static void setNumberOfNodes(int non)
    {
        numberOfNodes = non;
    }

    public static int getNumberOfNodes()
    {
        return numberOfNodes;
    }

    public static void setAlpha(double a)
    {
        alpha = a;
    }

    public static double getAlpha()
    {
        return alpha;
    }
    
    public static void initDanger(int non)
    {
    	danger = new double[non + 1][non + 1];
    }
    
    public static void setDanger(int index1, int index2, double dangerCoeff)
    {
    	danger[index1][index2] = dangerCoeff;
    }
    
    public static double getDanger(int index1, int index2)
    {
    	return danger[index1][index2];
    }

}
