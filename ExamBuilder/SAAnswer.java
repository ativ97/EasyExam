/**
 * Krishna Vamsi Chandu
 * Kcchan23
 */
import javax.swing.*;
import java.io.*;
import java.util.*;
public class SAAnswer extends Answer {
    
    protected String choice;
    
    public SAAnswer(String s)
    {
        choice = s;
    }
    
    public SAAnswer(Scanner s)
    {
        choice = s.nextLine();
    }
    
    @Override public void print(int i, JTextArea questionArea)
    {
        questionArea.append(choice);
    }

    public void print(JTextArea ta)
    {
        ta.append(choice+"\n");
    }

    /*public String returnChoice()
    {
        return choice;
    }*/
    
    @Override public double getCredit(Answer rightAnswer)
    {
        double ans = 0;
        if(rightAnswer instanceof SAAnswer)
        {
            if((choice.toLowerCase()).equals(((SAAnswer)rightAnswer).choice.toLowerCase()))
            {
                ans = 1.0;
            }
            else 
                ans = 0.0;
        }
        return ans;
    }
    
    public void save(PrintWriter p)
    {
        p.println(choice);
    }
    
}
