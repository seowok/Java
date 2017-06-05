package controller.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.file.SaveData;
import view.TextViewer;

public class StoreFile extends JFrame {
	File f;

	public StoreFile() {
	}

	public void LeftStoreFile(TextViewer t) { // ���� ���� �����ϱ�
		JFileChooser jc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
		jc.setFileFilter(filter);

		if (jc.showSaveDialog(this) == jc.APPROVE_OPTION) {

			try {
				File f = jc.getSelectedFile();
				FileWriter fw = new FileWriter(f);

				SaveData s = new SaveData();
				s.saveFile(t.getLefttext(), f, fw);

				JOptionPane.showMessageDialog(this, "���� ������ ���� �Ǿ����ϴ�.", "����Ϸ�", JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e) {
			}
		}

	}

	public void RightStoreFile(TextViewer t) {
		JFileChooser jc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*,txt", "txt");
		jc.setFileFilter(filter);

		if (jc.showSaveDialog(this) == jc.APPROVE_OPTION) {
			try {
				File f = jc.getSelectedFile();
				FileWriter fw = new FileWriter(f);

				SaveData s = new SaveData();
				s.saveFile(t.getRighttext(), f, fw);

				JOptionPane.showMessageDialog(this, "������ ������ ���� �Ǿ����ϴ�.", "����Ϸ�", JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e) {
			}
		}
	}
}