import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;

/**
 * This class analyses the data of the Names text file
 *
 * @author (Melanie Cuenca)
 * @version (12/1/21)
 */
public class Names
{
    // instance variables - replace the example below with your own
    private Scanner scan;
    ArrayList<String> names;
    HashMap<String,String> nameRanks;
    
    private Random rand;
    
    /**
     * Constructor for objects of class Names
     */
    public Names()throws FileNotFoundException 
    {
        names = new ArrayList<String>();
        nameRanks = new HashMap<String,String>();
        File text = new File("names.txt");
        scan = new Scanner(text);
        String line = "";
        int i = 0;
        String name = "";
        String rank = "";
        while (scan.hasNextLine())
        {
            line = scan.nextLine();
            names.add(line); 
            i = line.indexOf(" "); 
            //System.out.println(i);
            name = line.substring(0,i);
            //rank = line.substring(i, line.length());
            //System.out.println(rank);
            nameRanks.put(name, line);
            //System.out.println(line);
        } 
    }

    public ArrayList<String> panelOption1()//Finds the names that have been getting popular
    {
        ArrayList<String> incNames = new ArrayList<String>();
        String[] p = null;
        boolean b;
        for (String s : names)
        {
            p = s.split(" ");
            b = p[0].equals("0") ||
                p[1].equals("0") ||
                p[2].equals("0") ||
                p[3].equals("0") ||
                p[4].equals("0") ||
                p[5].equals("0") ||
                p[6].equals("0") ||
                p[7].equals("0") ||
                p[8].equals("0") ||
                p[9].equals("0") ||
                p[10].equals("0") ||
                p[11].equals("0");
            if (!b)
            {
            if (Integer.parseInt(p[2]) <= Integer.parseInt(p[1]) && 
                Integer.parseInt(p[3]) <= Integer.parseInt(p[2]) &&
                Integer.parseInt(p[4]) <= Integer.parseInt(p[3]) &&
                Integer.parseInt(p[5]) <= Integer.parseInt(p[4]) &&
                Integer.parseInt(p[6]) <= Integer.parseInt(p[5]) &&
                Integer.parseInt(p[7]) <= Integer.parseInt(p[6]) &&
                Integer.parseInt(p[8]) <= Integer.parseInt(p[7]) &&
                Integer.parseInt(p[9]) <= Integer.parseInt(p[8]) &&
                Integer.parseInt(p[10]) <= Integer.parseInt(p[9]) &&
                Integer.parseInt(p[11]) <= Integer.parseInt(p[10])
            )
            {incNames.add(s + "\n");
            }
        }
        }
        return incNames;
    }

    //option two is found inside the GUI class
    
    public void panelOption3()//prints the number of names that are ranked only once
    {
        //reads through all of the hashmap
        for (Map.Entry<String, String> set: nameRanks.entrySet())
        {
            String row = set.getValue();
            int counter = 0;
            
            //splits the name and rank
            for (String colum : row.split(" "))
            {
                //counts how many times the name was ranked 0
                if (colum.equals("0"))
                {
                    counter ++;
                }
            }
            //if the name ranks 0 for 10 decades it prints the name
            if (counter == 10)
            {
                System.out.println(set.getKey());
            }
        }
    }

    //option 4 is found in the GUI class
    
    //option 5 is found inside the GUI class

    public ArrayList<String> panelOption7()//Find all the names that have been getting less popular each decade
    {
        ArrayList<String> incNames = new ArrayList<String>();
        String[] p = null;
        boolean b;
        for (String s : names)
        {
            p = s.split(" ");
            b = p[0].equals("0") ||
                p[1].equals("0") ||
                p[2].equals("0") ||
                p[3].equals("0") ||
                p[4].equals("0") ||
                p[5].equals("0") ||
                p[6].equals("0") ||
                p[7].equals("0") ||
                p[8].equals("0") ||
                p[9].equals("0") ||
                p[10].equals("0") ||
                p[11].equals("0");
            if (!b)
            {
            if (Integer.parseInt(p[2]) >= Integer.parseInt(p[1]) && 
                Integer.parseInt(p[3]) >= Integer.parseInt(p[2]) &&
                Integer.parseInt(p[4]) >= Integer.parseInt(p[3]) &&
                Integer.parseInt(p[5]) >= Integer.parseInt(p[4]) &&
                Integer.parseInt(p[6]) >= Integer.parseInt(p[5]) &&
                Integer.parseInt(p[7]) >= Integer.parseInt(p[6]) &&
                Integer.parseInt(p[8]) >= Integer.parseInt(p[7]) &&
                Integer.parseInt(p[9]) >= Integer.parseInt(p[8]) &&
                Integer.parseInt(p[10]) >= Integer.parseInt(p[9]) &&
                Integer.parseInt(p[11]) >= Integer.parseInt(p[10])
            )
            {incNames.add(s + "\n"); 
            }
        }
        }
        return incNames;
    }
}