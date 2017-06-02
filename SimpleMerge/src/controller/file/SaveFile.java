package controller.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public interface SaveFile {
   

   
   
   //read text data from JtextArea
   //save text buffers to file in file path
   //return {TRUE : SUCCESS} {FALSE : ERROR}
   public boolean saveFile(JTextPane text , File f, FileWriter fw);
   
}