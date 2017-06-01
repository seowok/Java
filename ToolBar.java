package view;
import javax.swing.JToolBar;

import view.SMConstants.ToolBarButtons;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ToolBar extends JToolBar{
	private ButtonGroup buttonGroup;
	private ToolBarHandler toolBarHandler;
	
	public ToolBar(String title)
	{
		super(title);
		buttonGroup = new ButtonGroup();
		JButton jbtn;
		for(ToolBarButtons btn : ToolBarButtons.values()){
			jbtn = new JButton();
			jbtn.setIcon(new ImageIcon(SMConstants.IMG_URL + btn.toString() + SMConstants.TOOLBAR_BTN));
			jbtn.addActionListener(toolBarHandler);
			jbtn.setActionCommand(btn.toString());
			buttonGroup.add(jbtn);
			this.add(jbtn);
		}
	}
	private class ToolBarHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JRadioButton button = (JRadioButton)e.getSource();
			if(button.getActionCommand().equals(ToolBarButtons.NewFile.name())){              
				
			}else if(button.getActionCommand().equals(ToolBarButtons.LoadFile.name())){         
				
			}else if(button.getActionCommand().equals(ToolBarButtons.SaveFile.name())){              
				
			}else if(button.getActionCommand().equals(ToolBarButtons.ShiftRight.name())){                    
				
			}else if(button.getActionCommand().equals(ToolBarButtons.ShiftLeft.name())){                    
			}
		}
	}
}
