package controller.compare;

import java.util.ArrayList;

import javax.swing.JTextPane;

public interface CmpLine {

	//transform contents data to structured ArrayList data
	//return ArrayList<Line>
	public ArrayList<Line> constructLine(JTextPane text_pane);
	
	/*each line in ArrayList is moved to match the position of lines
	 * and have tag option that used to highlight text color*/
	//please check the Editable option value
	//return two of ArrayList<Line> compared_contents
	public void matchEqualLine(ArrayList<Line> notCompared_left, ArrayList<Line> notCompared_right);
}
