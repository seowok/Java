package controller.file;

import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.file.LoadData;
import view.TextViewer;

public class OpenFile extends JFrame {

	File Lfile = null;
	File Rfile = null;
	TextViewer t;

	// ���ϰ�θ� openfile���� ���� �޾ƿ� ������ Ȯ���� ������ lefttext�� ���� �Լ�
	
	
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
}