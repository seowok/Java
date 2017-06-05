package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.file.BringFile;
import controller.file.OpenFile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BringFileView extends JFrame  {

	public JButton Confirm;
	public JButton Cancel;
	public JButton Help;
	public JButton FindLeft;
	public JButton  FindRight;
	public JButton  SelectFil;
	public JButton SelectUn;

	public JComboBox combo1;
	public JComboBox combo2;
	public JComboBox combo3;
	public JComboBox combo4;
	
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;
	public JLabel label4;
	public JLabel label5;
	public JLabel label6;
	public JLabel label7;
	
	public JPanel Mainpanel ;
	public JPanel Eastpanel;
	public JPanel centerpanel;
	
	public JPanel panel1 ;
	public JPanel panel2;
	public JPanel Fullpanel = new JPanel();
	public TextViewer text ;
	
	
	BringFile handler = new BringFile(this);
	public BringFileView(TextViewer text) {
this.text = text;
		setBounds(100, 100, 800, 300);
		setLayout(new BorderLayout());

		 label1 = new JLabel("����(L):");
		 label2 = new JLabel("������(R):");
		 label3 = new JLabel("����(F):");
		 label4 = new JLabel("����Ŀ(U:)");
		 label5 = new JLabel("���� ���丮/���� ����");
		 label6 = new JLabel(""); // ��ĭ �����
		 label7 = new JLabel("");

		JCheckBox box = new JCheckBox("���� ���丮 ����(I)");

		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		label4.setHorizontalAlignment(SwingConstants.RIGHT);

		Confirm = new JButton("Ȯ��");
		Cancel = new JButton("���");
		Help = new JButton("����");
		FindLeft = new JButton("ã�ƺ���(B)");
		FindRight = new JButton("ã�ƺ���(W)");
		SelectFil = new JButton("����...");
		SelectUn = new JButton("����(s)...");

		combo1 = new JComboBox();
		combo2 = new JComboBox();
		combo3 = new JComboBox();
		combo4 = new JComboBox();

		Confirm.setEnabled(false);

		
		Confirm.addActionListener(handler);
		Cancel.addActionListener(handler);
		Help.addActionListener(handler);
		FindLeft.addActionListener(handler);
		FindRight.addActionListener(handler);
		SelectFil.addActionListener(handler);
		SelectUn.addActionListener(handler);

		Mainpanel = new JPanel();
		Mainpanel.setLayout(new GridLayout(5, 3, 10, 15));
		Mainpanel.add(label1);
		Mainpanel.add(combo1);
		Mainpanel.add(FindLeft);
		Mainpanel.add(label2);
		Mainpanel.add(combo2);
		Mainpanel.add(FindRight);
		Mainpanel.add(label3);
		Mainpanel.add(combo3);
		Mainpanel.add(SelectFil);
		Mainpanel.add(label4);
		Mainpanel.add(combo4);
		Mainpanel.add(SelectUn);
		Mainpanel.add(label6);
		Mainpanel.add(box);

		Eastpanel = new JPanel();
		Eastpanel.setLayout(new GridLayout(8, 1, 5, 5));
		Eastpanel.add(label7);
		Eastpanel.add(Confirm);
		Eastpanel.add(Cancel);
		Eastpanel.add(Help);

		centerpanel = new JPanel();
		centerpanel.setLayout(new BorderLayout());
		centerpanel.add(Mainpanel, BorderLayout.CENTER);
		centerpanel.add(label5, BorderLayout.SOUTH);
		centerpanel.setBorder(new TitledBorder("���� ���丮 / ����"));

		panel1 = new JPanel();// EMPTY
		panel2 = new JPanel();// EMPTY

	
		Fullpanel.setLayout(new BorderLayout());
		Fullpanel.add(Eastpanel, BorderLayout.EAST);
		Fullpanel.add(centerpanel, BorderLayout.CENTER);
		Fullpanel.add(panel1, BorderLayout.NORTH);
		Fullpanel.add(panel2, BorderLayout.SOUTH);

		add(Fullpanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}