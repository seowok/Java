package controller.textviewer;

import javax.swing.text.BadLocationException;

import view.Text;
import view.TextViewer;

public class TextViewerSearchController {
   private Text lefttext;
   private Text righttext;
   private TextViewer textviewer;
   
   public TextViewerSearchController(Text lefttext, Text righttext, TextViewer tv)
   {
      this.lefttext = lefttext;
      this.righttext = righttext;
      this.textviewer = tv;
   }
   public void nextDiff(int linesetcolorindex, int size, String left_contents, String right_contents) throws BadLocationException,
   ArrayIndexOutOfBoundsException
   {
      lefttext.setText(left_contents);
      righttext.setText(right_contents);
      if (linesetcolorindex < size && linesetcolorindex >= 0) 
      {
         lefttext.selectLineSet(linesetcolorindex);
         righttext.selectLineSet(linesetcolorindex);
      }
      else{
         linesetcolorindex = 0;
         textviewer.setlinesetcolorindex(0);
         lefttext.selectLineSet(linesetcolorindex);
         righttext.selectLineSet(linesetcolorindex);
      }
   }
   public void prevDiff(int linesetcolorindex, int size, String left_contents, String right_contents) throws BadLocationException,
   ArrayIndexOutOfBoundsException
   {
      lefttext.setText(left_contents);
      righttext.setText(right_contents);
      if (linesetcolorindex > 0 && linesetcolorindex < size) {
         lefttext.selectLineSet(linesetcolorindex);
         righttext.selectLineSet(linesetcolorindex);
      }
      else if(linesetcolorindex == 0){
         lefttext.selectLineSet(0);
         righttext.selectLineSet(0);
      }
      else if(linesetcolorindex < 0){
         linesetcolorindex = size - 1;
         textviewer.setlinesetcolorindex(size - 1);
         lefttext.selectLineSet(linesetcolorindex);
         righttext.selectLineSet(linesetcolorindex);
      }
   }
   public void firstDiff(String left_contents, String right_contents) throws BadLocationException
   {
      lefttext.setText(left_contents);
      righttext.setText(right_contents);
      textviewer.setlinesetcolorindex(0);
      lefttext.selectLineSet(0);
      righttext.selectLineSet(0);
   }
   public void lastDiff(int size, String left_contents, String right_contents) throws BadLocationException 
   {
      lefttext.setText(left_contents);
      righttext.setText(right_contents);
      textviewer.setlinesetcolorindex(size - 1);
      lefttext.selectLineSet(size - 1);
      righttext.selectLineSet(size - 1);
   }
}