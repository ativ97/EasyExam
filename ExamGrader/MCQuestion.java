
import javax.swing.*;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Neil Champakara (nchamp3) on 3/11/2018.
 */
public abstract class MCQuestion extends Question{

    protected ArrayList<MCAnswer> options = new ArrayList<MCAnswer>();
    private char letter;


   protected MCQuestion()
    {
        text = "";
        maxValue = 0.0;
    }

    protected MCQuestion(String text, double maxValue)
    {
        /*this.text = text;
        this.maxValue = maxValue;*/
        super(text, maxValue);
    }

    public MCQuestion(Scanner sc)
    {
        super(sc);
    }

    public void save(PrintWriter pr)
    {
        super.save(pr);
    }

    public void reorderAnswers()
    {
        Collections.shuffle(options);
    }

    public void addAnswer(MCAnswer ans)
    {
        options.add(ans);
    }

    //@Override
    public void print(int i, JTextArea questionArea)
    {
        super.print(i, questionArea);
        letter = 'A';

        for(int j = 0; j < options.size(); j++)
        {
            questionArea.append("\t" + letter++ + ". ");
            options.get(j).print(j, questionArea);
        }

    }

    public void print( JTextArea ta ) {
        super.print(ta);
        letter = 'A';
        for(int i = 0; i < options.size(); i++)
        {
            ta.append("\t" + letter++ + ". ");
            options.get(i).print(ta);
        }
    }

    /*public String returnChoice()
    {
        String q = super.returnChoice();
        letter = 'A';

        for(int i = 0; i < options.size(); i++)
        {
            q += "\t" + letter++ + ". ";
             q += options.get(i).returnChoice() + "\n";
        }

    }*/

    public double getValue(MCAnswer a)
    {
        //double credit = studentAnswer.getCredit(rightAnswer);
        //return maxValue * credit;
        //return 1.0;
        double credit = 0.0;

        for(int i = 0; i < options.size(); i++)
        {
            credit += options.get(i).getCredit(a);
        }

        return maxValue * credit;
    }

}
