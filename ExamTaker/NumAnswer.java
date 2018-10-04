
/**
 * Ativ Aggarwal
 * aaggar9
 */

import javax.swing.*;
import java.io.*;
import java.util.*;
public class NumAnswer extends Answer {

    protected double choice;

    public NumAnswer(double s)
    {
        choice = s;
    }

    public NumAnswer(Scanner s)
    {
        choice = s.nextDouble();
        s.nextLine();
    }

    @Override public void print(int i, JTextArea questionArea)
    {
        questionArea.append(Double.toString(choice));
    }

    public double getCredit(Answer rightAnswer)
    {
        double ans = 0;
        if(rightAnswer instanceof NumAnswer)
        {
            if(choice ==((NumAnswer)rightAnswer).choice)
            {
                ans = 1.0;
            }
            else
                ans = 0.0;
        }
        return ans;
    }

    public double getCredit(Answer rightAnswer,double tolerence)
    {
        double ans = 0;
        if(rightAnswer instanceof NumAnswer)
        {
            if((choice <=(((NumAnswer)rightAnswer).choice + tolerence))&&(choice >=(((NumAnswer)rightAnswer).choice - tolerence)))
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
