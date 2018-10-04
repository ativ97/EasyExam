
/**
 *
 * @author Ativ Aggarwal - aaggar9
 */




import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class ExamGraderGUI extends JFrame {

// Private instance variables
// ......
    private JPanel mainPanel;
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private JPanel Panel4;
    private JTextField Examname;
    private JButton Exam;
    private JTextField Studentname;
    private JButton Open;
    private JScrollPane scrollpane;
    private JTextField Import;
    private JTextArea textArea;
    private ExamGrader instance1;


    // Constructor to setup the GUI components and event handlers
    public ExamGraderGUI() {

        Container cp = getContentPane();            // Retrieve the top-level content-pane from JFrame

        mainPanel = new JPanel(new FlowLayout()); //main screen

        Panel1 = new JPanel(); //Contains a list box to display Score and a Button below Listbox to import CSV
        Panel1.setLayout(new BoxLayout(Panel1, BoxLayout.Y_AXIS));
        //String categories[] = { "Household", "Office", "Extended Family" };
        textArea= new JTextArea();
        textArea.setText("Score of a Student Answer File-\n\n");
        //JList list = new JList(categories);
        scrollpane = new JScrollPane(textArea);
        scrollpane.setPreferredSize(new Dimension(250, 300));
        scrollpane.setAlignmentX(LEFT_ALIGNMENT);
        Panel1.add(scrollpane);



        Panel2 = new JPanel(); //Contains Examname, Studentname and Open in horizontal order
        Panel2.setLayout(new BoxLayout(Panel2, BoxLayout.Y_AXIS));
        Examname= new JTextField("Exam file name");
        Panel2.add(Examname);
        Panel2.add(Box.createRigidArea(new Dimension(0,25)));
        Studentname= new JTextField("Student answer file name");
        Panel2.add(Studentname);
        Import= new JTextField("Name your a CSV file");
        //Import.setPreferredSize(new Dimension(10,20));
        Panel2.add(Box.createRigidArea(new Dimension(0,25)));
        Panel2.add(Import);
        Open= new JButton("Open");
        Panel2.add(Box.createRigidArea(new Dimension(0,25)));
        Panel2.add(Open);


        mainPanel.add(Panel1);
        mainPanel.add(Box.createRigidArea(new Dimension(40,0)));
        mainPanel.add(Panel2);

        cp.add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program when the close-window button clicked

        BtnListener listener = new BtnListener();           // Allocate an instance of inner class BtnListener.
        Open.addActionListener(listener);
        Import.addActionListener(listener);

        setTitle("ExamGrader");  // "super" JFrame sets title
        setSize(500, 400);   // "super" JFrame sets initial size
        setVisible(true);    // "super" JFrame shows
    }

    // The entry main() method
    public static void main(String[] args) {
        // Run GUI codes in Event-Dispatching thread for thread-safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExamGraderGUI();  // Let the constructor do the job
            }
        });
    }

    /**
     * BtnListener is a named inner class used as ActionEvent listener for all the Buttons.
     */
    private class BtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            JButton source = (JButton)evt.getSource();              // Need to determine which button has fired the event.
            if (source == Open) {

                String Examfilename= Examname.getText();
                String Studentfilename= Studentname.getText();
                String CSVfilename= Import.getText();


                if(Studentfilename.length()==0|| Studentfilename.equals("Student answer file name")){
                    Studentname.setText("Error");
                    return;
                }

                if (Examfilename.length()==0 || Examfilename.equals("Exam file name")){
                    Examname.setText("Checking for a Default filename...");
                    Examfilename="NoName";

                }

                if(CSVfilename.length()==0|| CSVfilename.equals("Name your a CSV file")){
                    Import.setText("Result.csv");
                    CSVfilename="Result.csv";
                }

                instance1= new ExamGrader(Examfilename, Studentfilename, CSVfilename);
                String categories = instance1.result;
                textArea.setText(categories);
                //scrollpane = new JScrollPane(textArea);
            }
        }
    }
}