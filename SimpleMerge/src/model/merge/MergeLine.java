package model.merge;

import java.util.ArrayList;

import model.compare.Line;

public interface MergeLine {

	//line which has index from start to end from Source contents to Destination contents
	public void moveLineTo(ArrayList<Line> dest_contents, ArrayList<Line> src_contents, int start_line, int end_line);
	
	//copy all lines from Source contents to Destination contents
	
}
