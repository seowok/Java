<<<<<<< HEAD
package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.SMConstants.EditMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEdit extends JMenu{
	private EditMenuHandler editmenuhandler;
	
	public MenuEdit(String label){
		super(label);
		editmenuhandler = new EditMenuHandler();
		for(EditMenuItems btn : EditMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(editmenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class EditMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(EditMenuItems.valueOf(e.getActionCommand())){
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
=======
package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.SMConstants.EditMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEdit extends JMenu{
	private EditMenuHandler editmenuhandler;
	
	public MenuEdit(String label){
		super(label);
		editmenuhandler = new EditMenuHandler();
		for(EditMenuItems btn : EditMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(editmenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class EditMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(EditMenuItems.valueOf(e.getActionCommand())){
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
>>>>>>> e45d3bbc1a3274c6fb6ade56f3e6a5e22427220a
