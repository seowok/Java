package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

import model.compare.CompareLine;
import model.compare.Line;
import model.merge.MergeLine;



public class TextViewer extends JPanel {
	private CompareLine compareline = new CompareLine();
	Text lefttext;
	Text righttext;
	private JScrollPane lefttext_scroll;
	private JScrollPane righttext_scroll;
	private ArrayList<Line> left_notcomparedlines;
	private ArrayList<Line> right_notcomparedlines;
	private ArrayList<Line> compared_left_lines;
	private ArrayList<Line> compared_right_lines;
	private Document doc;
	private MergeLine mrgline;

	private ArrayList<LineColorOffset> left_linecolorlist;
	private ArrayList<LineColorOffset> right_linecolorlist;
	int linesetcolorindex = -1;

	public TextViewer() 
	{
		super();
		
		setLayout(new GridLayout(1, 2, 10, 10));
		lefttext = new Text();
		lefttext.setText("a\nb\nb\n\nC\nD");
		lefttext_scroll = new JScrollPane(lefttext);
		add(lefttext_scroll);

		righttext = new Text();
		righttext.setText("A\nB\na\nsdfssdf\nb\nC\n\nD");
		righttext_scroll = new JScrollPane(righttext);
		add(righttext_scroll);
	}
	void highliteText() 
	{
		String contents = "";
		left_notcomparedlines = compareline.constructLine(lefttext);
		right_notcomparedlines = compareline.constructLine(righttext);
		compareline.matchEqualLine(left_notcomparedlines, right_notcomparedlines);

		compared_left_lines = compareline.getComparedLeft();
		compared_right_lines = compareline.getComparedRight();

		for(int i = 0; i < compared_left_lines.size(); i++)
		{
			contents += compared_left_lines.get(i).line + "\n";
		}
		lefttext.setText(contents);
		contents = "";
		for(int i = 0; i < compared_right_lines.size(); i++)
		{
			contents += compared_right_lines.get(i).line + "\n";
		}
		righttext.setText(contents);
		
		
		lefttext = lefttext.acceptLineColor(compared_left_lines);
		righttext = righttext.acceptLineColor(compared_right_lines);
		
		left_linecolorlist = lefttext.getLineColorList();
		right_linecolorlist = righttext.getLineColorList();
	}

	void nextDiff() throws BadLocationException 
	{
		if (linesetcolorindex < left_linecolorlist.size()) {
			linesetcolorindex++;
			if (linesetcolorindex < left_linecolorlist.size()) 
			{
				lefttext.selectLineSet(linesetcolorindex);
				righttext.selectLineSet(linesetcolorindex);
			}
			else
				linesetcolorindex--;
		}
	}

	void prevDiff() throws BadLocationException 
	{
		if (linesetcolorindex > 0) {
			linesetcolorindex--;
			lefttext.selectLineSet(linesetcolorindex);
			righttext.selectLineSet(linesetcolorindex);
		}
	}
	
	void firstDiff() throws BadLocationException 
	{
		lefttext.selectLineSet(0);
		righttext.selectLineSet(0);
	}
	
	void lastDiff() throws BadLocationException 
	{
		lefttext.selectLineSet(left_linecolorlist.size() - 1);
		righttext.selectLineSet(right_linecolorlist.size() - 1);
	}
	void shiftRight()
	{
		int shift_start_line = left_linecolorlist.get(linesetcolorindex).getStartLine();
		int shift_end_line = left_linecolorlist.get(linesetcolorindex).getEndLine();
		mrgline.moveLineTo(compared_right_lines , compared_left_lines , shift_start_line, shift_end_line);
	}
	public Text getLefttext(){ return lefttext; }
	public Text getRighttext(){ return righttext; }
}