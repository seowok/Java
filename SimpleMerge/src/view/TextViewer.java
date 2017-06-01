package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class TextViewer extends JPanel{
	private LeftText lefttext;
	private RightText righttext;
	public TextViewer()
	{
		super();
		setLayout(new GridLayout(1,2,10,10));
		lefttext = new LeftText();
		add(lefttext);
		righttext = new RightText();
		add(righttext);
	}
}
