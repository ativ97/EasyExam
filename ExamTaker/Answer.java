
import javax.swing.*;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Ativ Aggarwal
 * aaggar9
 */
public abstract class Answer {

    protected Answer() {
    }

    public Answer(Scanner s) {
    }

    public abstract void print(int i, JTextArea questionArea);

    public abstract double getCredit(Answer rightAnswer);

    public abstract void save(PrintWriter writer);

}
