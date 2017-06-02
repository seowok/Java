package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.SMConstants.PluginsMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPlugins extends JMenu{
	private PluginsMenuHandler pluginsmenuhandler;
	
	public MenuPlugins(String label){
		super(label);
		pluginsmenuhandler = new PluginsMenuHandler();
		for(PluginsMenuItems btn : PluginsMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(pluginsmenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class PluginsMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(PluginsMenuItems.valueOf(e.getActionCommand())){
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
