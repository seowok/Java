package controller.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NewFileView;

public class NewFile implements ActionListener {

	
	NewFileView n;

	
	public NewFile(NewFileView n){
		this.n=n;
	}
	
	
	 @Override
	   public void actionPerformed(ActionEvent e) {
	      // TODO Auto-generated method stub
	      //���ʹ��� ������ ���� ��� �������� ����
	      if(n.radioButton1.isSelected() && n.radioButton3.isSelected() && e.getSource()==n.b2){
	      StoreFile save = new StoreFile();
	      save.LeftStoreFile(n.newtextviewer);
	      save.RightStoreFile(n.newtextviewer);
	      n.newtextviewer.getLefttext().setText("");
	      n.newtextviewer.getRighttext().setText("");
	      n.dispose();
	      }
	      //��� ���� ������ ��
	      else if(e.getSource()==n.b1){
	    	  n.newtextviewer.getLefttext().setText("");
	    	  n.newtextviewer.getRighttext().setText("");
	      n.dispose();
	   }
	      //���� ������ ������ ��
	      else if(n.radioButton1.isSelected() && n.radioButton4.isSelected() &&e.getSource()==n.b2){
	         StoreFile save = new StoreFile();
	         save.LeftStoreFile(n.newtextviewer);
	         n.newtextviewer.getLefttext().setText("");
	         n.newtextviewer.getRighttext().setText("");
	         n.dispose();
	      }
	      
	      else if(n.radioButton2.isSelected() && n.radioButton3.isSelected() &&e.getSource()==n.b2){
	         StoreFile save = new StoreFile();
	         save.RightStoreFile(n.newtextviewer);
	         n.newtextviewer.getLefttext().setText("");
	         n.newtextviewer.getRighttext().setText("");
	         n.dispose();
	      }
	      
	      else if (n.radioButton2.isSelected() && n.radioButton4.isSelected() &&e.getSource()==n.b2){
	    	  n.dispose();
	      }
	      
	      else if (e.getSource()==n.b3){
	        n. dispose();
	      }
	      
	   }
	
	
	
}
