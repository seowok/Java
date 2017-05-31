package controller.compare;

import java.util.ArrayList;

public class Paragraph {

	int paragraph_num;
	int starting_line_num;
	int ending_line_num;
	
	boolean editable;
	
	//<?> is String Class if this is not compared Paragraph class
	//<?> is Line Class if this is compared Paragraph class
	ArrayList<?> line;
}
