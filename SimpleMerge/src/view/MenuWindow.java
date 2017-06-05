package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.SMConstants.WindowMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JMenu{
	private WindowMenuHandler windowmenuhandler;
	
	public MenuWindow(String label){
		super(label);
		windowmenuhandler = new WindowMenuHandler();
		for(WindowMenuItems btn : WindowMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(windowmenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class WindowMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(WindowMenuItems.valueOf(e.getActionCommand())){
				case Close :
					break;
				case CloseAll :
					break;
				case ChangeWindow :
					break;
				case VerticalSort :
					break;
				case HorizentalSort :
					break;
				case StepSort :
					break;
			}
			
		}
		
	}
}
