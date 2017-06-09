package controller.file;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.TextViewer;

public class OpenFile extends JFrame implements LoadFile{

	File Lfile = null;
	File Rfile = null;
	TextViewer t;
	
	FileReader fr;
	BufferedReader br = null;

	// 파일경로를 openfile에서 먼저 받아온 다음에 확인을 누르면 lefttext에 쓰는 함수
	
	
	public File getLfile(){
	  return Lfile;
	}
	public File getRfile(){
		return Rfile;
	}
	
	public void GetLeftFilePath() {

		JFileChooser jc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
		jc.setFileFilter(filter);

		if (jc.showOpenDialog(this) == jc.APPROVE_OPTION) {
			try {
				Lfile = jc.getSelectedFile();

			} catch (Exception e) {

			}

		}
		
		else {
			Lfile = null;
		}

	}
	
	public void GetRightFilePath() {

		JFileChooser jc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
		jc.setFileFilter(filter);

		if (jc.showOpenDialog(this) == jc.APPROVE_OPTION) {
			try {
				Rfile = jc.getSelectedFile();

			} catch (Exception e) {

			}
		}
		else {
			Rfile = null;
		}
	}
	@Override
	public boolean loadFile(JTextPane text, File f) {
		
		String line;
		// TODO Auto-generated method stub
		
		//clear text in text area
		text.setText("");
		//write down text data in text area
		try {
			String str = "";
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				str += line + "\n";
			}

			text.setText(str);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}