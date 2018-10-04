/**
 * Krishna Vamsi Chandu
 * Kcchan23
 */
import javax.swing.*;
import java.io.PrintWriter;
import java.util.*;

public class SAQuestion extends Question{
    
    protected SAQuestion(String s, double val)
    {
        super(s,val);
    }
    
    protected SAQuestion(Scanner s)
    {
        super(s);
        rightAnswer = new SAAnswer(s);
    }
    
    public Answer getNewAnswer()
    {
        SAAnswer a = new SAAnswer("");
        return a;
    }
    
    public Answer getNewAnswer(String s)
    {
        SAAnswer a = new SAAnswer(s);
        return a;
    }
    
    public void save(PrintWriter p)
    {
        p.println(this.maxValue);
        p.println(this.text);
        rightAnswer.save(p);
    }
    
    @Override public void getAnswerFromStudent(JTextArea answerArea)
    {
        ScannerFactory t = null;
        Scanner s = t.getKeyboardScanner();
        String ans = answerArea.getText();
        SAAnswer a = new SAAnswer(ans);
        studentAnswer = a;
    }
    
    @Override public double getValue()
    {
        double a;
        try{
            a = studentAnswer.getCredit(rightAnswer);
        }
        
        catch(NullPointerException e)
        {
            a = 0;
        }
        return a*maxValue;
    }
}
