    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.awt.Color;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.Scanner;
    import java.util.ArrayList;
    import java.util.HashMap; 
    import java.util.Map;
    
    /**
     * GUI for the names Name class.
     *
     * @author (Melanie Cuenca)
     * @version (12/1/2021)
     */
    public class GUI extends JFrame
    {
        // instance variables - replace the example below with your own
        private Canvas myCanvas;
        /**
         * Constructor for objects of class GUI
         */
        public GUI()throws FileNotFoundException 
        {
            // connects the Names 
            Names cs = new Names();
            
            //creates main panel
            setLayout(new BorderLayout());
            JPanel p = new JPanel();
            p.setPreferredSize (new Dimension(1000, 600));
            p.setBackground (Color.white);
            
            //creates the text area
            JTextArea f = new JTextArea(5,95);
            add(f,BorderLayout.NORTH);
            
            //creates the scrollbar inside the text area
            JScrollPane s = new JScrollPane(f);
            f.setEditable(false);
            
            //adds a nested panel
            JPanel subPanel1 = new JPanel(); 
            subPanel1.setPreferredSize (new Dimension(950, 300));
            subPanel1.setBackground (Color.white);
            
            //adds a second nested panel
            JPanel subPanel2 = new JPanel(); 
            subPanel2.setPreferredSize (new Dimension(950, 300));
            subPanel2.setBackground (Color.white);
            
            //this creates all of the option buttons and assigns each button a color
            JButton menu1 = new JButton("Find all of the names that have been getting popular each decade");
            menu1.setBackground(new Color (255,51,51));
            JButton menu2 = new JButton("Type in a name and print out the ranks for each decade of that name");
            menu2.setBackground(new Color (51, 153, 255));
            JButton menu3 = new JButton("Display the names that appear in only one decade");
            menu3.setBackground(new Color (51, 153, 255));
            JButton menu4 = new JButton("Display the names that are ranked in all the decades");
            menu4.setBackground(new Color (255,51,51));
            JButton menu5 = new JButton("Display all names of a given rank for all decades");
            menu5.setBackground(new Color (255,51,51));
            JButton menu6 = new JButton("Pick a name and graphically see its popularity throughout the decades");
            menu6.setBackground(new Color (51, 153, 255));
            JButton menu7 = new JButton("Find all of the names that have been getting less popular each decade");
            menu7.setBackground(new Color (51, 153, 255));
            JButton menu8 = new JButton("Exit");
            menu8.setBackground(new Color (255,51,51));
            subPanel1.setLayout(new GridLayout(0,2,4,4));
            
            //creates an image that will be displaney in the second subpanel
            ImageIcon icon = new ImageIcon ("popular.png");
            JLabel label1= new JLabel (icon, SwingConstants.CENTER);
          
            //adds the option buttons to the panels
            p.add(s);
            subPanel1.add(menu1);
            subPanel1.add(menu2);
            subPanel1.add(menu3);
            subPanel1.add(menu4);
            subPanel1.add(menu5);
            subPanel1.add(menu6);
            subPanel1.add(menu7);
            subPanel1.add(menu8);
            subPanel2.add(label1);
            p.add(subPanel1); 
            p.add(subPanel2);
            add(p,BorderLayout.CENTER);
            pack();
            setVisible(true);
            
            //displays the option one method from the names class and displays it on the text area
            menu1.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    f.setText("");
                    f.append("" + cs.panelOption1()+ "\n");
                }
            });
            //If a name is typed it prints out the ranks for each decade of that name on the text area
            menu2.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    f.setText("");
                    JFrame frame = new JFrame("Option 2");
                    String nameKey = JOptionPane.showInputDialog(frame, "Which name will you pick?");
                    f.setText("" + cs.nameRanks.get(nameKey));                    
            }
        });
        //prints the number of names that are ranked only once in the text area
        menu3.addActionListener(
        new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                //reads through all of the hashmap
                f.setText("");
                for (Map.Entry<String, String> set: cs.nameRanks.entrySet())
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
                        f.append(set.getKey() + "\n");
                    }
                }                
            }
        });        
        //displays the names that are ranked in all the decades in the text area
        menu4.addActionListener(
        new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                //reads through all of the hashmap
                f.setText("");
                for (Map.Entry<String, String> set: cs.nameRanks.entrySet())
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
                    if (counter == 0)
                    {
                        f.append(set.getKey() + "\n");
                    }
                }
            }
        });
        menu5.addActionListener(
        new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                f.setText("");
                JFrame frame = new JFrame("Option 5");
                String nameValue = JOptionPane.showInputDialog(frame, "Which rank between 1 and 1000 will you pick?");
                for (Map.Entry <String, String> set : cs.nameRanks.entrySet())
                {
                    
                    String row = set.getValue();
                    for (String colum : row.split(" "))
                    {
                        if (colum.equals(nameValue))
                        {
                           set.getValue();
                           f.append("" + set.getValue() + "\n");
                        }
                    }   
                }
                
            }
        });
        //this will graph a given name and its ranks on a canvas
        menu6.addActionListener(
        new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                myCanvas = new Canvas("Names Throughout the Decades", 900, 500);
                myCanvas.setForegroundColor(Color.BLUE);
                myCanvas.drawLine(0, 45, 900 , 45);
                myCanvas.drawLine(0, 455, 900, 455);
                int x1 = 75;
                int y1 = 45;
                int x2 = 75;
                int y2 = 455;
                for (int i = 0; i <= 900; i++)
                {
                    myCanvas.drawLine(x1, y1, x2, y2);
                    x1 = x1 + 75;
                    x2 = x2 + 75;
                    myCanvas.drawLine(x1, y1, x2, y2);
                }
                int k = 100;
                int x = 30;
                int y = 84;
                myCanvas.drawString("100", x, y);
                for (int i = 0; i < 9; i++)
                {
                    k = k + 100;
                    String s = "" + k;
                    y = y + 40;
                    myCanvas.drawString(s, x, y);
                }
                int k1 = 1900;
                int u = 65;
                int v = 470;
                myCanvas.drawString("1900", u, v);
                for (int i = 0; i < 10; i++)
                {
                    k1 = k1 + 10;
                    String s = "" + k1;
                    u = u + 75;
                    myCanvas.drawString(s, u, v);
                }
                JFrame frame = new JFrame("Option 2");
                String nameKey = JOptionPane.showInputDialog(frame, "Which name will you pick?");
                String h = cs.nameRanks.get(nameKey);
                String Decades[] = h.split(" ");
                for (int i = 1; i < Decades.length; i++)
                {
                    //this labels a rank of 0
                    if (Integer.parseInt(Decades[i]) == 0)
                    {
                        myCanvas.drawString("NR", 75*i-5, 40);
                        myCanvas.drawString("This is the graph for: " + nameKey, 5, 20);
                    }
                    //creates the dots and prints the rank
                    else
                    {
                        myCanvas.fillCircle(75*i-5, Integer.parseInt(Decades[i])*2/5+45,10);
                        myCanvas.drawString(nameKey + " " + Decades[i],75*i-5, (Integer.parseInt(Decades[i]))*2/5+30);
                    }
                    //creates the lines 
                    for (int j = 2; j < Decades.length; j++)
                    {
                        if (Integer.parseInt(Decades[j-1]) != 0)
                        {
                            if (Integer.parseInt(Decades[j]) != 0)
                            {                                
                                myCanvas.drawLine(75*(j-1), Integer.parseInt(Decades[j-1])*2/5+50,75*(j), Integer.parseInt(Decades[j])*2/5+50);
                            }                                                        
                        }                       
                    }                                                            
                }

            }
        });
        //this displays method 7 from the Names class in the text area
        menu7.addActionListener(
        new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                f.append("" + cs.panelOption7());
            }
        });
        //this method sents a thank you message and exits the GUI after the frame is closed 
        menu8.addActionListener(
        new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                JFrame frame = new JFrame("Exit");
                frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                JPanel primary = new JPanel(); 
                primary.setPreferredSize (new Dimension(200, 40));
                primary.setBackground (Color.white);
                JLabel label1 = new JLabel ("Thank you!" + "See you next time!"); 
                primary.add (label1);
                frame.getContentPane().add(primary); 
                frame.pack(); 
                frame.setVisible(true);
            }
        });        
    }
}
