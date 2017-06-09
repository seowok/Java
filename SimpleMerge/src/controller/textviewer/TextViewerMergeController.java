package controller.textviewer;

import java.util.ArrayList;

import javax.swing.text.BadLocationException;

import model.compare.ComparedLine;
import model.compare.Line;
import model.merge.MergeLine;
import view.LineColorOffset;
import view.Text;
import view.TextViewer;

public class TextViewerMergeController {
	private Text lefttext;
	private Text righttext;

	private TextViewer textviewer;
	private MergeLine mrgline;

	public TextViewerMergeController(Text lefttext, Text righttext, TextViewer tv) {
		mrgline = new MergeLine();
		this.lefttext = lefttext;
		this.righttext = righttext;
		this.textviewer = tv;
	}

	public void shiftRight(int linesetcolorindex, String right_contents, ArrayList<LineColorOffset> left_linecolorlist,
			ArrayList<LineColorOffset> right_linecolorlist, ArrayList<Line> compared_left_lines,
			ArrayList<Line> compared_right_lines) throws BadLocationException, IndexOutOfBoundsException {
		String contents = "";
		int sign = 1;
		int diff = 0;
		int length_diff = 0;

		int shift_start_line = left_linecolorlist.get(linesetcolorindex).getStartLine();
		int shift_end_line = left_linecolorlist.get(linesetcolorindex).getEndLine();
		int right_color_start = right_linecolorlist.get(linesetcolorindex).getColorStart();
		int right_color_end = right_linecolorlist.get(linesetcolorindex).getColorEnd();
		int left_color_start = left_linecolorlist.get(linesetcolorindex).getColorStart();
		int left_color_end = left_linecolorlist.get(linesetcolorindex).getColorEnd();

		mrgline.moveLineTo(compared_right_lines, compared_left_lines, shift_start_line, shift_end_line);
		for (int i = 0; i < compared_right_lines.size(); i++) {
			contents += compared_right_lines.get(i).line + "\n";
		}
		// Update Right LineColor list
		diff = (right_color_end - right_color_start) - (left_color_end - left_color_start);
		if (diff < 0)
			diff *= -1;
		else
			diff *= -1;
		length_diff = left_color_end - left_color_start;
		right_linecolorlist.get(linesetcolorindex).setColorStart(right_color_start);
		right_linecolorlist.get(linesetcolorindex).setColorEnd(right_color_start + sign * (length_diff));

		right_linecolorlist.get(linesetcolorindex).setTag(ComparedLine.Tag.equal);
		left_linecolorlist.get(linesetcolorindex).setTag(ComparedLine.Tag.equal);

		for (int i = linesetcolorindex + 1; i < right_linecolorlist.size(); i++) {
			right_linecolorlist.get(i).setColorStart(right_linecolorlist.get(i).getColorStart() + (diff));
			right_linecolorlist.get(i).setColorEnd(right_linecolorlist.get(i).getColorEnd() + (diff));
		}
		righttext.setLineColorOffsetArray(right_linecolorlist);
		lefttext.setLineColorOffsetArray(left_linecolorlist);

		righttext.setText(contents);
		right_contents = new String(contents);
		textviewer.setRightContent(new String(contents));

		righttext.selectLineSet(linesetcolorindex);
		lefttext.selectLineSet(linesetcolorindex);
		// Remove Operation
		right_linecolorlist.remove(linesetcolorindex);
		left_linecolorlist.remove(linesetcolorindex);
		righttext.setLineColorOffsetArray(right_linecolorlist);
		lefttext.setLineColorOffsetArray(left_linecolorlist);
	}

	public void shiftLeft(int linesetcolorindex, String left_contents, ArrayList<LineColorOffset> left_linecolorlist,
			ArrayList<LineColorOffset> right_linecolorlist, ArrayList<Line> compared_left_lines,
			ArrayList<Line> compared_right_lines) throws BadLocationException, IndexOutOfBoundsException {
		String contents = "";
		int sign = 1;
		int diff = 0;
		int length_diff = 0;

		int shift_start_line = right_linecolorlist.get(linesetcolorindex).getStartLine();
		int shift_end_line = right_linecolorlist.get(linesetcolorindex).getEndLine();
		int right_color_start = right_linecolorlist.get(linesetcolorindex).getColorStart();
		int right_color_end = right_linecolorlist.get(linesetcolorindex).getColorEnd();
		int left_color_start = left_linecolorlist.get(linesetcolorindex).getColorStart();
		int left_color_end = left_linecolorlist.get(linesetcolorindex).getColorEnd();

		mrgline.moveLineTo(compared_left_lines, compared_right_lines, shift_start_line, shift_end_line);
		for (int i = 0; i < compared_left_lines.size(); i++) {
			contents += compared_left_lines.get(i).line + "\n";
		}
		// Update Left LineColor list
		diff = (left_color_end - left_color_start) - (right_color_end - right_color_start);
		if (diff < 0)
			diff *= -1;
		else
			diff *= -1;
		length_diff = right_color_end - right_color_start;
		left_linecolorlist.get(linesetcolorindex).setColorStart(left_color_start);
		left_linecolorlist.get(linesetcolorindex).setColorEnd(left_color_start + sign * (length_diff));

		right_linecolorlist.get(linesetcolorindex).setTag(ComparedLine.Tag.equal);
		left_linecolorlist.get(linesetcolorindex).setTag(ComparedLine.Tag.equal);

		for (int i = linesetcolorindex + 1; i < left_linecolorlist.size(); i++) {
			left_linecolorlist.get(i).setColorStart(left_linecolorlist.get(i).getColorStart() + (diff));
			left_linecolorlist.get(i).setColorEnd(left_linecolorlist.get(i).getColorEnd() + (diff));
		}
		righttext.setLineColorOffsetArray(right_linecolorlist);
		lefttext.setLineColorOffsetArray(left_linecolorlist);

		lefttext.setText(contents);
		left_contents = new String(contents);
		textviewer.setLeftContent(new String(contents));

		righttext.selectLineSet(linesetcolorindex);
		lefttext.selectLineSet(linesetcolorindex);

		// Remove Operation
		right_linecolorlist.remove(linesetcolorindex);
		left_linecolorlist.remove(linesetcolorindex);
		righttext.setLineColorOffsetArray(right_linecolorlist);
		lefttext.setLineColorOffsetArray(left_linecolorlist);
	}
	
	public void shiftAllRight(String left_contents)
	{
		textviewer.getRighttext().setText(left_contents);
	}	
	public void shiftAllLeft(String left_contents)
	{
		textviewer.getRighttext().setText(left_contents);
	}
}
