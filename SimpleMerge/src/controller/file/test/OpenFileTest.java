package controller.file.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.file.OpenFile;

public class OpenFileTest {
	
	OpenFile open_file;

	@Before
	public void setUp(){
		open_file = new OpenFile();
	}
	
	@Test
	public void testGetLfile() {
		open_file.GetLeftFilePath();
		assertNotNull(open_file.getLfile());
	}

	@Test
	public void testGetRfile() {
		open_file.GetRightFilePath();
		assertNotNull(open_file.getRfile());
	}

}
