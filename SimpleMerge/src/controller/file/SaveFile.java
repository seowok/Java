package controller.file;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JTextArea;

public interface SaveFile {
	
	//return BufferedWriter to save text data in file_path
	public BufferedWriter setFileWriteStream(String file_path, FileWriter file_writer);
	
	//read text data from JtextArea
	//save text buffers to file in file path
	//return {TRUE : SUCCESS} {FALSE : ERROR}
	public boolean saveFile(BufferedWriter text_buffers, JTextArea text_area);
	
}