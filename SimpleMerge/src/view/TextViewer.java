package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TextViewer extends JPanel
{
	private LeftText lefttext;
	private RightText righttext;
	private JScrollPane lefttext_scroll;
	private JScrollPane righttext_scroll;
	
	public TextViewer()
	{
		super();
		setLayout(new GridLayout(1,2,10,10));
		lefttext = new LeftText();
		lefttext_scroll = new JScrollPane(lefttext);
		add(lefttext_scroll);
		
		righttext = new RightText();
		righttext_scroll = new JScrollPane(righttext);
		add(righttext_scroll);
	}
}
