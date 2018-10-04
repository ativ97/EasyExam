

import javax.swing.*;
import java.util.*;
import java.io.*;
/**
 * Krishna Vamsi Chandu
 * Kcchan23
 */
public abstract class MCAnswer extends Answer{
    
    protected String choice;
    protected boolean isSelected;
    protected double creditIfSelected;
    public MCAnswer(String opt, double val)
    {
        choice = opt;
        isSelected = false;
        creditIfSelected = val;
    }
    public MCAnswer(Scanner s)
    {
        //System.out.println();
        creditIfSelected = s.nextDouble();
        //System.out.println(creditIfSelected);
        //s.next().charAt(0);
        choice = s.nextLine().substring(1);
        //System.out.println(s.nextLine().substring(1));
    }
    @Override public void print(int i, JTextArea questionArea)
    {
        questionArea.append(choice + "\n");
    }

    public void print( JTextArea ta ) {
        ta.append(choice + "\n");
    }

    public String returnChoice()
    {
        return choice;
    }

    public void setSelected(boolean a)
    {
        isSelected = a;
    }
    
    public double getCredit(Answer a)
    {
        //a.print();
        if(a instanceof MCAnswer)
        {
            MCAnswer x = (MCAnswer)a;

            if(choice.equals(x.choice))
            {
                return x.creditIfSelected;
            }
            else return 0;
        }
        else return 0;
    }
    
    public void save(PrintWriter p)
    {
        
        p.println(creditIfSelected + " " + choice);
    }
    
}
