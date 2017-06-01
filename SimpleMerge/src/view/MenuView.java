package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.SMConstants.ViewMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JMenu{
	private ViewMenuHandler viewmenuhandler;
	
	public MenuView(String label){
		super(label);
		viewmenuhandler = new ViewMenuHandler();
		for(ViewMenuItems btn : ViewMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(viewmenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class ViewMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(ViewMenuItems.valueOf(e.getActionCommand())){
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
