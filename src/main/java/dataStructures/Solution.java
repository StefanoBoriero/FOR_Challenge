package dataStructures;

import java.util.Iterator;

/**
 * Created by Stefano on 12/02/2017.
 */
public class Solution {

    public static Integer[][] solution;

    public Solution()
    {
        int non=10;
        solution = new Integer[non +1 ][non + 1];
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
                if(solution[x][y] == 1)
                {
                    out = out + x + " " + y + "\n";
                }
            }
        }

        return out;
    }
}
