package file;

import dataStructures.ArrayNodeCollection;
import dataStructures.Node;
import dataStructures.NodeCollection;
import dataStructures.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Utility to parse the .dat file
 */
public class DataParser {

    public DataParser()
    {

    }

    public static void parse(String fileName)
    {
        Scanner in;
        try {
            FileInputStream data = new FileInputStream(fileName);
            in = new Scanner(data);

        } catch (FileNotFoundException e) {
            in = null;
            e.printStackTrace();
        }

        parseNumberOfNodes(in);
        parseAlpha(in);
        parseNodes(in);
        parseDanger(in);



    }

    private static void parseNumberOfNodes(Scanner in)
    {
        in.nextLine(); // data;
        in.next();
        String key = in.next();
        in.next(); // :=
        String v = in.next();

        int value = Integer.parseInt(v);
        Parameters.setNumberOfNodes(value);
        Parameters.initDanger(value);
        in.next(); // ;
    }

    private static void parseAlpha(Scanner in)
    {
        String s;
        in.next(); // param
        in.next(); //alpha
        in.next(); //:=
        s = in.next(); // x.xx
        Double alpha = Double.parseDouble( s );
        Parameters.setAlpha(alpha);
        s = in.next(); // ;
    }

    private static void parseNodes(Scanner in)
    {
        new NodeCollection();
        int non = Parameters.getNumberOfNodes();
        in.next(); // param
        in.next(); // coordX
        in.next(); // [*]
        in.next(); // :=
        int[] coordX = new int[non + 1];
        int[] coordY = new int[non + 1];
        int counter = 0;

        while( counter <= non)
        {
            int index = Integer.parseInt( in.next() );
            int coord = Integer.parseInt( in.next() );
            coordX[index] = coord;
            counter++;
        }

        in.next(); // ;
        in.next(); // param
        in.next(); // coordY
        in.next(); // [*]
        in.next(); // :=

        counter = 0;
        while( counter <= non)
        {
            int index = Integer.parseInt( in.next() );
            int coord = Integer.parseInt( in.next() );
            coordY[index] = coord;
            counter++;
        }

        counter = 0;
        //ArrayNodeCollection coll = ArrayNodeCollection.getInstance();
        while( counter <= non )
        {
            Node n = new Node(counter, coordX[counter], coordY[counter]);
            if(counter == 0)
            {
                Parameters.setSchool(n);
            }
            else
            {
                //coll.add(counter, n);
                NodeCollection.insertNode(n);
            }
            counter++;
        }
    }
    
    private static void parseDanger(Scanner in)
    {
    	Parameters.setDanger(0, 0, 0);
    	
    	in.next(); // ;
        in.next(); // param
        in.next(); // d
        in.next(); // [*,*]:
        for(int i=0; i< Parameters.getNumberOfNodes() + 1; i++)
        	in.next();
        in.next(); // :=
        
        for(int i=0; i< Parameters.getNumberOfNodes() + 1; i++)
        {
        	in.next(); //leggi il numero
        	for(int j=0; j< Parameters.getNumberOfNodes()+1; j++)
        			Parameters.setDanger(i, j, Double.parseDouble(in.next()));
        }
        
    }
}
