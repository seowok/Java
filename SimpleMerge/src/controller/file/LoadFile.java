package controller.file;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JTextArea;

public interface LoadFile {
	
	public BufferedReader setFileReadStream(String file_path);
	
	//load text data from file
	//write text buffers to text area
	//return {TRUE : SUCCESS} {FALSE : ERROR}
	public boolean loadFile(BufferedReader text_buffers, JTextArea text_area);
	
}
