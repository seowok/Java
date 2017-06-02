package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
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
	
	//File path needed
	public Text()
	{
		hilite = new MyHighlighter();
		setHighlighter(hilite); 
		//Test
		//
	}
	
	public Text acceptLineColor(ArrayList<Line> arraylist)
	{
		hilite.removeAllHighlights();
		linecolorlist = new ArrayList<LineColorOffset>();
		try 
		{
			doc = this.getDocument();
			int start = 0;
			int gray_color = 0;
			int yellow_color = 0;
			int linecoloroffset_index = 0;
			
			ComparedLine comparedline;
			for(int i = 0; i < arraylist.size() ; i ++)
			{
				comparedline = (ComparedLine)arraylist.get(i);
				if(comparedline.tag.equals(ComparedLine.Tag.space))
				{
					hilite.addHighlight(start, start + comparedline.line.length(), grayPainter);
					if(gray_color == 0 && yellow_color == 0)
						linecolorlist.add(new LineColorOffset(start));
					if(yellow_color == 1){
						linecolorlist.get(linecoloroffset_index).setColorEnd(start + comparedline.line.length());
						linecolorlist.add(new LineColorOffset(start));
						linecoloroffset_index = i;
						yellow_color = 0;
					}
					if(gray_color == 1)
					{
						linecolorlist.get(linecoloroffset_index).addSameColorline();
					}
					gray_color = 1;
				}
				else if(comparedline.tag.equals(ComparedLine.Tag.notequal))
				{
					hilite.addHighlight(start, start + comparedline.line.length(), yellowPainter);
					if(gray_color == 0 && yellow_color == 0)
						linecolorlist.add(new LineColorOffset(start));
					if(gray_color == 1){
						linecolorlist.get(linecoloroffset_index).setColorEnd(start + comparedline.line.length());
						linecolorlist.add(new LineColorOffset(start));
						linecoloroffset_index = i;
						gray_color = 0;
					}
					if(yellow_color == 1)
					{
						linecolorlist.get(linecoloroffset_index).addSameColorline();
					}
					yellow_color = 1;
				}
				if(i == arraylist.size() - 1 &&(gray_color == 1 || yellow_color == 1))
				{
					linecolorlist.get(linecoloroffset_index).setColorEnd(start + comparedline.line.length());
				}
				start += comparedline.line.length() + 1;
			}
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
		/*try {
			hilite.addHighlight(0, 11, yellowPainter);
			linecolorlist.add(new LineColorOffset(0 ,0));
			linecolorlist.get(0).setColorEnd(11);
			linecolorlist.get(0).setEndLine(1);
			hilite.addHighlight(12, 14, yellowPainter);
			linecolorlist.add(new LineColorOffset(12, 2));
			linecolorlist.get(1).setColorEnd(14);
			linecolorlist.get(1).setEndLine(2);
			
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return this;
	}
	//툴바 버튼을 통해서 선택된 라인의 집합을 Red로 색상 전환	
	public void selectLineSet(int index) throws BadLocationException
	{
		hilite.removeAllHighlights();
		for(int i = 0; i < linecolorlist.size(); i++)
		{
			if(i != index){
				hilite.addHighlight(linecolorlist.get(i).getColorStart() ,linecolorlist.get(i).getColorEnd(), yellowPainter);
			}
		}
		hilite.addHighlight(linecolorlist.get(index).getColorStart() ,linecolorlist.get(index).getColorEnd(), redPainter);
	}
	public ArrayList<LineColorOffset> getLineColorList()
	{
		return linecolorlist;
	}
}
//색칠된 구간의 위치를 저장
class LineColorOffset
{
	private int color_start;
	private int color_end;
	private int start_line;
	private int end_line;
	private int sameline = 0;
	
	public LineColorOffset(int color_start)
	{
		this.color_start = color_start;
		this.start_line = start_line;
		this.end_line = start_line;
	}
	public int getStartLine(){ return start_line; }
	public int getEndLine(){ return end_line; }
	public void setEndLine(int end_line)
	{
		this.end_line = end_line;
	}
	public void setColorEnd(int color_end)
	{
		this.color_end = color_end;
	}
	public int getColorStart()
	{
		return color_start;
	}
	public int getColorEnd() 
	{
		return color_end;
	}
	public void addSameColorline()
	{
		sameline += 1;
		end_line += 1;
	}
}
