package view;

import javax.swing.JToolBar;
import javax.swing.text.BadLocationException;

import view.BringFileView;
import controller.file.NewFile;
import controller.file.OpenFile;
import controller.file.StoreFile;
import view.SMConstants.ToolBarButtons;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

public class ToolBar extends JToolBar {
	private ButtonGroup buttonGroup;
	private ToolBarHandler toolBarHandler;
	private TextViewer textviewer;
	private ArrayList<JButton> jbtn_arraylist;

	public ToolBar(String title) {
		super(title);
		toolBarHandler = new ToolBarHandler();
		buttonGroup = new ButtonGroup();
		JButton jbtn;
		jbtn_arraylist = new ArrayList<JButton>();

		for (ToolBarButtons btn : ToolBarButtons.values()) {
			jbtn = new JButton();
			jbtn.setIcon(new ImageIcon(SMConstants.IMG_URL + btn.toString() + SMConstants.TOOLBAR_BTN));
			jbtn.addActionListener(toolBarHandler);
			jbtn.setActionCommand(btn.toString());
			buttonGroup.add(jbtn);
			this.add(jbtn);
			jbtn_arraylist.add(jbtn);

		}
		
		for(int i = 3; i <= 10 ; i ++)
			jbtn_arraylist.get(i).setEnabled(false);
	}

	public void initial(TextViewer textviewer) {
		this.textviewer = textviewer;
	}

	private class ToolBarHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if (button.getActionCommand().equals(ToolBarButtons.NewFile.name())) {
				String strleft1 = textviewer.getLefttext().getText();
				String strright1 = textviewer.getRighttext().getText();

				if (strleft1.length() != 0 || strright1.length() != 0) // 왼쪽
					// 문서또는
					// 오른쪽
					// 문서가
					// 하나라도
					// 있을경우
					// 저장을
					// 하는
					// 창으로
					// 간다.
					new NewFileView(textviewer);

			} else if (button.getActionCommand().equals(ToolBarButtons.LoadFile.name())) {
				new BringFileView(textviewer);
			} else if (button.getActionCommand().equals(ToolBarButtons.SaveFile.name())) {
				StoreFile s = new StoreFile();
				s.LeftStoreFile(textviewer);
				s.RightStoreFile(textviewer);
			} else if (button.getActionCommand().equals(ToolBarButtons.ShiftRight.name())) {
				try {
					textviewer.shiftRight();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jbtn_arraylist.get(7).setEnabled(false);// ShiftRight
															// Activation
				jbtn_arraylist.get(8).setEnabled(false);// ShiftLeft Activation
			} else if (button.getActionCommand().equals(ToolBarButtons.ShiftLeft.name())) {
				try {
					textviewer.shiftLeft();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jbtn_arraylist.get(7).setEnabled(false);// ShiftRight Activation														// Activation
				jbtn_arraylist.get(8).setEnabled(false);// ShiftLeft Activation
			} else if (button.getActionCommand().equals(ToolBarButtons.NextDiff.name())) {
				try {
					textviewer.nextDiff();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jbtn_arraylist.get(7).setEnabled(true);// ShiftRight Activation
				jbtn_arraylist.get(8).setEnabled(true);// ShiftLeft Activation
			} else if (button.getActionCommand().equals(ToolBarButtons.PrevDiff.name())) {
				try {
					textviewer.prevDiff();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (button.getActionCommand().equals(ToolBarButtons.FirstDiff.name())) {
				try {
					textviewer.firstDiff();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jbtn_arraylist.get(7).setEnabled(true);
				jbtn_arraylist.get(8).setEnabled(true);
			}
			
			else if (button.getActionCommand().equals(ToolBarButtons.LastDiff.name())) {
				try {
					textviewer.lastDiff();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jbtn_arraylist.get(7).setEnabled(true);// ShiftRight Activation
				jbtn_arraylist.get(8).setEnabled(true);// ShiftLeft Activation
			}
			else if (button.getActionCommand().equals(ToolBarButtons.AllShiftRight.name())) {
				try {
					textviewer.shiftAllRight();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i = 3; i <= 10 ; i ++)
					jbtn_arraylist.get(i).setEnabled(false);
			} else if (button.getActionCommand().equals(ToolBarButtons.AllShiftLeft.name())) {
				try {
					textviewer.shiftAllLeht();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i = 3; i <= 10 ; i ++)
					jbtn_arraylist.get(i).setEnabled(false);
			} else if (button.getActionCommand().equals(ToolBarButtons.F5.name())) {
				textviewer.highliteText();
				for(int i = 3; i <= 10 ; i ++)
					jbtn_arraylist.get(i).setEnabled(true);
			}
		}
	}
}