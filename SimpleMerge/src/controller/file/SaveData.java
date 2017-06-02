package controller.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextPane;

public class SaveData implements SaveFile{

   BufferedWriter text_buffers;
   FileWriter file_writer;
   

   public boolean saveFile(JTextPane text, File f , FileWriter fw) {
      // TODO Auto-generated method stub
      
      try {
         
         String str = text.getText().trim();
         if(str.length()<1)
            return false;
      fw.write(str);
      fw.close();
         
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return false;
      }
      
      return true;
   }

}