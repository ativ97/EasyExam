

/**
 *
 * @author Neil Champakara - nchamp3
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamTakerGUI extends JFrame
{

    private JFrame frame;
    private JPanel mainPanel, namePanel, questionPanel, panel1, subpanel, answerPanel, buttonPanel, examNamePanel;
    //private static JPanel mainPanel;
    private JTextField nameField, examNameField;
    private JTextArea answerArea, questionArea;
    private JLabel qLabel, nameLabel, title, answerLabel, examNameLabel;
    private JScrollPane qsp, asp;
    private JButton next, skip, leave, submit, ok;
    private int qnum = 0, numSkipped = 0, displaySkipPrompt = 0, displaySkippedQuestion = 0;
    private String examName;
    private ExamTaker et;
    private Exam eObj;

    public ExamTakerGUI()
    {

        mainPanel = new JPanel(new FlowLayout());
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.Y_AXIS));

        panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        title = new JLabel("SAMPLE EXAM");
        panel1.add(title);
        subpanel.add(panel1);


        namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        nameLabel = new JLabel("Enter your name: ");
        namePanel.add(nameLabel);
        nameField = new JTextField(8);
        namePanel.add(Box.createRigidArea(new Dimension(10,0)));
        namePanel.add(nameField);
        //namePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        examNamePanel = new JPanel();
        examNamePanel.setLayout(new BoxLayout(examNamePanel, BoxLayout.X_AXIS));
        examNameLabel = new JLabel("Enter the name of the exam file: ");
        examNamePanel.add(examNameLabel);
        examNameField = new JTextField(8);
        examNamePanel.add(Box.createRigidArea(new Dimension(10,0)));
        examNamePanel.add(examNameField);


        questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.X_AXIS));
        qLabel = new JLabel("Question: ");
        /*qLabel.setOpaque(true);
        qLabel.setBackground(Color.red);*/
        //qLabel.setHorizontalAlignment(SwingConstants.LEFT);
        questionPanel.add(qLabel);
        questionArea = new JTextArea();
        questionArea.setEditable(false);
        /*questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setSize(200,5);*/
        qsp = new JScrollPane(questionArea);
        qsp.setPreferredSize(new Dimension(400, 200));
        questionPanel.add(Box.createRigidArea(new Dimension(10,0)));
        questionPanel.add(qsp);

        answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.X_AXIS));
        answerLabel = new JLabel("Answer: ");
        answerPanel.add(answerLabel);
        answerArea = new JTextArea();
        answerArea.setEditable(true);
        asp = new JScrollPane(answerArea);
        asp.setPreferredSize(new Dimension(100, 50));
        answerPanel.add(Box.createRigidArea(new Dimension(10,0)));
        answerPanel.add(asp);
        answerPanel.add(Box.createRigidArea(new Dimension(10,0)));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        skip = new JButton("Skip");
        next = new JButton("Next");
        leave = new JButton("Leave");
        submit = new JButton("Submit");
        ok = new JButton("Ok");
        buttonPanel.add(skip);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
        buttonPanel.add(next);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
        buttonPanel.add(leave);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
        buttonPanel.add(ok);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
        buttonPanel.add(submit);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));


        subpanel.add(Box.createRigidArea(new Dimension(0,40)));
        subpanel.add(namePanel);
        subpanel.add(Box.createRigidArea(new Dimension(0,40)));
        subpanel.add(examNamePanel);
        subpanel.add(Box.createRigidArea(new Dimension(0,40)));
        subpanel.add(questionPanel);
        subpanel.add(Box.createRigidArea(new Dimension(0,40)));
        subpanel.add(answerPanel);
        subpanel.add(Box.createRigidArea(new Dimension(0,40)));
        subpanel.add(buttonPanel);

        leave.setEnabled(false);
        submit.setEnabled(false);
        ok.setEnabled(false);
        skip.setEnabled(false);
        next.setEnabled(false);


        mainPanel.add(subpanel);
        setContentPane(mainPanel);
        setSize(700,700);
        setTitle("Sample Exam");
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bListener listener = new bListener();
        skip.addActionListener(listener);
        next.addActionListener(listener);
        leave.addActionListener(listener);
        submit.addActionListener(listener);
        ok.addActionListener(listener);
        examNameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                examName = examNameField.getText();
                et = new ExamTaker(examName);
                questionArea.setText(null);
                et.nextQuestion(0, questionArea);
                answerArea.setText(null);
                skip.setEnabled(true);
                next.setEnabled(true);
            }
        });
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExamTakerGUI();
            }
        });
    }

    private class bListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            //qnum++;
            JButton sourceButton = (JButton) evt.getSource();
            if (sourceButton == skip)
            {

                if(qnum == et.totalQuestions())
                {
                    if(numSkipped > 0)
                    {
                        next.doClick();
                        /*leave.setEnabled(true);
                        skip.setEnabled(false);

                        questionArea.setText(null);
                        answerArea.setText(null);
                        if(displaySkipPrompt == 0)
                        {
                            ok.setEnabled(true);
                            next.setEnabled(false);
                            leave.setEnabled(false);
                            questionArea.append("You will now be asked to answer the questions you skipped before.\n");
                            questionArea.append("Press Next when done answering\nor \n");
                            questionArea.append("Press Leave to go to the next question and leave this unanswered.\n");
                            questionArea.append("Press Ok to continue.\n");

                            displaySkipPrompt = 1;
                        }*/

                        //while(numSkipped > 0)
                        //{
                        /*et.showSkipped(questionArea);
                        et.acceptSkipped(answerArea);
                        numSkipped--;
                        displaySkipPrompt = 1;*/
                        //}
                    }
                    else
                    {
                        submit.setEnabled(true);
                        ok.setEnabled(true);
                        skip.setEnabled(false);
                        next.setEnabled(false);
                        leave.setEnabled(false);

                        questionArea.setText(null);
                        //answerArea.setText(null);
                        questionArea.append("Would you like to reanswer any questions? skipped \n");
                        questionArea.append("If yes, enter the question number and press Ok, otherwise just press Submit\n");
                        //et.reanswerQuestions();
                    }


                }
                else
                {
                    et.skipQuestion(qnum);
                    qnum++;
                    numSkipped++;


                    questionArea.setText(null);
                    //answerArea.setText(null);
                    if(qnum != et.totalQuestions())
                        et.nextQuestion(qnum, questionArea);
                    else
                    {
                        skip.doClick();
                    }
                }

            }
            else if (sourceButton == next)
            {
                if(qnum == et.totalQuestions())
                {
                    //answer skipped and enable "leave" button
                    if(numSkipped > 0)
                    {
                        leave.setEnabled(true);
                        skip.setEnabled(false);

                        questionArea.setText(null);
                        answerArea.append("ACCEPTED \n");


                        if(displaySkipPrompt == 1)
                        {
                            questionArea.append(displaySkipPrompt + "\n");
                            //et.showSkipped(questionArea);
                            et.acceptSkipped(answerArea);
                            answerArea.setText(null);

                            et.showSkipped(questionArea);
                            numSkipped--;
                            displaySkipPrompt = 1;
                            if(numSkipped == 0)
                                next.doClick();
                        }
                        else
                        {
                            answerArea.setText(null);
                            ok.setEnabled(true);
                            ok.setEnabled(true);
                            next.setEnabled(false);
                            leave.setEnabled(false);

                            questionArea.append("You will now be asked to answer the questions you skipped before.\n");
                            questionArea.append("Press Next when done answering\nor \n");
                            questionArea.append("Press Leave to go to the next question and leave this unanswered.\n");
                            questionArea.append("Press Ok to continue.\n");

                            displaySkipPrompt = 1;
                        }
                    }
                    else
                    {
                        submit.setEnabled(true);
                        ok.setEnabled(true);
                        skip.setEnabled(false);
                        next.setEnabled(false);
                        leave.setEnabled(false);

                        questionArea.setText(null);
                        answerArea.setText(null);
                        questionArea.append("Would you like to reanswer any questions? \n");
                        questionArea.append("If yes, enter the question number and press Ok, otherwise just press Submit\n");
                    }
                }
                else
                {
                    et.acceptAnswer(qnum, answerArea);
                    questionArea.setText(null);
                    answerArea.setText(null);
                    qnum++;
                    if(qnum != et.totalQuestions())
                        et.nextQuestion(qnum, questionArea);
                    else
                    {
                        next.doClick();
                    }
                }
            }
            else if (sourceButton == leave)
            {
                if(numSkipped > 0)
                {
                    et.leaveQuestion(questionArea, answerArea);
                    numSkipped--;
                    if(numSkipped == 0)
                        leave.doClick();
                }

                else
                {
                    submit.setEnabled(true);
                    ok.setEnabled(true);
                    skip.setEnabled(false);
                    next.setEnabled(false);
                    leave.setEnabled(false);

                    questionArea.setText(null);
                    answerArea.setText(null);
                    questionArea.append("Would you like to reanswer any questions? \n");
                    questionArea.append("If yes, enter the question number and press Ok, otherwise just press Submit\n");
                }
            }
            else if (sourceButton == submit)
            {
                    et.submit(nameField.getText());
                    answerArea.append("Submitted!");
                    submit.setEnabled(false);
                    ok.setEnabled(false);
                    nameField.setEditable(false);
                    examNameField.setEditable(false);
                    answerArea.setEditable(false);

            }
            else if(sourceButton == ok)
            {
                try
                {
                    int reanswerQNum = Integer.parseInt(answerArea.getText());
                    if(reanswerQNum > 0 && reanswerQNum <= et.totalQuestions())
                    {
                        questionArea.setText(null);
                        answerArea.setText(null);

                        submit.setEnabled(false);
                        skip.setEnabled(false);
                        leave.setEnabled(false);
                        ok.setEnabled(false);
                        next.setEnabled(true);

                        et.nextQuestion(reanswerQNum-1, questionArea);
                        questionArea.append("\nPress Next when done answering\n");
                        //et.reanswerQuestions(reanswerQNum);
                        //et.acceptAnswer(reanswerQNum-1, answerArea);
                    }
                    else
                    {
                        answerArea.setText(null);
                        questionArea.append("Enter a valid question number\n");
                    }
                }
                catch (NumberFormatException e)
                {
                    if(displaySkippedQuestion == 0)
                    {
                        et.showSkipped(questionArea);
                        answerArea.setText(null);
                        displaySkippedQuestion = 1;
                        ok.setEnabled(false);
                        next.setEnabled(true);
                        leave.setEnabled(true);
                    }
                    else
                        questionArea.append("Enter a valid question number\n");
                }
            }
        }
    }
}
