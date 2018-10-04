/**
 * Created by Neil Champakara (nchamp3) on 3/13/2018.
 */

import javax.swing.*;
import java.util.*;
import java.io.*;

public class ExamTaker {

    public ArrayList<Integer> skipped;
    public Exam obj;
    public int skippedCount = 0;
    String filename;

    /*public static void main(String[] args)
    {
        System.out.println("Testing Exam Taker");
        ExamTaker et = new ExamTaker();
    }*/

    public ExamTaker(String examName) //send filename
    {

        ScannerFactory sf = new ScannerFactory();
        Scanner sc = sf.getKeyboardScanner();
        try {
            //System.out.println("Please enter your name");
            //String name = sc.nextLine();
            filename = examName;
            //String filename = "se.txt";
            File f = new File(filename);
            Scanner sc1 = new Scanner(f);
            obj = new Exam(sc1);
            //int num = obj.getNumQuestion();
            //obj.print();
            skipped = new ArrayList<Integer>();
            /*for(int i = 0; i < num; i++)
            {
                System.out.println("Would you like to answer the  " + (i+1) + "question.");
                System.out.println("Press Y if you want to answer it or S if you want to skip it");
                String choice = sc.nextLine();
                if(choice.equals("Y")||choice.equals("y"))
                {
                    obj.getAnswerFromStudent(i+1);
                }
                else
                {
                    skipped.add(i);
                }
            }*/

            /*if(skipped.size()!= 0) {
                System.out.println("You will now be asked to answer the questions you skipped before");
                System.out.println("Press Enter to go to the next question and leave this unanswered");
                for (int i = 0; i < skipped.size(); i++) {
                    System.out.println("Question: " + (skipped.get(i)+1));
                    obj.getAnswerFromStudent(skipped.get(i) + 1);
                }
            }*/
            /*while(true)
            {
                System.out.println("Would you like to reanswer any question? ");
                System.out.println("If Yes enter question number or press X to close");
                String choice = sc.nextLine();
                if(choice.equals("X")||choice.equals("x"))
                {
                    break;
                }
                else
                {
                    int choiceInt = Integer.parseInt(choice);
                    obj.getAnswerFromStudent(choiceInt);
                }
            }*/
            /*File studentFile = new File(name+".txt");
            PrintWriter pr = new PrintWriter(studentFile);
            obj.saveStudentAnswers(pr,name,filename);
            pr.close();*/
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void skipQuestion(int i)
    {
        skipped.add(i);
    }

    public void acceptAnswer(int i, JTextArea answerArea)
    {
        obj.getAnswerFromStudent(i+1, answerArea);
    }

    public void nextQuestion(int i, JTextArea questionArea)
    {
        questionArea.setText(null);
        //answerArea.setText(null);
        obj.print(i, questionArea);
    }

    public void showSkipped(JTextArea questionArea)
    {
        if(skipped.size()!= 0 && skippedCount != skipped.size()) {
            //System.out.println("You will now be asked to answer the questions you skipped before");
            //System.out.println("Press Enter to go to the next question and leave this unanswered");
            //for (skippedCount = 0; skippedCount < skipped.size(); skippedCount++) {
                //System.out.println("Question: " + (skipped.get(skippedCount)+1));
                //questionArea.append("question " + skippedCount + "\n");
                nextQuestion(skipped.get(skippedCount), questionArea);
                //obj.getAnswerFromStudent(skipped.get(skippedCount) + 1, answerArea);
                skippedCount++;
            //}
        }
    }

    public void acceptSkipped(JTextArea answerArea)
    {
        if(skipped.size()!= 0 && skippedCount != skipped.size()) {
            //System.out.println("You will now be asked to answer the questions you skipped before");
            //System.out.println("Press Enter to go to the next question and leave this unanswered");
            //for (skippedCount = 0; skippedCount < skipped.size(); skippedCount++) {
            //System.out.println("Question: " + (skipped.get(skippedCount)+1));
            //nextQuestion(skipped.get(skippedCount), questionArea);
            obj.getAnswerFromStudent(skipped.get(skippedCount) + 1, answerArea);
            //skippedCount++;
            //}
        }
    }

    public void leaveQuestion(JTextArea questionArea, JTextArea answerArea)
    {
        //skippedCount++;
        showSkipped(questionArea);
    }

    public void reanswerQuestions(int choiceInt, JTextArea answerArea)
    {
        //while(true)
        //{
            /*questionArea.setText(null);
            questionArea.append("Would you like to reanswer any questions? \n");
            questionArea.append("If yes, enter the question number and press Submit, otherwise just press Submit");*/
            //String choice = sc.nextLine();

                //int choiceInt = Integer.parseInt(choice);
                obj.getAnswerFromStudent(choiceInt, answerArea);

        //}
    }

    public void submit(String studentName)
    {
        try
        {
            File studentFile = new File(studentName +".txt");
            PrintWriter pr = new PrintWriter(studentFile);
            obj.saveStudentAnswers(pr,studentName,filename);
            pr.close();
        }
        catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }
    }

    public int totalQuestions()
    {
        return obj.getNumQuestion();
    }
}
