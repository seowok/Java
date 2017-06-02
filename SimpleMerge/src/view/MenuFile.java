package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.SMConstants.EditMenuItems;
import view.SMConstants.FileMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFile extends JMenu{
	private FileMenuHandler filemenuhandler;
	public MenuFile(String label){
		super(label);
		filemenuhandler = new FileMenuHandler();
		for(FileMenuItems btn : FileMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(filemenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class FileMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(FileMenuItems.valueOf(e.getActionCommand())){
				case Menu1 :
					break;
				case Menu2 :
					break;
				case Menu3 :
					break;
				case Menu4 :
					break;
			}
			
		}
		
	}
}
