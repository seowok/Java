package controller.file;

import javax.swing.JTextArea;

public interface SetReadOnly {
	
	//set text area to do not edit contents
	//using JTextArea.setEditable(false)
	public void setReadOnlyMode(JTextArea text_area);
}
