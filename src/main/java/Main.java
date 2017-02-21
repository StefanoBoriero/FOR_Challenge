import java.util.List;

import dataStructures.*;
import file.DataParser;

/**
 * Created by Stefano on 17/01/2017.
 */
public class Main {
    public static void main(String[] args)
    {

        String filename = args[0];
        Parameters.setFilename(filename);
        DataParser.parse(filename);

        BackwardSolver.solve();
        //Solver6.solve();
        Solution.writeSolution();
      }
}
