/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author chand
 */
public class ExamBuilder {
    
    private void printMenu()
    {
        System.out.println("Here are the available choices.");
        System.out.println("1) Load a saved Exam from a file");
        System.out.println("2) Add a question");
        System.out.println("3) Remove a question");
        System.out.println("4) Reorder questions");
        System.out.println("5) Print the exam");
        System.out.println("6) Save the exam");
        System.out.println("7) Quit");
    }
    
    
    private Exam exm = new Exam("Exam");
    
    public void loadExam(String examFileName)
    {
        File file = new File(examFileName);
        try{
            Scanner x = new Scanner(file);
            exm = new Exam(x);
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
        
    public void deleteQuestion(String position)
    {
        int pos = Integer.parseInt(position);
        exm.deleteQuestion(pos);
    }
    
    public void reorderQuestion(String y)
    {
        exm.reorderQuestions();
        if(y.equals("Y")||y.equals("y"))
        {
            exm.reorderMCAnswers(-1);
        }
    }
    
    public void print(JTextArea ta)
    {
        exm.print(ta);
    }
    
    public void saveToFile(String fileName)
    {
        PrintWriter p = null;
        try {
            File examFile = new File(fileName);
            p = new PrintWriter(examFile);
            exm.save(p);
            p.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
        
    public void addSAQuestion(String text, String val, String rightAnswer)
    {
        double value = Double.parseDouble(val);
        SAQuestion q = new SAQuestion(text, value);
        SAAnswer a = (SAAnswer)q.getNewAnswer(rightAnswer);
        q.setRightAnswer(a);
        exm.addQuestion(q);
    }
    
    public MCSAQuestion getMCSAQuestion(String text, String val)
    {
        double value = Double.parseDouble(val);
        MCSAQuestion q = new MCSAQuestion(text, value);
        //SAAnswer a = (SAAnswer)q.getNewAnswer(rightAnswer);
        //q.setRightAnswer(a);
        //exm.addQuestion(q);
        return q;
    }
    
    public void addMCSAQuestion(MCSAQuestion q)
    {
        //double value = Double.parseDouble(val);
        //MCSAQuestion q = new MCSAQuestion(text, value);
        //SAAnswer a = (SAAnswer)q.getNewAnswer(rightAnswer);
        //q.setRightAnswer(a);
        exm.addQuestion(q);
        //return q;
    }
    
    public MCSAQuestion addMCSAOption(MCSAQuestion q,String opt, String val)
    {
        double value = Double.parseDouble(val);
        //q.getNewAnswer(opt, value);
        q.addAnswer((MCAnswer)q.getNewAnswer(opt, value));
        return q;
    }
    
    public MCMAQuestion getMCMAQuestion(String text, String val,String bas)
    {
        double max = Double.parseDouble(val);
        double base = Double.parseDouble(bas);
        MCMAQuestion q = new MCMAQuestion(text, max, base);
        return q;
    }
    
    public MCMAQuestion addMCMAOption(MCMAQuestion q,String opt, String val)
    {
        double value = Double.parseDouble(val);
        //q.getNewAnswer(opt, value);
        q.addAnswer((MCAnswer)q.getNewAnswer(opt, value));
        return q;
    }
    public void addMCMAQuestion(MCMAQuestion q)
    {
        exm.addQuestion(q);
    }
    
    public void addNumQuestion(String text, String val,String tolerance, String rightAnswer)
    {
        double value = Double.parseDouble(val);
        double tol = Double.parseDouble((tolerance));
        double r = Double.parseDouble((rightAnswer));
        NumQuestion q = new NumQuestion(text,value,tol);
        NumAnswer a = (NumAnswer)q.getNewAnswer(r);
        q.setRightAnswer(a);
        exm.addQuestion(q);
    }
    public ExamBuilder()
    {
        
//        ScannerFactory s = new ScannerFactory();
//        Scanner t = s.getKeyboardScanner();
//        printMenu();
//        
//        while(true)
//        {
//            String choice = t.nextLine();
//            if(choice.equals("1"))
//            {
//                System.out.println("Please enter the examInput file");
//                String examFileName = t.nextLine();
//                File file = new File(examFileName);
//                try{
//                    Scanner x = new Scanner(file);
//                    exm = new Exam(x);
//                }
//                catch (FileNotFoundException ex){
//                    ex.printStackTrace();
//                }
//            }
//            if(choice.equals("2"))
//            {
//                 
//                System.out.println("What type of question do you want to add? Choose from: ");
//                System.out.println("1) MCSAQuestion");
//                System.out.println("2) MCMAQuestion");
//                System.out.println("3) SAQuestion");
//                int option = t.nextInt();
//                if(option == 1)
//                {
//                    t.nextLine();
//                    System.out.println("Enter the question text");
//                    String text = t.nextLine();
//                    System.out.println("Enter the maxValue");
//                    double max = t.nextDouble();
//                    System.out.println("Enter the number of options you would like to add");
//                    MCSAQuestion q = new MCSAQuestion(text, max);
//                    int num = t.nextInt();
//                    t.nextLine();
//                    for(int i = 0; i < num; i++)
//                    {
//                        System.out.println("Enter option" + (i+1));
//                        String opt = t.nextLine();
//                        System.out.println("Enter the max value for option" + (i+1));
//                        double maxValue = t.nextDouble();
//                        t.nextLine();
//                        q.getNewAnswer(opt, maxValue);
//                    }
//                    
//                    if(exm!=null)
//                        exm.addQuestion(q);
//                    else
//                    {
//                        System.out.println("Exam not present. Terminating program!");
//                        break;
//                    }
//                }
//                
//                if(option == 2)
//                {
//                    t.nextLine();
//                    System.out.println("Enter the question text");
//                    String text = t.nextLine();
//                    System.out.println("Enter the maxValue");
//                    double max = t.nextDouble();
//                    System.out.println("Enter the base credit");
//                    double base = t.nextDouble();
//                    System.out.println("Enter the number of options you would like to add");
//                    MCMAQuestion q = new MCMAQuestion(text, max, base);
//                    int num = t.nextInt();
//                    t.nextLine();
//                    for(int i = 0; i < num; i++)
//                    {
//                        System.out.println("Enter option" + (i+1));
//                        String opt = t.nextLine();
//                        System.out.println("Enter the max value for option" + (i+1));
//                        double maxValue = t.nextDouble();
//                        t.nextLine();
//                        q.addAnswer((MCAnswer)q.getNewAnswer(opt, maxValue));
//                    }
//                    
//                    if(exm!=null)
//                        exm.addQuestion(q);
//                    else
//                    {
//                        System.out.println("Exam not present. Terminating program!");
//                        break;
//                    }
//                }
//                if(option == 3)
//                {
//                    t.nextLine();
//                    System.out.println("Enter the question text");
//                    String text = t.nextLine();
//                    System.out.println("Enter the Value");
//                    double value = t.nextDouble();
//                    System.out.println("Enter the Right Answer");
//                    t.nextLine();
//                    String rightAnswer = t.nextLine();
//                    SAQuestion q = new SAQuestion(text, value);
//                    SAAnswer a = (SAAnswer)q.getNewAnswer(rightAnswer);
//                    q.setRightAnswer(a);
//                    if(exm!=null)
//                        exm.addQuestion(q);
//                    else
//                    {
//                        System.out.println("Exam not present. Terminating program!");
//                        break;
//                    }
//                }
//            }
//            if(choice.equals("3"))
//            {
//                System.out.println("Enter the position of the question to be deleted");
//                int pos = t.nextInt();
//                exm.deleteQuestion(pos);
//            }
//            if(choice.equals("4"))
//            {
//                exm.reorderQuestions();
//                System.out.println("Do you also want the options in MCQuestions reordered? (y/n)");
//                String y = t.nextLine();
//                if(y.equals("Y")||y.equals("y"))
//                {
//                    while(true)
//                    {
//                        System.out.println("Enter the question which you want the MCAsnwers to be reordered");
//                        System.out.println("Enter -1 for all questions, 0 for exiting this menu");
//                        int a = t.nextInt();
//                        if(a == 0)
//                        {
//                            break;
//                        }
//                        else
//                            exm.reorderMCAnswers(a);
//                    }
//                }
//            }
//            if(choice.equals("5"))
//            {
//                exm.print();
//            }
//            if(choice.equals("6"))
//            {
//                PrintWriter p = null;
//                try {
//                    System.out.println("Enter the name of the file you wish to save the exam");
//                    File examFile = new File(t.nextLine());
//                    p = new PrintWriter(examFile);
//                    exm.save(p);
//                    p.close();
//                } catch (FileNotFoundException ex){
//                    ex.printStackTrace();
//                }
//                
//            }
//            if(choice.equals("7"))
//            {
//                break;
//            }
//        } 
    }
     
}
