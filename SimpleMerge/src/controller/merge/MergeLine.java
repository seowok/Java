package controller.merge;

import controller.compare.Paragraph;

public interface MergeLine {

	//copy line from Destination PG to Source PG
	public void moveLineTo(Paragraph Des_compared_PG, Paragraph Src_compared_PG, int line_num);
}
