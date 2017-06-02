import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

import view.*;

public class test {
	public static void main(String[] args) {

		JTextPane t = new JTextPane();
		t.setSelectionColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		Highlighter hilite = new MyHighlighter();
		t.setHighlighter(hilite);
		t.setText("Lin9e\n\n\n\nLine2\nLine3\nLine4\nLine5\n");
	
		DefaultHighlightPainter whitePainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
		DefaultHighlightPainter grayPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
		JPanel p = new JPanel(new BorderLayout());
		p.add(t, BorderLayout.CENTER);
		JFrame f = new JFrame();
		f.add(p);
		f.setSize(100, 100);
		f.setVisible(true);
		
		try {
			
			Document doc = t.getDocument();
			String[] text = doc.getText(0, doc.getLength()).split("\n");
			int start = 0;
			int end = 0;

			boolean even = true;

			// look for newline char, and then toggle between white and gray
			// painters.
			for(int i = 0; i < text.length; i ++)
			{
				if(text[i].length() != 0){
					hilite.addHighlight(start, start + text[i].length() + 1, grayPainter);
				}
				if(text[i].length() == 0){
					hilite.addHighlight(start, start + text[i].length() + 1, whitePainter);
				}
				start += text[i].length() + 1;
			}
		} 
		catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
}
