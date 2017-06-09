package controller.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import view.BringFileView;
import view.TextViewer;

public class BringFile implements ActionListener {
	File bringleft;
	File bringright;
	BringFileView b;
	LoadFile open = new OpenFile();
	
	public BringFile(BringFileView b){
		this.b = b;
	}
	
	public void setOpenFile(LoadFile load_file){
		open = load_file;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b.Confirm) {
		
  open.loadFile(b.text.getLefttext(), bringleft);
  open.loadFile(b.text.getRighttext(),bringright);
  b.dispose();
  



		} else if (e.getSource() == b.Cancel) {

			b.dispose();
		} else if (e.getSource() == b.Help) {
			

		} else if (e.getSource() == b.FindLeft) {

			open.GetLeftFilePath();
			bringleft= open.getLfile();
		
			//�ش���� �ʾ��� ��� null Exception�����ϱ� ���� OpenFile���� ó������ null��
			if (open.getLfile() != null)
				b.combo1.addItem(bringleft.getPath());
			
			//��� ������ �ش� �Ǿ��� �� Ȯ�� ��ư Ȱ��ȭ
			if(b.combo2.getItemCount()>0 && b.combo1.getItemCount()>0){
				b.Confirm.setEnabled(true);
			}
			
			
		} else if (e.getSource() == b.FindRight) {

			open.GetRightFilePath();
			bringright =open.getRfile();
			//�ش���� �ʾ��� ��� null Exception�����ϱ� ���� OpenFile���� ó������ null��
			if (open.getRfile() !=null)
				b.combo2.addItem(bringright.getPath());
			
			//��� ������ �ش� �Ǿ��� �� Ȯ�� ��ư Ȱ��ȭ
			if(b.combo2.getItemCount()>0 && b.combo1.getItemCount()>0){
				b.Confirm.setEnabled(true);
			}

		} else if (e.getSource() == b.SelectFil) {
			System.out.println("����1");

		} else if (e.getSource() == b.SelectUn)
			System.out.println("����2");
	}

}
