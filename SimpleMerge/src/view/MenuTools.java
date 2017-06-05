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
				case Filter :
					break;
				case PatchMaking :
					break;
				case ReportMaking :
					break;
			}
			
		}
		
	}
}
