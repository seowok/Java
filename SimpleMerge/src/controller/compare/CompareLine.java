package controller.compare;

import java.util.ArrayList;

import javax.swing.JTextPane;

public class CompareLine implements CmpLine{

	@Override
	public ArrayList<Line> constructLine(JTextPane text_pane) {
		// TODO Auto-generated method stub
		
		ArrayList<Line> contents = new ArrayList<Line>();
		
		String[] contents_str = text_pane.getText().split("\n");
		for(String str : contents_str){
			NotComparedLine line = new NotComparedLine(str);
			contents.add(line);
		}
		
		return contents;
	}

	@Override
	public ArrayList<Line> matchEqualLine(ArrayList<Line> notCompared_left, ArrayList<Line> notCompared_right) {
		// TODO Auto-generated method stub
		
		int LCS_length = 0;
		int[][] table = new int[notCompared_left.size() + 1][notCompared_right.size() + 1];
		
		ArrayList<Line> compared_contents = new ArrayList<Line>();
		
		return null;
		
	}

}
