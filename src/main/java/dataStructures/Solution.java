package dataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


/**
 * Created by Stefano on 12/02/2017.
 */
public class Solution {

    /*
    Solution is a NxN matrix, where sol[x][y] representa arc from x(tail) to y(head)
     */
    public static Integer[][] solution;

    public Solution()
    {
        int non = Parameters.getNumberOfNodes();
        solution = new Integer[non + 1][non + 1];
        for(int i=0; i<= non; i++)
        {
            for(int j=0; j<= non; j++)
            {
                solution[i][j]=0;
            }
        }
    }

    @Override
    public String toString()
    {
        int x;
        int y;
        int non = Parameters.getNumberOfNodes();
        String out = "";

        for(x = 0; x <= non; x++)
        {
            for(y = 0; y <= non ; y++)
            {
                if(solution[x][y] == 1)
                {
                    out = out + x + " " + y + "\n";
                }
            }
        }

        return out;
    }

    public static void printMatrix()
    {
        int i;
        int j;
        int non = Parameters.getNumberOfNodes();

        for(i=0; i<= non; i++)
        {
            String line = "";
            for(j=0; j<= non; j++)
            {
                line = line + solution[i][j] + ", ";
            }
            System.out.println(line);
        }

    }

    public static void add(int x, int y)
    {
        solution[x][y] = 1;
    }

    public static void writeSolution()
    {
        String aux = Parameters.getFilename();
        String filename;
        String[] tmp = aux.split(".dat");
        filename = tmp[0] + ".sol";
        File outputFile = new File(filename);
        PrintWriter out = null;
        try {
            out = new PrintWriter( new FileOutputStream( outputFile ) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int x;
        int y;


        for(x=0; x<= Parameters.getNumberOfNodes(); x++)
        {
            for(y=0; y<= Parameters.getNumberOfNodes(); y++)
            {
                if(solution[x][y] == 1)
                {
                    String s;
                    s = x + " " + y;
                    out.println(s);
                    out.flush();
                }
            }
        }

    }
}
