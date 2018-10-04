/**
 * Ativ Aggarwal
 * aaggar9
 */
import javax.swing.*;
import java.io.PrintWriter;
        import java.util.*;

public class NumQuestion extends Question{

    protected NumQuestion(String s, double val,double tol)
    {
        super(s,val);
        tolerence = tol;
    }
    protected double tolerence;

    protected NumQuestion(Scanner s)
    {
        super(s);
        rightAnswer = new NumAnswer(s);
        tolerence= s.nextDouble();
        s.nextLine();
    }

    public Answer getNewAnswer()
    {
        NumAnswer a = new NumAnswer(0.0);
        return a;
    }

    public Answer getNewAnswer(double s)
    {
        NumAnswer a = new NumAnswer(s);
        return a;
    }

    public void save(PrintWriter p)
    {
        p.println(this.maxValue);
        p.println(this.text);
        rightAnswer.save(p);
        p.println(tolerence);
    }

    @Override public void getAnswerFromStudent(JTextArea answerArea)
    {
        ScannerFactory t = null;
        Scanner s = t.getKeyboardScanner();
        String ans = answerArea.getText();
        if(!ans.equals("")) {
            //s.nextLine();
            double ansDouble = Double.parseDouble(ans);
            NumAnswer a = new NumAnswer(ansDouble);
            studentAnswer = a;
        }
        else
        {
            NumAnswer a = new NumAnswer(0.0);
            studentAnswer = a;
        }
    }

    @Override public double getValue()
    {
        double a;
        try{
            a = ((NumAnswer)studentAnswer).getCredit(rightAnswer, tolerence);
        }

        catch(NullPointerException e)
        {
            a = 0;
        }
        return a*maxValue;
    }
}
