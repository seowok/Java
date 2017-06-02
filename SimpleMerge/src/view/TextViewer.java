package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

import controller.compare.CompareLine;
import controller.compare.Line;

public class TextViewer extends JPanel {
	private CompareLine compareline = new CompareLine();
	private Text lefttext;
	private Text righttext;
	private JScrollPane lefttext_scroll;
	private JScrollPane righttext_scroll;
	private ArrayList<Line> left_notcomparedlines;
	private ArrayList<Line> right_notcomparedlines;
	private Document doc;

	private ArrayList<LineColorOffset> left_linecolorlist;
	private ArrayList<LineColorOffset> right_linecolorlist;
	int linesetcolorindex = 0;

	public TextViewer() {
		super();
		setLayout(new GridLayout(1, 2, 10, 10));
		lefttext = new Text("filepath");
		lefttext_scroll = new JScrollPane(lefttext);
		add(lefttext_scroll);

		righttext = new Text("filepath");
		righttext_scroll = new JScrollPane(righttext);
		add(righttext_scroll);
	}
	void highliteText() {
		left_notcomparedlines = compareline.constructLine(lefttext);
		right_notcomparedlines = compareline.constructLine(righttext);
		compareline.matchEqualLine(left_notcomparedlines, right_notcomparedlines);

		ArrayList<Line> left_lines = compareline.getComparedLeft();
		ArrayList<Line> right_lines = compareline.getComparedRight();

		lefttext = lefttext.AcceptLineColor(left_lines);
		righttext = righttext.AcceptLineColor(right_lines);

		left_linecolorlist = lefttext.getLineColorList();
		right_linecolorlist = righttext.getLineColorList();
	}

	void nextDiff() throws BadLocationException {
		if (linesetcolorindex < left_linecolorlist.size()) {
			lefttext.SelectLineSet(linesetcolorindex);
			righttext.SelectLineSet(linesetcolorindex);
			linesetcolorindex++;
		}
	}

	void prevDiff() throws BadLocationException {
		if (linesetcolorindex >= 0) {
			lefttext.SelectLineSet(linesetcolorindex);
			righttext.SelectLineSet(linesetcolorindex);
			linesetcolorindex--;
		}
	}
}
