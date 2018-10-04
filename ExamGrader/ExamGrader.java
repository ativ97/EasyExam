import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;

/**
 *
 * Ativ Aggarwal
 * aaggar9
 */
public class ExamGrader {

    public Exam exm;

    public String result;

    public ExamGrader(String examFileName,String studentFileName, String csvFileName){
        Scanner x = null;
        Scanner y=null;
        File examFile = null, studentFile = null;
        if(examFileName.equals("NoName"))
        {
            try{
                studentFile = new File(studentFileName);
                x = new Scanner(studentFile);
                y = new Scanner(studentFile);

            }
            catch (FileNotFoundException ex){
                ex.printStackTrace();
                result="Student File not Found!";
                return;
            }
            x.nextLine();
            examFileName = x.nextLine();
            examFile = new File(examFileName);
            try{
                x = new Scanner(examFile);
                exm = new Exam(x);
            }
            catch (FileNotFoundException ex){
                ex.printStackTrace();
                result="Exam File not Found!";
                return;
            }

        }

        else if(!examFileName.equals("NoName"))
        {
            String examNameInFile;
            try{
                studentFile = new File(studentFileName);
                x = new Scanner(studentFile);
                y = new Scanner(studentFile);

            }
            catch (FileNotFoundException ex){
                ex.printStackTrace();
                result="Student File not Found!";
                return;

            }

            x.nextLine();
            examNameInFile = x.nextLine();
            if(!examFileName.equals(examNameInFile))
            {
                result= "The entered exam file names do not match! Exiting !";
                return;
            }
            examFile = new File(examFileName);
            try{
                x = new Scanner(examFile);
                exm = new Exam(x);
            }
            catch (FileNotFoundException ex){
                ex.printStackTrace();
                result="Exam File not Found!";
                return;
            }


        }


        exm.restoreStudentAnswers(y);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        exm.reportQuestionValues();
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Show what happened
        result=baos.toString();
        System.out.println(result);

        try {
            FileWriter fileWriter = new FileWriter(csvFileName);
            exm.saveResult(fileWriter);
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
