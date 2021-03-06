package controller.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.TextViewer;

public class StoreFile extends JFrame implements SaveFile{
	File f;

	public StoreFile() {
	}

	@Override
	public void LeftStoreFile(TextViewer t) { // 왼쪽 문서 저장하기
		JFileChooser jc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
		jc.setFileFilter(filter);

		int left = jc.showDialog(this, "왼쪽 파일을 저장합니다.");
		if (left == jc.APPROVE_OPTION) {

			try {
				File f = jc.getSelectedFile();
				FileWriter fw = new FileWriter(f);

				saveFile(t.getLefttext(), f, fw);

				JOptionPane.showMessageDialog(this, "왼쪽 문서가 저장 되었습니다.", "저장완료", JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e) {
			}
		}

	}

	@Override
	public void RightStoreFile(TextViewer t) {
		JFileChooser jc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
		jc.setFileFilter(filter);
		int right = jc.showDialog(this, "오른쪽 파일을 저장합니다.");
		if (right == jc.APPROVE_OPTION) {
			try {
				File f = jc.getSelectedFile();
				FileWriter fw = new FileWriter(f);

				saveFile(t.getRighttext(), f, fw);

				JOptionPane.showMessageDialog(this, "오른쪽 문서가 저장 되었습니다.", "저장완료", JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e) {
			}
		}
	}

	@Override
	public boolean saveFile(JTextPane text, File f , FileWriter fw) {
	      // TODO Auto-generated method stub

	      try {
	         String[] str_s = text.getText().trim().split("\n", -1);
	         
	         for(String str : str_s){
	        	 fw.write(str + "\r\n");
	         }

	      fw.close();
	         
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	         return false;
	      }
	      
	      return true;
	   }

}