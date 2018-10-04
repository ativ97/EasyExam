
import java.util.*;
/**
 * Krishna Vamsi Chandu
 * Kcchan23
 */
public class MCSAAnswer extends MCAnswer{
    
    public MCSAAnswer(String s, double val)
    {
        super(s,val);
    }
    
    public MCSAAnswer(Scanner s)
    {
        super(s);
    }
    
    /*@Override public double getCredit(Answer rightAnswer)
    {
        double ans = 0;
        if(rightAnswer instanceof MCSAAnswer)
        {
            if((choice.toLowerCase()).equals(((MCSAAnswer)rightAnswer).choice.toLowerCase()))
            {
                ans = 1.0;
            }
            else 
                ans = 0.0;
        }
        return ans;
    }*/
    
}
