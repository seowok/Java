<<<<<<< HEAD
package view;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

public class RightText extends JTextPane{
	private Highlighter hilite;
	private Document doc;
	private DefaultHighlightPainter yellowPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
	private DefaultHighlightPainter grayPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);
	
	public RightText()
	{
		setText("Right");
		hilite = new MyHighlighter();
		setHighlighter(hilite); 
	}
}
=======
package view;

import javax.swing.JTextArea;

public class RightText extends JTextArea{
	public RightText()
	{
		setText("Right");
	}
}
>>>>>>> e45d3bbc1a3274c6fb6ade56f3e6a5e22427220a
