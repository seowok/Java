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
				case SelectFont :
					break;
				case UseBasicFont :
					break;
				case Enlarge:
					break;
				case Reduce :
					break;
				case SentenceEmphasize :
					break;
				case LockWindow :
					break;
				case SeeBlank :
					break;
				case SeeLineDifference :
					break;
				case SeeLineNumber :
					break;
				case AutoLineChanging :
					break;
				case ChangeLeftRight :
					break;
				case ToolCollection :
					break;
				case StateLine :
					break;
				case TabToolCollection :
					break;
				case SeeSelectCompare :
					break;
				case SeeLocation :
					break;
				case Language:
					break;
				case Renew :
					break;
			}
			
		}
		
	}

}
