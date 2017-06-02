package view;
import javax.swing.JToolBar;
import javax.swing.text.BadLocationException;

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
	private TextViewer textviewer;
	
	public ToolBar(String title)
	{
		super(title);
		toolBarHandler = new ToolBarHandler();
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
	
	public void initial(TextViewer textviewer)
	{
		this.textviewer = textviewer;
	}
	
	private class ToolBarHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton button = (JButton)e.getSource();
			if(button.getActionCommand().equals(ToolBarButtons.NewFile.name())){       

			}else if(button.getActionCommand().equals(ToolBarButtons.LoadFile.name())){         
				new Openfile(textviewer);
			}else if(button.getActionCommand().equals(ToolBarButtons.SaveFile.name())){              
				
			}else if(button.getActionCommand().equals(ToolBarButtons.ShiftRight.name())){                    
				
			}else if(button.getActionCommand().equals(ToolBarButtons.ShiftLeft.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.Undo.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.Redo.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.FindDiffInLine.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.NextDiff.name())){
				try {
					textviewer.nextDiff();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(button.getActionCommand().equals(ToolBarButtons.PrevDiff.name())){
				try {
					textviewer.prevDiff();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(button.getActionCommand().equals(ToolBarButtons.FirstDiff.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.NowDiff.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.LastDiff.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.ShiftLeftPro.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.ShiftRightPro.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.Settings.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.AllShiftRight.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.AllShiftLeft.name())){
				
			}else if(button.getActionCommand().equals(ToolBarButtons.F5.name())){
				textviewer.highliteText();
			}
		}
	}
}
