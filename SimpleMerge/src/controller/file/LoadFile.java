package controller.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.TextViewer;

public interface LoadFile {
	
	public void LeftOpenFile(TextViewer c);
	   
	public void RightOpenFile(TextViewer c);
	//load text data from file
	//write text buffers to text area
	//return {TRUE : SUCCESS} {FALSE : ERROR}
	public boolean loadFile(JTextPane text, File f);
	
}
