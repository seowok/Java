<<<<<<< HEAD
package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.SMConstants.FileMenuItems;
import view.SMConstants.HelpMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHelp extends JMenu{
	private HelpMenuHandler helpmenuhandler;
	
	public MenuHelp(String label){
		super(label);
		helpmenuhandler = new HelpMenuHandler();
		for(HelpMenuItems btn : HelpMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(helpmenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class HelpMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(HelpMenuItems.valueOf(e.getActionCommand())){
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

import view.SMConstants.FileMenuItems;
import view.SMConstants.HelpMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHelp extends JMenu{
	private HelpMenuHandler helpmenuhandler;
	
	public MenuHelp(String label){
		super(label);
		helpmenuhandler = new HelpMenuHandler();
		for(HelpMenuItems btn : HelpMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(helpmenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class HelpMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(HelpMenuItems.valueOf(e.getActionCommand())){
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
