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
			int space = 0;
			int not_equal = 0;
			int equal = 0;
			int linecoloroffset_index = 0;
			
			ComparedLine comparedline;
			for(int i = 0; i < arraylist.size() ; i ++)
			{
				comparedline = (ComparedLine)arraylist.get(i);
				System.out.println("<" + comparedline.tag + ">" + comparedline.line);
				if(comparedline.tag.equals(ComparedLine.Tag.space))
				{
					//System.out.println(comparedline.line.length());
					//System.out.println("GRAY-CONTENTS : " + comparedline.line);
					if(space == 0 && not_equal == 0 && equal == 0){
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(0).setStartLine(i);
					}
					if(equal == 1){
						linecoloroffset_index++;
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(linecoloroffset_index).setStartLine(i);
						equal = 0;
					}
					if(not_equal == 1){
						linecolorlist.get(linecoloroffset_index).setColorEnd(start);
						linecolorlist.get(linecoloroffset_index).setEndLine(i - 1);
		
						linecoloroffset_index++;
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(linecoloroffset_index).setStartLine(i);
						not_equal = 0;
						equal = 0;
					}
					hilite.addHighlight(start, start + 1, grayPainter);
					space = 1;
					start += 1;
				}
				else if(comparedline.tag.equals(ComparedLine.Tag.notequal))
				{
					//System.out.println("YELLOW" + start + "~" + (start + comparedline.line.length()));
					
					if(space == 0 && not_equal == 0 && equal == 0){
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(0).setStartLine(i);
					}
					if(equal == 1)
					{
						linecoloroffset_index++;
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(linecoloroffset_index).setStartLine(i);
						equal = 0;
					}
					if(space == 1){
						linecolorlist.get(linecoloroffset_index).setColorEnd(start);
						linecolorlist.get(linecoloroffset_index).setEndLine(i - 1);
		
						linecoloroffset_index++;
						linecolorlist.add(new LineColorOffset(start));
						linecolorlist.get(linecoloroffset_index).setStartLine(i);
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
						linecolorlist.get(linecoloroffset_index).setColorEnd(start);
						linecolorlist.get(linecoloroffset_index).setEndLine(i - 1);
						space = 0;
						not_equal = 0;
					}
					equal = 1;
					start += comparedline.line.length() + 1;
				}
				if(i == arraylist.size() - 1)
				{
					System.out.println("체크");
					linecolorlist.get(linecoloroffset_index).setColorEnd(start);
					linecolorlist.get(linecoloroffset_index).setEndLine(i);
				}
			}
			System.out.println("LineColorList LENGTH : " + linecolorlist.size());
			System.out.println("END : " + linecolorlist.get(1).getColorEnd());
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < linecolorlist.size(); i ++)
		{
			//System.out.println("(" + i + ")" + " : " + linecolorlist.get(i).getStartLine() + "," + linecolorlist.get(i).getEndLine());
			System.out.println("(" + i + ")" + " : " + linecolorlist.get(i).getColorStart() + "," + linecolorlist.get(i).getColorEnd());
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
		//System.out.println(linecolorlist.get(index).getColorStart() + "@" + linecolorlist.get(index).getColorEnd());
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
	private int color_end = 0;
	private int start_line;
	private int end_line;
	
	public LineColorOffset(int color_start)
	{
		this.color_start = color_start;
		this.start_line = start_line;
	}
	public int getStartLine(){ return start_line; }
	public int getEndLine(){ return end_line; }
	public void setStartLine(int start_line)
	{
		this.start_line = start_line;
	}
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
}
