import dataStructures.Parameters;
import dataStructures.Solution;

/**
 * Created by Stefano on 12/02/2017.
 */
public class Solver {

    public static void solve()
    {
        int non = Parameters.getNumberOfNodes();
        for(int i = 0, j = 0; j <= non; j++)
        {
            Solution.solution[i][j] = 1;
        }
    }
}
