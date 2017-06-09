package controller.file.test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.io.File;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import controller.file.BringFile;
import controller.file.LoadFile;
import view.BringFileView;
import view.TextViewer;

public class BringFileTest {
	
	TextViewer tv;
	BringFileView bring_view;
	BringFile bring_file;
	LoadFile mock_file;
	
	@Before
	public void setUp(){
		
		tv = new TextViewer();
		
		bring_view = new BringFileView(tv);
		
		bring_file = new BringFile(bring_view);
		
		mock_file = EasyMock.createMock(LoadFile.class);
	}
	@Test
	public void testFindLeftActionPerformed() {
		
		File not_null_file = new File("notnull_left");
		
		EasyMock.expect(mock_file.getLfile()).andReturn(not_null_file);
		
		EasyMock.replay(mock_file);
		
		ActionEvent e = new ActionEvent(bring_view.FindLeft, 0, "Test Left event");
		
		bring_file.setOpenFile(mock_file);
		
		bring_file.actionPerformed(e);
	}
	
	@Test
	public void testFindRightActionPerformed() {
		
		File not_null_file = new File("notnull_right");
		
		EasyMock.expect(mock_file.getRfile()).andReturn(not_null_file);
		
		EasyMock.replay(mock_file);
		
		ActionEvent e = new ActionEvent(bring_view.FindRight, 0, "Test Right event");
		
		bring_file.setOpenFile(mock_file);
		
		bring_file.actionPerformed(e);
	}

}
