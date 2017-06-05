package controller.file;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.TextViewer;

public class OpenFile extends JFrame implements LoadFile{

   File f =null ;
   TextViewer b;
   
   @Override
   public void LeftOpenFile(TextViewer c) {

      JFileChooser jc = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
      jc.setFileFilter(filter);
      b = c;

      if (jc.showOpenDialog(this) == jc.APPROVE_OPTION) {
         try {
            f = jc.getSelectedFile();
            
               loadFile(b.getLefttext(), f);
         
         } catch (Exception e) {

         }
         b.setVisible(true);
      }
   }

   @Override
   public void RightOpenFile(TextViewer c) {

      JFileChooser jc = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
      jc.setFileFilter(filter);
      b = c;

      if (jc.showOpenDialog(this) == jc.APPROVE_OPTION) {
         try {
            f = jc.getSelectedFile();
           loadFile(b.getRighttext(), f);

         } catch (Exception e) {

         }
      }
   }

   @Override
	public boolean loadFile(JTextPane text, File f) {
		// TODO Auto-generated method stub
		
		//clear text in text area
		text.setText("");
		//write down text data in text area
		try {
		text.setPage(f.toURI().toURL());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}