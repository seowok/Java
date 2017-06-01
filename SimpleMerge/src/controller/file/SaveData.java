package controller.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class SaveData implements SaveFile{

	BufferedWriter text_buffers;
	FileWriter file_writer;
	
	@Override
	public BufferedWriter setFileWriteStream(String file_path) {
		// TODO Auto-generated method stub
		
		try {
			file_writer = new FileWriter(file_path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		text_buffers = new BufferedWriter(file_writer);
		
		return text_buffers;
	}

	@Override
	public boolean saveFile(BufferedWriter text_buffers, JTextArea text_area) {
		// TODO Auto-generated method stub
		
		try {
			text_buffers.write(text_area.getText());
			text_buffers.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
