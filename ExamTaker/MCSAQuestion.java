/**
 * Created by Neil Champakara (nchamp3) on 3/11/2018.
 */
import javax.swing.*;
import java.io.PrintWriter;
import java.util.*;
public class MCSAQuestion extends MCQuestion{


    public MCSAQuestion(String text, double maxValue)
    {
        super(text, maxValue);
    }

    public MCSAQuestion(Scanner sc)
    {
        super(sc);
        int numQ = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < numQ; i++)
        {
            addAnswer(new MCSAAnswer(sc));
        }
    }

    public void save(PrintWriter pr)
    {
        super.save(pr);
        pr.println(options.size());

        for(int i = 0; i < options.size(); i++)
        {
            //addAnswer(new MCSAAnswer(sc));
            options.get(i).save(pr);
        }
    }


    public Answer getNewAnswer()
    {
        MCSAAnswer obj = new MCSAAnswer("", 0.0);
        return obj;
    }

    /*public Answer getNewAnswer(String text)
    {
        MCSAAnswer obj = new MCSAAnswer(text, 0.0);
        return obj;
    }*/

    public Answer getNewAnswer(String text, double creditIfSelected)
    {
        MCSAAnswer obj = new MCSAAnswer(text, creditIfSelected);
        return obj;
    }

    public void getAnswerFromStudent(JTextArea answerArea)
    {
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter your single answer: ");
        String ans = answerArea.getText();
        if(!ans.equals(""))
        {
            char option = ans.charAt(0);
            int ansOpt = option - 'A';
            MCSAAnswer obj = new MCSAAnswer(options.get(ansOpt).choice, options.get(ansOpt).creditIfSelected);
            studentAnswer = obj;
        }
        else
        {
            MCSAAnswer obj = new MCSAAnswer("", 0.0);
            studentAnswer = obj;
        }
    }

    public double getValue()
    {
        //double credit = studentAnswer.getCredit(rightAnswer);
        //return maxValue * credit;
        //return 1.0;
        //System.out.println(((MCSAAnswer)studentAnswer).creditIfSelected);
        return super.getValue((MCAnswer) studentAnswer);
    }



}
