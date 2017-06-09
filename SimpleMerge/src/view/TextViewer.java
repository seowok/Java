package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

import controller.textviewer.TextViewerMergeController;
import controller.textviewer.TextViewerSearchController;
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
	private TextViewerSearchController tvscontroller;
	private TextViewerMergeController tvmcontroller;
	private MyDocumentListener mydocumentlistener;

	private ArrayList<LineColorOffset> left_linecolorlist;
	private ArrayList<LineColorOffset> right_linecolorlist;
	int linesetcolorindex = -1;
	int shift_flag = 0;
	
	private String left_contents = "";
	private String right_contents = "";

	public TextViewer() 
	{
		super();
		mrgline = new MergeLine();
		
		setLayout(new GridLayout(1, 2, 10, 10));
		lefttext = new Text();
		lefttext.setText("Apple\nOnion\nsad\n\n\nzxcv\nasdas\nA\nzxc\n"
				+ "asdas\nA\nzxc\nasdsad\nzxczxc\nasdas\nz\na\nb\nzxc\n");
		lefttext_scroll = new JScrollPane(lefttext);
		add(lefttext_scroll);

		righttext = new Text();
		righttext.setText("Apple\nOnion\nA\nB\nC\nD\nz\n"
				+ "xc\nc\nz\na\nb\nxcvxcv\nsdfsdf\nzxxzz\n"
				+ "zx\na\n");
		righttext_scroll = new JScrollPane(righttext);
		add(righttext_scroll);
		
		mydocumentlistener = new MyDocumentListener(lefttext, righttext);
		lefttext.getDocument().addDocumentListener(mydocumentlistener);
		righttext.getDocument().addDocumentListener(mydocumentlistener);
		
		tvscontroller = new TextViewerSearchController(lefttext, righttext, this);
		tvmcontroller = new TextViewerMergeController(lefttext, righttext, this);
	}
	void highliteText() 
	{
		int left_base_count = 0;
		int right_base_count = 0;
		
		linesetcolorindex = -1;
		String contents;
		contents = "";

		compareline = new CompareLine();
		CompareLine left_compareline = new CompareLine();
		CompareLine right_compareline = new CompareLine();
		
		left_notcomparedlines = compareline.constructLine(lefttext);
		right_notcomparedlines = compareline.constructLine(righttext);
		
		left_base_count = left_compareline.matchEqualLine(left_notcomparedlines, right_notcomparedlines);
		right_base_count = right_compareline.matchEqualLine(right_notcomparedlines, left_notcomparedlines);
		
		if(left_base_count >= right_base_count) compareline = left_compareline;
		else compareline = right_compareline;
		
		compared_left_lines = compareline.getComparedLeft();
		compared_right_lines = compareline.getComparedRight();

		for(int i = 0; i < compared_left_lines.size(); i++)
		{
			contents += compared_left_lines.get(i).line + "\n";
		}
		lefttext.setText(contents);
		left_contents = new String(contents);
		contents = "";
		for(int i = 0; i < compared_right_lines.size(); i++)
		{
			contents += compared_right_lines.get(i).line + "\n";
		}
		righttext.setText(contents);
		right_contents = new String(contents);
		
		
		lefttext = lefttext.acceptLineColor(compared_left_lines);
		righttext = righttext.acceptLineColor(compared_right_lines);
		
		left_linecolorlist = lefttext.getLineColorList();
		right_linecolorlist = righttext.getLineColorList();
	}

	void nextDiff() throws BadLocationException 
	{
		if(shift_flag == 0)
			linesetcolorindex++;
		tvscontroller.nextDiff(linesetcolorindex, left_linecolorlist.size(), left_contents, right_contents);
		shift_flag = 0;
	}

	void prevDiff() throws BadLocationException
	{
		linesetcolorindex--;
		tvscontroller.prevDiff(linesetcolorindex, left_linecolorlist.size(), left_contents, right_contents);
		shift_flag = 0;
	}
	
	void firstDiff() throws BadLocationException 
	{
		tvscontroller.firstDiff(left_contents, right_contents);
		/*lefttext.setText(left_contents);
		righttext.setText(right_contents);
		lefttext.selectLineSet(0);
		righttext.selectLineSet(0);*/
	}
	
	void lastDiff() throws BadLocationException 
	{
		tvscontroller.lastDiff(left_linecolorlist.size(), left_contents, right_contents);
	}
	void shiftRight() throws BadLocationException
	{
		if(linesetcolorindex < left_linecolorlist.size() && linesetcolorindex >= 0){
		tvmcontroller.shiftRight(linesetcolorindex, left_contents, left_linecolorlist, right_linecolorlist, compared_left_lines, compared_right_lines);
		shift_flag = 1;
		}
	}
	void shiftLeft() throws BadLocationException
	{
		if(linesetcolorindex < left_linecolorlist.size() && linesetcolorindex >= 0){
		tvmcontroller.shiftLeft(linesetcolorindex, left_contents, left_linecolorlist, right_linecolorlist, compared_left_lines, compared_right_lines);
		shift_flag = 1;
		}
	}
	void shiftAllRight() throws BadLocationException
	{
		tvmcontroller.shiftAllRight(left_contents);
		lefttext.setText(left_contents);
		righttext.setText(left_contents);
	}
	void shiftAllLeht() throws BadLocationException
	{
		tvmcontroller.shiftAllLeft(right_contents);
		lefttext.setText(right_contents);
		righttext.setText(right_contents);
	}
	public void setlinesetcolorindex(int linesetcolorindex){
		this.linesetcolorindex = linesetcolorindex;
	}
	public void setLeftContent(String left_contents)
	{
		this.left_contents = left_contents;
	}
	public void setRightContent(String right_contents)
	{
		this.right_contents = right_contents;
	}
	public Text getLefttext(){ return lefttext; }
	public Text getRighttext(){ return righttext; }
}
class MyDocumentListener implements DocumentListener{
	private Text lefttext;
	private Text righttext;
	public MyDocumentListener(Text lefttext, Text righttext)
	{
		this.lefttext = lefttext;
		this.righttext = righttext;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
	}
	
}