
import javax.swing.*;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Neil Champakara (nchamp3) on 3/12/2018.
 */
public class MCMAQuestion extends MCQuestion{

    protected ArrayList<Answer> studentAnswer = new ArrayList<Answer>();
    public double baseCredit;

    public MCMAQuestion(String text, double maxValue, double baseCredit)
    {
        super(text, maxValue);
        this.baseCredit = baseCredit;
    }

    public MCMAQuestion(Scanner sc)
    {
        super(sc);
        baseCredit = sc.nextDouble();
        sc.nextLine();
        //System.out.println("numQ");
        int numQ = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < numQ; i++)
        {
            addAnswer(new MCMAAnswer(sc));
        }
    }

    public void save(PrintWriter pr)
    {
        super.save(pr);
        pr.println(baseCredit);
        pr.println(options.size());

        for(int i = 0; i < options.size(); i++)
        {
            //addAnswer(new MCSAAnswer(sc));
            options.get(i).save(pr);
        }
    }

    public Answer getNewAnswer()
    {
        MCMAAnswer obj = new MCMAAnswer("", 0.0);
        return obj;
    }

    public Answer getNewAnswer(String text, double creditIfSelected)
    {
        MCMAAnswer obj = new MCMAAnswer(text, creditIfSelected);
        return obj;
    }

    public void getAnswerFromStudent(JTextArea answerArea)
    {
        ScannerFactory t = null;
        Scanner S = t.getKeyboardScanner();
        //System.out.println("Enter all choices seperated by commas ");
        String s = answerArea.getText();
        if(!s.equals(""))
        {
            String[] parts = s.split(",");
            for(int i = 0; i<parts.length; i++)
            {
                char x = (parts[i].toUpperCase()).charAt(0);
                int a = x - 'A';
                MCMAAnswer A = new MCMAAnswer(options.get(a).choice,options.get(a).creditIfSelected);
                //System.out.println(options.get(a).creditIfSelected);
                studentAnswer.add(A);
            }
        }
        else
        {
            MCMAAnswer A = new MCMAAnswer("",0.0);
            studentAnswer.add(A);
        }
    }

    public void restoreStudentAnswers(Scanner sc)
    {
        int numOpts = sc.nextInt();
        sc.nextLine();
        ArrayList<String> ans = new ArrayList<String>();
        for(int i = 0; i < numOpts; i++)
        {
            ans.add(sc.nextLine());
        }

        for(int j = 0; j < ans.size(); j++)
        {
            for(int i = 0; i < options.size(); i++)
            {
                if(ans.get(j).equals(options.get(i).choice))
                {
                    //System.out.println(answers.get(i).text);
                    studentAnswer.add(options.get(i));
                }
            }
        }

    }

    public void saveStudentAnswers(PrintWriter pr)
    {
        pr.println(studentAnswer.size());

        for(int i = 0; i < studentAnswer.size(); i++)
        {
            pr.println(((MCMAAnswer)studentAnswer.get(i)).choice);
        }
    }

    public double getValue()
    {
        //double credit = studentAnswer.getCredit(rightAnswer);
        //return maxValue * credit;
        //return 1.0;
        double value = 0.0;
        for(int i = 0; i<studentAnswer.size(); i++)
            value += super.getValue((MCAnswer) studentAnswer.get(i));

        return (value+ (baseCredit*maxValue));
    }
}
