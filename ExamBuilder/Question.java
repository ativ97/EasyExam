/**
 * Ativ Aggarwal
 * aaggar9
 */
import javax.swing.*;
import java.io.PrintWriter;
import java.util.*;

public abstract class Question {

    protected String text;
    protected Answer rightAnswer;
    protected Answer studentAnswer;
    protected double maxValue;


    abstract protected Answer getNewAnswer();
    abstract protected void getAnswerFromStudent(JTextArea answerArea);
    abstract protected double getValue();

    protected Question()
    {
        text = "";
        maxValue = 0.0;
    }

    protected Question(String text, double maxValue)
    {
        this.text = text;
        this.maxValue = maxValue;
        //rightAnswer = ?
        //studentAnswer = ?
    }

    public Question(Scanner sc)
    {
        maxValue = sc.nextDouble();
        sc.nextLine();
        text = sc.nextLine();
    }

    public void save(PrintWriter pr)
    {
        pr.println(maxValue);
        pr.println(text);
    }

    public void print(int i, JTextArea questionArea)
    {
        questionArea.append(text + "\n");
        /*letter = 'A';

        for(int i = 0; i<answers.size(); i++)
        {
            System.out.print("\t" + letter++ + ". ");
            answers.get(i).print();
        }*/
    }
    void print( JTextArea ta ) {
        ta.append( text + "\n" );
    }



    protected void setRightAnswer(Answer ans)
    {
        rightAnswer = ans;
    }

    public void saveStudentAnswers(PrintWriter pr)
    {
        if (studentAnswer instanceof MCSAAnswer)
        {
            MCSAAnswer sa = (MCSAAnswer)studentAnswer;
            pr.println(sa.choice);
        }
        else if (studentAnswer instanceof SAAnswer)
        {
            SAAnswer sa = (SAAnswer)studentAnswer;
            pr.println(sa.choice);
        }
        else
        {
            NumAnswer sa = (NumAnswer)studentAnswer;
            if(sa == null)
                pr.println("N/A");
            else
                pr.println(sa.choice);
        }

    }

    public void restoreStudentAnswers(Scanner sc)
    {
        if(this instanceof MCSAQuestion)
        {
            MCSAAnswer obj;
            String ans = sc.nextLine();
            MCSAQuestion q = (MCSAQuestion)this;
            int ansOpt = -1;
            for(int i = 0; i < q.options.size(); i++)
            {
                if(ans.equals(q.options.get(i).choice))
                {
                    ansOpt = i;
                }
            }
            if(ansOpt > 0) {
                obj = new MCSAAnswer(((MCSAQuestion) this).options.get(ansOpt).choice, ((MCSAQuestion) this).options.get(ansOpt).creditIfSelected);
            }
            else
            {
                obj = new MCSAAnswer("", 0.0);
            }
            studentAnswer = obj;
        }
        else if(this instanceof SAQuestion) {
            String ans = sc.nextLine();
            SAAnswer saans = new SAAnswer(ans);
            studentAnswer = saans;
        }
        else if(this instanceof NumQuestion)
        {
            double ans = sc.nextDouble();
            sc.nextLine();
            NumAnswer saans = new NumAnswer(ans);
            studentAnswer = saans;
        }
    }







    /*public void selectAnswer(int position)
    {
        for(int i = 0; i<answers.size(); i++)
        {
            answers.get(i).setSelected(false);
        }

        answers.get(position).setSelected(true);
    }

    public void unselectAnswer(int position)
    {
        answers.get(position).setSelected(false);
    }


    public double getValue()
    {
        double points = 0.0;
        for(int i = 0; i<answers.size(); i++)
        {
            points += answers.get(i).getValue();
        }

        return points;
    }*/

}
