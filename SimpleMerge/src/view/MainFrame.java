package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	private static MainFrame mainframe = new MainFrame(SMConstants.TITLE_MAINFRAME);
	private MenuBar menubar;
	private ToolBar toolbar;
	private TextViewer textviewer;
	
	private MainFrame(String title){
		super(title);
		menubar = new MenuBar();
		this.setJMenuBar(menubar);
		toolbar = new ToolBar("Toolbar");
		add(BorderLayout.NORTH, toolbar);
		textviewer = new TextViewer();
		add(BorderLayout.CENTER, textviewer);
	}
	
	public static MainFrame getInstance()
	{
		return mainframe;
	}
	
	public void initial(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(SMConstants.WIDTH_MAINFRAME, SMConstants.HEIGHT_MAINFRAME);
		this.setVisible(true);
	}
}
