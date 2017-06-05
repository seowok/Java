package controller.file.test;

import org.junit.Before;
import org.junit.Test;

import controller.file.StoreFile;
import view.TextViewer;

public class StoreFileTest {
	
	StoreFile store_file;
	TextViewer text_viewer;
	
	@Before
	public void setUp(){
		store_file = new StoreFile();
		text_viewer = new TextViewer();
	}
	
	@Test
	public void testLeftStoreFile() {
		store_file.LeftStoreFile(text_viewer);
	}

	@Test
	public void testRightStoreFile() {
		store_file.RightStoreFile(text_viewer);
	}
}
