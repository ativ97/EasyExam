/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;        
import java.awt.event.*;  

/**
 *
 * @author Krishna Vamsi Chandu - kchand23
 */
public class ExamBuilderGUI extends JFrame {
    
    
    private ExamBuilder exm = new ExamBuilder();
    private JFrame SAQ;
    
    private JPanel parent = new JPanel();
    private JPanel cardContainer = new JPanel();
    private JPanel one = new JPanel();
    private JPanel two = new JPanel();
    private JPanel temp = new JPanel();
    private JPanel three = new JPanel();
    private JPanel four = new JPanel();
    private JPanel five = new JPanel();
    private JPanel six = new JPanel();
    private JPanel seven = new JPanel();
    
    private JDialog SA = new JDialog();
    private JDialog MCSA = new JDialog();
    private JDialog MCMA = new JDialog();
    private JDialog Num = new JDialog();
    private JDialog mcsaAddOpt = new JDialog();
    private JDialog mcmaAddOpt = new JDialog();
    
    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private JRadioButton r4;
    private JRadioButton r5;
    private JRadioButton r6;
    private JRadioButton r7;
    
    private JRadioButton tr1;
    private JRadioButton tr2;
    private JRadioButton tr3;
    private JRadioButton tr4;
    
    private JCheckBox cb1 = new JCheckBox("Shuffle Options too!");
    
    private JButton oBut = new JButton("Submit");
    private JButton bBut = new JButton("Submit");
    private JButton tBut = new JButton("Submit");
    private JButton fBut = new JButton("Remove");
    private JButton fvBut = new JButton("Shuffle");
    private JButton sBut = new JButton("Back");
    private JButton svBut = new JButton("Save");
    private JButton saBut = new JButton("Add Question");
    private JButton numBut = new JButton("Add Question");
    private JButton mcsaBut = new JButton("Add Question");
    private JButton mcmaBut = new JButton("Add Question");
    private JButton mcsaOptBut = new JButton("Add Option");
    private JButton mcmaOptBut = new JButton("Add Option");
    private JButton mcsaAddOptBut = new JButton("Add Option");
    private JButton mcmaAddOptBut = new JButton("Add Option");
    
    private JTextField tTxtFld = new JTextField("Enter text here", 20);
    private JTextField fTxtFld = new JTextField("Enter text here", 20);
    private JTextArea sTxtFld = new JTextArea(20, 20);
    private JTextField svTxtFld = new JTextField("Enter text here", 20);
    private JTextField mcsaoptTxtFld = new JTextField("Enter text here", 20);
    private JTextField mcsaoptValue = new JTextField("Enter text here", 20);
    
    private JTextField saq = new JTextField("Enter text here", 20);
    private JTextField sav = new JTextField("Enter text here", 20);
    private JTextField sar = new JTextField("Enter text here", 20);
    
    private JTextField numq = new JTextField("Enter text here", 20);
    private JTextField numv = new JTextField("Enter text here", 20);
    private JTextField numr = new JTextField("Enter text here", 20);
    private JTextField numt = new JTextField("Enter text here", 20);
    
    private JTextField mcsaq = new JTextField("Enter text here", 20);
    private JTextField mcsav = new JTextField("Enter text here", 20);
    
    private JTextField mcmaq = new JTextField("Enter text here", 20);
    private JTextField mcmav = new JTextField("Enter text here", 20);
    private JTextField mcmab = new JTextField("Enter text here", 20);
    
    private JTextField mcmaoptTxtFld = new JTextField("Enter text here", 20);
    private JTextField mcmaoptValue = new JTextField("Enter text here", 20);
    
    private CardLayout cl = new CardLayout(10,10);
    
    private JLabel tLab = new JLabel("Enter Name of Exam File");
    private JLabel fLab = new JLabel("Enter the question number to remove");
    private JLabel qLab = new JLabel("Enter the question");
    private JLabel vLab = new JLabel("Enter the Value");
    private JLabel aLab = new JLabel("Enter the right Answer");
    private JLabel saqLab = new JLabel("Enter the question");
    private JLabel savLab = new JLabel("Enter the Value");
    private JLabel saaLab = new JLabel("Enter the right Answer");
    private JLabel mcsaqLab = new JLabel("Enter the question");
    private JLabel mcsavLab = new JLabel("Enter the Value");
    private JLabel mcmaqLab = new JLabel("Enter the questione");
    private JLabel mcmavLab = new JLabel("Enter the Value");
    private JLabel mcmabLab = new JLabel("Enter baseCredit");
    private JLabel mcsaOptLab = new JLabel("Enter option");
    private JLabel mcsaOptvLab = new JLabel("Enter Value");
    private JLabel mcmaOptLab = new JLabel("Enter option");
    private JLabel mcmaOptvLab = new JLabel("Enter Value");
    private JLabel numqLab = new JLabel("Enter the question");
    private JLabel numvLab = new JLabel("Enter the Value");
    private JLabel numaLab = new JLabel("Enter the right Answer");
    private JLabel numtLab = new JLabel("Enter the tolerance");
    
    private String examName;
    private String deleteString;
    private String saveFileName;
            
    private ButtonGroup bg, bg1; 
    
    private JScrollPane scroll = new JScrollPane(sTxtFld);
    
    private MCSAQuestion mcsaqTemp;
    private MCMAQuestion mcmaqTemp;
    
    public ExamBuilderGUI() {
        parent.setLayout(new BoxLayout(parent, BoxLayout.X_AXIS));
        cardContainer.setLayout(cl);
        setTitle("My Empty Frame");
        //container.setSize(); // default size is 0,0
        
        one.setSize(500,500);
        //one.setSize();
        //setLocation(10,200); // default is 0,0 (top left corner)
        //JButton b=new JButton("Submit");    
        //b.setBounds(100,100,140, 40);    
        //add(b);   
        
        r1=new JRadioButton("Load Saved Exam");    
        r2=new JRadioButton("Add Question");
        r3=new JRadioButton("Remove Question");    
        r4=new JRadioButton("Reorder Questions");
        r5=new JRadioButton("Show Exam");    
        r6=new JRadioButton("Save Exam");
        r7=new JRadioButton("Quit");    
        
        tr1 = new JRadioButton("SAQuestion");
        tr2 = new JRadioButton("MCSAQuestion");
        tr3 = new JRadioButton("MCMAQuestion");
        tr4 = new JRadioButton("NumQuestion");
        
        
        /*r1.setBounds(25,25,150,30);    
        r2.setBounds(25,75,150,30); 
        r3.setBounds(25,125,150,30);    
        r4.setBounds(25,175,150,30); 
        r5.setBounds(25,225,150,30);    
        r6.setBounds(25,275,150,30); 
        r7.setBounds(25,325,150,30);*/
        
        
        Listener lstnr = new Listener(); 
        BackButtonListener bLstnr = new BackButtonListener();
        
        bg=new ButtonGroup();    
        bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4); bg.add(r5);bg.add(r6); bg.add(r7);  
        one.add(r1);one.add(r2);one.add(r3);one.add(r4);one.add(r5);one.add(r6);one.add(r7);
        one.add(oBut);
        one.setLayout(new BoxLayout (one, BoxLayout.Y_AXIS));
        
        
        two.add(tLab);
        two.add(tTxtFld);
        two.add(bBut);
        two.setLayout(new BoxLayout (two, BoxLayout.Y_AXIS));
        
        
        bg1=new ButtonGroup();
        bg1.add(tr1);bg1.add(tr2);bg1.add(tr3);bg1.add(tr4);
        three.add(tr1);three.add(tr2);three.add(tr3);three.add(tr4);
        three.add(tBut);
        three.setLayout(new BoxLayout (three, BoxLayout.Y_AXIS));
        
        four.add(fLab);
        four.add(fTxtFld);
        four.add(fBut);
        four.setLayout(new BoxLayout (four, BoxLayout.Y_AXIS));
        
        five.add(cb1);
        five.add(fvBut);
        five.setLayout(new BoxLayout (five, BoxLayout.Y_AXIS));
        
        six.add(scroll);
        six.setLayout(new BoxLayout (six, BoxLayout.Y_AXIS));
        
        seven.add(svTxtFld);
        seven.add(svBut);
        seven.setLayout(new BoxLayout (seven, BoxLayout.Y_AXIS));
        
        SA.add(saqLab);
        SA.add(saq);
        SA.add(savLab);
        SA.add(sav);
        SA.add(saaLab);
        SA.add(sar);
        SA.add(saBut);
        SA.setSize(300,300); 
        SA.setLayout(new FlowLayout());
        
        Num.add(numqLab);
        Num.add(numq);
        Num.add(numvLab);
        Num.add(numv);
        Num.add(numtLab);
        Num.add(numt);
        Num.add(numaLab);
        Num.add(numr);
        Num.add(numBut);
        Num.setSize(300,300); 
        Num.setLayout(new FlowLayout());
        
        MCSA.add(mcsaqLab);
        MCSA.add(mcsaq);
        MCSA.add(mcsavLab);
        MCSA.add(mcsav);
        MCSA.add(mcsaOptBut);
        MCSA.add(mcsaBut);
        MCSA.setSize(300,300); 
        MCSA.setLayout(new FlowLayout());
        
        MCMA.add(mcmaqLab);
        MCMA.add(mcmaq);
        MCMA.add(mcmavLab);
        MCMA.add(mcmav);
        MCMA.add(mcmabLab);
        MCMA.add(mcmab);
        MCMA.add(mcmaOptBut);
        MCMA.add(mcmaBut);
        MCMA.setSize(300,300); 
        MCMA.setLayout(new FlowLayout());
        
        mcsaAddOpt.add(mcsaOptLab);
        mcsaAddOpt.add(mcsaoptTxtFld);
        mcsaAddOpt.add(mcsaOptvLab);
        mcsaAddOpt.add(mcsaoptValue);
        mcsaAddOpt.add(mcsaAddOptBut);
        mcsaAddOpt.setSize(300,300); 
        mcsaAddOpt.setLayout(new FlowLayout());
        
        mcmaAddOpt.add(mcmaOptLab);
        mcmaAddOpt.add(mcmaoptTxtFld);
        mcmaAddOpt.add(mcmaOptvLab);
        mcmaAddOpt.add(mcmaoptValue);
        mcmaAddOpt.add(mcmaAddOptBut);
        mcmaAddOpt.setSize(300,300); 
        mcmaAddOpt.setLayout(new FlowLayout());
        
        oBut.addActionListener(lstnr);
        bBut.addActionListener(bLstnr);
        tBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                if(tr1.isSelected())
                {
                    SA.setVisible(true);
                }
                else if(tr2.isSelected())
                {
                    MCSA.setVisible(true);
                }
                else if(tr3.isSelected())
                {
                    MCMA.setVisible(true);
                }
                else if(tr4.isSelected())
                {
                     Num.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select an option");
                } 
            }
        });
        
        fBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                
                deleteString = fTxtFld.getText();
            
                if(deleteString.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "No text entered!");
                }
                else
                {
                    exm.deleteQuestion(deleteString);
                }
                cl.show(cardContainer,"1");
                
            }
        });
        
        fvBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                if(cb1.isSelected())
                {
                    exm.reorderQuestion("y");
                }
                else
                    exm.reorderQuestion("n");
            }
        });
        
        svBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                saveFileName = svTxtFld.getText();
            
                if(saveFileName.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "No text entered!");
                }
                else
                {
                    exm.saveToFile(saveFileName);
                }
                cl.show(cardContainer,"1");
            }
        });
        
        saBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                String saQ = saq.getText();
                String saV = sav.getText();
                String saR = sar.getText();
                
                exm.addSAQuestion(saQ, saV, saR);
                JOptionPane.showMessageDialog(null, "Question Added");
                SA.setVisible(false);
                cl.show(cardContainer,"1");
            }
        });
        
        numBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                String numQ = numq.getText();
                String numV = numv.getText();
                String numT = numt.getText();
                String numR = numr.getText();
                
                exm.addNumQuestion(numQ, numV, numT,numR);
                JOptionPane.showMessageDialog(null, "Question Added");
                Num.setVisible(false);
                cl.show(cardContainer,"1");
            }
        });
        
        mcsaOptBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                String mcsaQ = mcsaq.getText();
                String mcsaV = mcsav.getText();
                if(mcsaqTemp == null)
                    mcsaqTemp = exm.getMCSAQuestion(mcsaQ, mcsaV);
                mcsaAddOpt.setVisible(true);
            }
        });
        
        mcmaOptBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                String mcmaQ = mcmaq.getText();
                String mcmaV = mcmav.getText();
                String mcmaB = mcmab.getText();
                if(mcmaqTemp == null)
                    mcmaqTemp = exm.getMCMAQuestion(mcmaQ, mcmaV,mcmaB);
                mcmaAddOpt.setVisible(true);
            }
        });
        
        mcsaAddOptBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                String mcsaOptText = mcsaoptTxtFld.getText();
                String mcsaOptVal = mcsaoptValue.getText();
                mcsaqTemp = exm.addMCSAOption(mcsaqTemp, mcsaOptText, mcsaOptVal);
                mcsaAddOpt.setVisible(false);
            }
        });
        
        mcmaAddOptBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                String mcmaOptText = mcmaoptTxtFld.getText();
                String mcmaOptVal = mcmaoptValue.getText();
                mcmaqTemp = exm.addMCMAOption(mcmaqTemp, mcmaOptText, mcmaOptVal);
                mcmaAddOpt.setVisible(false);
            }
        });
        
        mcsaBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                JOptionPane.showMessageDialog(null, "Question Added");
                exm.addMCSAQuestion(mcsaqTemp);
                MCSA.setVisible(false);
                mcmaqTemp = null;
                cl.show(cardContainer,"1");
            }
        });
        
        mcmaBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                JOptionPane.showMessageDialog(null, "Question Added");
                exm.addMCMAQuestion(mcmaqTemp);
                MCMA.setVisible(false);
                mcmaqTemp = null;
                cl.show(cardContainer,"1");
            }
        });
        
        //cardContainer.add(one,"1");
        cardContainer.add(temp,"1");
        cardContainer.add(two,"2");
        cardContainer.add(three,"3");
        cardContainer.add(four,"4");
        cardContainer.add(five,"5");
        cardContainer.add(six,"6");
        cardContainer.add(seven,"7");
        
        cl.show(cardContainer, "1");
        //Container pane = this.getContentPane();
        parent.setSize(500,500);
        temp.setSize(500,500);
        parent.add(one);
        parent.add(cardContainer);
        add(parent);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        pack();
        
    }
    
    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            if(r1.isSelected())
            {
                tTxtFld.setText("");
                cl.show(cardContainer, "2");
                
            }
            else if(r2.isSelected())
            {
                
                cl.show(cardContainer, "3");
            }
            else if(r3.isSelected())
            {
                fTxtFld.setText("");
                cl.show(cardContainer, "4");
            }
            else if(r4.isSelected())
            {
                cl.show(cardContainer, "5");
            }
            else if(r5.isSelected())
            {
                exm.print(sTxtFld);
                cl.show(cardContainer, "6");
            }
            else if(r6.isSelected())
            {
                svTxtFld.setText("");
                cl.show(cardContainer, "7");
            }
            else if(r7.isSelected())
            {
                System.exit(0);
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an option");
            }
        }
    }
    
    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            examName = tTxtFld.getText();
            
            if(examName.equals(""))
            {
                JOptionPane.showMessageDialog(null, "No text entered!");
            }
            else
            {
                exm.loadExam(examName);
            }
            cl.show(cardContainer,"1");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame f = new ExamBuilderGUI();
        f.show();
    }
}
