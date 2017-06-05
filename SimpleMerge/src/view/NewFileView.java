package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.file.NewFile;
import view.TextViewer;

public class NewFileView extends JFrame {

	public TextViewer t;
	public JButton b1;
	public JButton b2;
	public JButton b3;
   public JRadioButton radioButton1;
   public JRadioButton radioButton2;
   public JRadioButton radioButton3;
   public JRadioButton radioButton4;
   
   public  JPanel radioPanel1;
   public JPanel radioPanel2;
   public JTextField text;
   
   public JPanel radioPanel3;
   public JPanel radioPanel4;
   
   public TextViewer newtextviewer;
   public NewFileView(TextViewer textviewer){
      
      
      newtextviewer = textviewer;
      setSize(400,300);
      setVisible(true);
     radioPanel1 = new JPanel();
     radioPanel2 = new JPanel();

      radioButton1 = new JRadioButton("저장(S)",true);
      radioButton2 = new JRadioButton("저장 안 함(D)");
      
      ButtonGroup aGroup = new ButtonGroup();
      aGroup.add(radioButton1);
      aGroup.add(radioButton2);
      
      
      text = new JTextField("이름없는 문서");
       text.setEditable(false);
       text.setSize(10,10);
      
      radioPanel1.setLayout(new FlowLayout());
      radioPanel1.add(radioButton1);
      radioPanel1.add(radioButton2);
      
      radioPanel2.setLayout(new BorderLayout());
      radioPanel2.add(radioPanel1,BorderLayout.SOUTH);
      radioPanel2.add(text,BorderLayout.NORTH);
      radioPanel2.setBorder(new TitledBorder("왼쪽 파일"));
      
      //오른쪽 문서
      
       radioPanel3 = new JPanel();
      radioPanel4 = new JPanel();

      radioButton3 = new JRadioButton("저장(A)",true);
      radioButton4 = new JRadioButton("저장 안 함(C)");
      
      ButtonGroup bGroup = new ButtonGroup();
      bGroup.add(radioButton3);
      bGroup.add(radioButton4);
      
      JTextField text2 = new JTextField("이름없는 문서");
       text2.setEditable(false);
      

      b1 = new JButton("모두 저장 안 함");
       b2 = new JButton("확인");
       b3 = new JButton("취소");
      
      radioPanel3.setLayout(new FlowLayout());
      radioPanel3.add(radioButton3);
      radioPanel3.add(radioButton4);
      
      radioPanel4.setLayout(new BorderLayout());
      radioPanel4.add(radioPanel3,BorderLayout.SOUTH);
      radioPanel4.add(text2,BorderLayout.NORTH);
      radioPanel4.setBorder(new TitledBorder("오른쪽 파일"));
      
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(2,1));
      p.add(radioPanel2);
      p.add(radioPanel4);
      
   
      JPanel p2 = new JPanel();
      
      p2.setLayout(new FlowLayout());
   
      p2.add(b1);
      p2.add(b2);
      p2.add(b3);
      
      
      setLayout(new BorderLayout());
      add(p,BorderLayout.CENTER);
      add(p2,BorderLayout.SOUTH);
      
      
      NewFile handler = new NewFile(this);
      radioButton1.addActionListener(handler);
      radioButton2.addActionListener(handler);
      radioButton3.addActionListener(handler);
      radioButton4.addActionListener(handler);
      b1.addActionListener(handler);
      b2.addActionListener(handler);
      b3.addActionListener(handler);
      
   }
}