<<<<<<< HEAD
package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.SMConstants.ToolsMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuTools extends JMenu{
	private ToolsMenuHandler toolsmenuhandler;
	
	public MenuTools(String label){
		super(label);
		toolsmenuhandler = new ToolsMenuHandler();
		for(ToolsMenuItems btn : ToolsMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(toolsmenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class ToolsMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(ToolsMenuItems.valueOf(e.getActionCommand())){
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

import view.SMConstants.ToolsMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuTools extends JMenu{
	private ToolsMenuHandler toolsmenuhandler;
	
	public MenuTools(String label){
		super(label);
		toolsmenuhandler = new ToolsMenuHandler();
		for(ToolsMenuItems btn : ToolsMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(toolsmenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class ToolsMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(ToolsMenuItems.valueOf(e.getActionCommand())){
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
