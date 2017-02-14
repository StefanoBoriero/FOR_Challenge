package file;

import dataStructures.ArrayNodeCollection;
import dataStructures.Node;
import dataStructures.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Stefano on 10/02/2017.
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



    }

    private static void parseNumberOfNodes(Scanner in)
    {
        /*
        in.nextLine(); // data;
        String line = in.nextLine();
        String[] words = line.split(" ");
        int numberOfNodes = Integer.parseInt( words[ words.length -1 ]);
        ArrayNodeCollection.getInstance().setNumberOfNodes( numberOfNodes );
        non = numberOfNodes;
        in.nextLine(); // ;
        line = in.nextLine();
        while( line.equals(" ")){
            line = in.nextLine();
        }
        */
        in.nextLine(); // data;
        in.next();
        String key = in.next();
        in.next(); // :=
        String v = in.next();

        int value = Integer.parseInt(v);
        Parameters.setNumberOfNodes(value);

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

        String s;
        s = in.next(); // ;
        s = in.next(); // param
        s = in.next(); // coordY
        s = in.next(); // [*]
        s = in.next(); // :=

        counter = 0;
        while( counter <= non)
        {
            int index = Integer.parseInt( in.next() );
            int coord = Integer.parseInt( in.next() );
            coordY[index] = coord;
            counter++;
        }

        counter = 0;
        ArrayNodeCollection coll = ArrayNodeCollection.getInstance();
        while( counter < non )
        {
            Node n = new Node(counter, coordX[counter], coordY[counter]);
           coll.add(counter, n);
            counter++;
        }
    }
}
