package controller.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class LoadData implements LoadFile{

	BufferedReader text_buffers;
	FileReader file_reader;
	
	@Override
	public BufferedReader setFileReadStream(String file_path) {
		// TODO Auto-generated method stub
		
		try {
			file_reader = new FileReader(file_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		text_buffers = new BufferedReader(file_reader);
		
		return text_buffers;
	}

	@Override
	public boolean loadFile(BufferedReader text_buffers, JTextArea text_area) {
		// TODO Auto-generated method stub
		
		//clear text in text area
		text_area.setText("");
		//write down text data in text area
		try {
			String str = "";
			while((str=text_buffers.readLine()) != null){
				text_area.append(str);
			}
			text_buffers.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
