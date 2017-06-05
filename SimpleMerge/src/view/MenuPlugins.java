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
				case List :
					break;
				case UnAutoUnpack :
					break;
				case AutoUnpack :
					break;
				case UnpackerUseEdit :
					break;
				case Prediffer :
					break;
				case PluginReload :
					break;
			}
			
		}
		
	}

}
