/**
 * Created by Neil Champakara (nchamp3) on 3/11/2018.
 */
import javax.swing.*;
import java.util.*;
import java.io.*;



public class Exam {

    private ArrayList<Question> questions;
    private String text;
    private String name;
    private double total;
    private String fileName; 
    public Exam(String option)
    {
        text = option;
        questions = new ArrayList<Question>();
    }

    public Exam()
    {

    }

    public void setExamTitle(String s)
    {
        fileName = s;
    }
    public Exam(Scanner sc)
    {
        text = sc.nextLine();
        questions = new ArrayList<Question>();
        sc.nextLine();
        String qType;
        while(sc.hasNextLine())
        {
            qType = sc.nextLine();

            if(qType.equals("MCSAQuestion"))
            {
                addQuestion(new MCSAQuestion(sc));
            }
            else if(qType.equals("MCMAQuestion"))
            {
                addQuestion(new MCMAQuestion(sc));
            }
            else if(qType.equals("SAQuestion"))
            {
                addQuestion(new SAQuestion(sc));
            }
            else if(qType.equals("NumQuestion"))
            {
                addQuestion(new NumQuestion(sc));
            }
            //sc.nextLine();
        }
    }

    public void save(PrintWriter pr)
    {
        pr.println(text);
        Date now = new Date();
        pr.println(now);
        pr.println("\n");
        

        for(int i = 0; i < questions.size(); i++)
        {
            if(questions.get(i) instanceof MCSAQuestion)
            {
                pr.println("MCSAQuestion");
                questions.get(i).save(pr);
                //pr.println();
            }
            else if(questions.get(i) instanceof MCMAQuestion)
            {
                pr.println("MCMAQuestion");
                questions.get(i).save(pr);
                //pr.println();
            }
            else if(questions.get(i) instanceof SAQuestion)
            {
                pr.println("SAQuestion");
                questions.get(i).save(pr);
                //pr.println();
            }

            else if(questions.get(i) instanceof NumQuestion)
            {
                pr.println("NumQuestion");
                questions.get(i).save(pr);
                //pr.println();
            }

            pr.println();
        }
    }

    public void saveStudentAnswers(PrintWriter pr,String name,String fileName)
    {
        this.name = name;
        this.fileName = fileName;
        pr.println(name);
        pr.println(fileName);
        Date now = new Date();
        pr.println(now);
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //LocalDateTime now = LocalDateTime.now();
        //pr.println(dtf.format(now));
        pr.println();

        for(int i = 0; i < questions.size(); i++)
        {
            if(questions.get(i) instanceof MCSAQuestion)
            {
                pr.println("MCSAQuestion");
                questions.get(i).saveStudentAnswers(pr);
            }
            else if(questions.get(i) instanceof MCMAQuestion)
            {
                pr.println("MCMAQuestion");
                questions.get(i).saveStudentAnswers(pr);
            }
            else if(questions.get(i) instanceof SAQuestion)
            {
                pr.println("SAQuestion");
                questions.get(i).saveStudentAnswers(pr);
            }
            else if(questions.get(i) instanceof NumQuestion)
            {
                pr.println("NumQuestion");
                questions.get(i).saveStudentAnswers(pr);
                //pr.println();
            }

            pr.println();
        }
    }

    public void restoreStudentAnswers(Scanner sc)
    {
        name = sc.nextLine();
        sc.nextLine();
        //questions = new ArrayList<Question>();
        sc.nextLine();
        sc.nextLine();
        String qType;
        for(int i = 0; i < questions.size(); i++)
        {
            qType = sc.nextLine();

            if(qType.equals("MCSAQuestion"))
            {
                //addQuestion(new MCSAQuestion(sc));
                questions.get(i).restoreStudentAnswers(sc);
            }
            else if(qType.equals("MCMAQuestion"))
            {
                //addQuestion(new MCMAQuestion(sc));
                questions.get(i).restoreStudentAnswers(sc);
            }
            else if(qType.equals("SAQuestion"))
            {
                //addQuestion(new SAQuestion(sc));
                questions.get(i).restoreStudentAnswers(sc);
            }
            else if(qType.equals("NumQuestion"))
            {
                questions.get(i).restoreStudentAnswers(sc);
            }
            sc.nextLine();
        }
    }

    public void addQuestion(Question ques)
    {
        questions.add(ques);
    }

    public void print(int i, JTextArea questionArea)
    {
        questionArea.append(text + "\n");

        questionArea.append(i+1 + ". ");
        questions.get(i).print(i, questionArea);
        if(questions.get(i) instanceof MCMAQuestion)
            questionArea.append("Enter all choices seperated by commas: ");
        else if(questions.get(i) instanceof MCSAQuestion)
            questionArea.append("Enter your single answer: ");
        else
            questionArea.append("");
    }

    void print( JTextArea ta ) {
        ta.setText("");
        ta.append( text + "\n");
        for(int i = 0; i<questions.size(); i++)
        {
            ta.append(i+1 + ". ");
            //System.out.print(i+1 + ". ");
            questions.get(i).print(ta);
        }
    }

    /*void getQuestion(int position)
    {
        questions.get(position-1).returnChoice();
    }*/

    public void reorderQuestions()
    {
        Collections.shuffle(questions);
    }

    public void reorderMCAnswers(int position)
    {
        if(position < 0)
        {
            for(int i = 0; i < questions.size(); i++)
            {
                if(questions.get(i) instanceof MCQuestion)
                {
                    ((MCQuestion) questions.get(i)).reorderAnswers();
                }
            }
        }
        else
        {
            if(questions.get(position - 1) instanceof MCQuestion)
            {
                ((MCQuestion) questions.get(position - 1)).reorderAnswers();
            }
        }
    }

    public double getValue()
    {
        double points = 0.0;
        for(int i = 0; i<questions.size(); i++)
        {
            points += questions.get(i).getValue();
        }

        return points;
    }

    public void reportQuestionValues()
    {
        System.out.println("Question \t\t Value");
        for(int i = 0; i<questions.size(); i++)
        {
            double value = questions.get(i).getValue();
            total += value;
            System.out.println("Question" + (i + 1) + ": \t\t " + value);
        }
    }

    void getAnswerFromStudent(int position, JTextArea answerArea)
    {
        if(position == -1)
        {
            for(int i = 0; i < questions.size(); i++)
            {
                questions.get(i).getAnswerFromStudent(answerArea);
            }
        }
        else
        {
            questions.get(position - 1).getAnswerFromStudent(answerArea);
        }
    }
    
    void deleteQuestion(int pos)
    {
        questions.remove(pos-1);
    }
    public int getNumQuestion()
    {
        return questions.size();
    }
    
    public void saveResult(FileWriter f)
    {
        try{
            f.append(name);
            f.append(",");
            f.append(Double.toString(total));
            f.append(",");
            for(int i = 0; i < questions.size(); i++)
            {
                f.append(Double.toString(questions.get(i).getValue()));
                if((i+1) != questions.size())
                    f.append(",");
            }
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
        
}
