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
				case Instruction :
					break;
				case ReleaseNote :
					break;
				case Translation :
					break;
				case Settings :
					break;
				case CompressFile :
					break;
				case GNELisence :
					break;
				case WinmergeINFO :
					break;
			}
			
		}
		
	}
}
