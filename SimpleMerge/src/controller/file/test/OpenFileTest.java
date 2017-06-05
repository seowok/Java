package controller.file.test;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JTextPane;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import controller.file.LoadFile;
import controller.file.OpenFile;
import view.Text;

public class OpenFileTest {
	OpenFile open_file;
	LoadFile load_mock;

	@Before
	public void setUp(){
		
		open_file = new OpenFile();
		load_mock = EasyMock.createMock(LoadFile.class);
		
		open_file.SetLoadFile(load_mock);
	}
	
	@Test
	public void testLeftOpenFile() {
		
		Text test_text = new Text();
		test_text.setText("Test");
		
		EasyMock.expect(load_mock.loadFile(test_text, new File("Test")))
				.andReturn(true);
		
		EasyMock.replay(load_mock);
		
		boolean file_open_result = open_file.
	}

	@Test
	public void testRightOpenFile() {
		fail("Not yet implemented");
	}

}
