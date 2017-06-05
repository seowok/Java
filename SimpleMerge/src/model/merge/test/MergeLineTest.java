package model.merge.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.compare.Line;
import model.compare.NotComparedLine;
import model.merge.MergeLine;

public class MergeLineTest {
	
	MergeLine merge_line;
	ArrayList<Line> left_list;
	ArrayList<Line> right_list;

	@Before
	public void setUp(){
		
		left_list = new ArrayList<Line>();
		
		left_list.add(new NotComparedLine("A"));
		left_list.add(new NotComparedLine("C"));
		left_list.add(new NotComparedLine("A"));
		left_list.add(new NotComparedLine("Y"));
		left_list.add(new NotComparedLine("K"));
		left_list.add(new NotComparedLine("P"));
		
		right_list = new ArrayList<Line>();
		
		right_list.add(new NotComparedLine("C"));
		right_list.add(new NotComparedLine("A"));
		right_list.add(new NotComparedLine("P"));
		right_list.add(new NotComparedLine("C"));
		right_list.add(new NotComparedLine("A"));
		right_list.add(new NotComparedLine("K"));
		
		assertNotEquals(left_list, right_list);
	}
	
	@Test
	public void testMoveLineTo() {
		
		merge_line = new MergeLine();
		
		assertEquals(left_list.size(), right_list.size());
		
		merge_line.moveLineTo(right_list, left_list, 0, left_list.size() - 1);
		
		for(int i = 0; i < left_list.size(); i ++){
			assertEquals(left_list.get(i).line, right_list.get(i).line);
		}
	}

}
