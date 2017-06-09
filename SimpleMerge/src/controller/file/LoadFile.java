package controller.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public interface LoadFile {
	
	public File getLfile();

	public File getRfile();
	
	public void GetLeftFilePath();

	public void GetRightFilePath();
	
	//load text data from file
	//write text buffers to text area
	//return {TRUE : SUCCESS} {FALSE : ERROR}
	public boolean loadFile(JTextPane text, File f);
	
}
