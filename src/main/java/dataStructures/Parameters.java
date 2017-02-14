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

}
