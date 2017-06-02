package view;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.SMConstants.MergeMenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMerge extends JMenu{
	private MergeMenuHandler mergemenuhandler;
	
	public MenuMerge(String label){
		super(label);
		mergemenuhandler = new MergeMenuHandler();
		for(MergeMenuItems btn : MergeMenuItems.values()){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(mergemenuhandler);
			menuItem.setActionCommand(btn.toString());
			add(menuItem);
		}	
	}
	private class MergeMenuHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switch(MergeMenuItems.valueOf(e.getActionCommand())){
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
