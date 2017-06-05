package controller.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.TextViewer;

public interface SaveFile {
   
	public void LeftStoreFile(TextViewer t);

	public void RightStoreFile(TextViewer t);
   
   //read text data from JtextArea
   //save text buffers to file in file path
   //return {TRUE : SUCCESS} {FALSE : ERROR}
   public boolean saveFile(JTextPane text , File f, FileWriter fw);
   
}