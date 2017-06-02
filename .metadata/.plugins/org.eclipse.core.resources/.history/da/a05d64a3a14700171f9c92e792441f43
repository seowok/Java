package view;

import java.io.File;

import javax.swing.*;

import controller.file.LoadData;
import controller.file.LoadFile;

public class Openfile extends JFrame{

	File f;
	TextViewer b;
	
	public Openfile(TextViewer c){
		
	JFileChooser jc = new JFileChooser();
	TextViewer b = c;

	if(jc.showOpenDialog(this)==jc.APPROVE_OPTION)
	{
		try{
			f=jc.getSelectedFile();
			LoadData aaa = new LoadData();
			aaa.loadFile(b.lefttext, f);
			
		}catch(Exception e){
			
		}
	}
	}
}
