package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

import model.compare.ComparedLine;
import model.compare.Line;

import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

public class Text extends JTextPane
{
	private ArrayList<LineColorOffset> linecolorlist;
	private Highlighter hilite;
	private Document doc;//getDocument()통해서 초기화
	private DefaultHighlightPainter yellowPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
	private DefaultHighlightPainter grayPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GRAY);
	private DefaultHighlightPainter redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
	private DefaultHighlightPainter whitePainter = new DefaultHighlighter.DefaultHighlightPainter(Color.WHITE);
	
	//File path needed
	public Text()
	{
		hilite = new MyHighlighter();
		setHighlighter(hilite); 
		//this.getDocument().addDocumentListener(this);
	}
	public Text acceptLineColor(ArrayList<Line> arraylist)
	{
		hilite.removeAllHighlights();
		linecolorlist = new ArrayList<LineColorOffset>();
		try 
		{
			doc = this.getDocument();
			int start = 0;
			int space = 0;
			int not_equal = 0;
			int equal = 0;
			ComparedLine comparedline;
			
			for(int i = 0; i < arraylist.size() ; i ++)
			{
				comparedline = (ComparedLine)arraylist.get(i);
				if(comparedline.tag.equals(ComparedLine.Tag.space))
				{
					if(space == 0 && not_equal == 0 && equal == 0){
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(0).setTag(ComparedLine.Tag.space);
						linecolorlist.get(0).setStartLine(i);
					}
					if(equal == 1){
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(linecolorlist.size() - 1).setTag(ComparedLine.Tag.space);
						linecolorlist.get(linecolorlist.size() - 1).setStartLine(i);
						equal = 0;
					}
					if(not_equal == 1){
						not_equal = 0;
						equal = 0;
					}
					hilite.addHighlight(start, start + 2, grayPainter);
					space = 1;
					start += 2;
				}
				else if(comparedline.tag.equals(ComparedLine.Tag.notequal))
				{					
					if(space == 0 && not_equal == 0 && equal == 0){
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(0).setTag(ComparedLine.Tag.notequal);
						linecolorlist.get(0).setStartLine(i);
					}
					if(equal == 1)
					{
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(linecolorlist.size() - 1).setTag(ComparedLine.Tag.notequal);
						linecolorlist.get(linecolorlist.size() - 1).setStartLine(i);
						equal = 0;
					}
					if(space == 1){
						equal = 0;
						space = 0;
					}
					
					hilite.addHighlight(start, start + comparedline.line.length() + 1, yellowPainter);
					not_equal = 1;
					start += comparedline.line.length() + 1;
				}
				else if(comparedline.tag.equals(ComparedLine.Tag.equal))
				{
					if(space == 1 || not_equal == 1)
					{
						linecolorlist.get(linecolorlist.size() - 1).setColorEnd(start);
						linecolorlist.get(linecolorlist.size() - 1).setEndLine(i - 1);
						space = 0;
						not_equal = 0;
					}
					equal = 1;
					start += comparedline.line.length() + 1;
				}
				if((space == 1 || not_equal == 1) && i == arraylist.size() - 1 && linecolorlist.size() != 0)
				{
					linecolorlist.get(linecolorlist.size() - 1).setColorEnd(start);
					linecolorlist.get(linecolorlist.size() - 1).setEndLine(i);
				}
			}
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
		return this;
	}
	//툴바 버튼을 통해서 선택된 라인의 집합을 Red로 색상 전환	
	public void selectLineSet(int index) throws BadLocationException
	{
		hilite.removeAllHighlights();
		for(int i = 0; i < linecolorlist.size(); i++)
		{
			if(i != index){
				if(linecolorlist.get(i).getTag().equals(ComparedLine.Tag.notequal))
					hilite.addHighlight(linecolorlist.get(i).getColorStart() ,linecolorlist.get(i).getColorEnd(), yellowPainter);
				else if(linecolorlist.get(i).getTag().equals(ComparedLine.Tag.space))
					hilite.addHighlight(linecolorlist.get(i).getColorStart() ,linecolorlist.get(i).getColorEnd(), grayPainter);
				else if(linecolorlist.get(i).getTag().equals(ComparedLine.Tag.equal))
					hilite.addHighlight(linecolorlist.get(i).getColorStart() ,linecolorlist.get(i).getColorEnd(), whitePainter);
			}
		}
		if(linecolorlist.size() > 0)
		hilite.addHighlight(linecolorlist.get(index).getColorStart(), linecolorlist.get(index).getColorEnd(), redPainter);
		//System.out.println(linecolorlist.get(index).getColorStart() + "@" + linecolorlist.get(index).getColorEnd());
	}
	public ArrayList<LineColorOffset> getLineColorList()
	{
		return linecolorlist;
	}
	public void setLineColorOffsetArray(ArrayList<LineColorOffset> linecolorlist)
	{
		this.linecolorlist = linecolorlist;
	}
}
