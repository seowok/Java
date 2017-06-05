package controller.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class LoadData implements LoadFile{

	BufferedReader text_buffers;
	FileReader file_reader;

	@Override
	public boolean loadFile(JTextPane text, File f) {
		// TODO Auto-generated method stub
		
		//clear text in text area
		text.setText("");
		//write down text data in text area
		try {
			String str = "";
		text.setPage(f.toURI().toURL());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
