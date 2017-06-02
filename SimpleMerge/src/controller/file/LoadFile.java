package controller.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public interface LoadFile {
	
	
	
	//load text data from file
	//write text buffers to text area
	//return {TRUE : SUCCESS} {FALSE : ERROR}
	public boolean loadFile(JTextPane text, File f);
	
}
