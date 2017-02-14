package dataStructures;

import java.util.Iterator;

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
        solution = new Integer[non ][non ];
        for(int i=0; i< non; i++)
        {
            for(int j=0; j< non; j++)
            {
                solution[i][j]=0;
            }
        }
    }

    @Override
    public String toString()
    {
        int x = 0;
        int y = 0;
        int non = Parameters.getNumberOfNodes();
        String out = "";

        for(x = 0; x <= non; x++)
        {
            for(y = 0; y <= non ; y++)
            {
                if(/*solution[x][y] == 1*/true)
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

        for(i=0; i< non; i++)
        {
            String line = "";
            for(j=0; j< non; j++)
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
}
