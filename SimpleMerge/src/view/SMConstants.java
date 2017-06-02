package view;

public class SMConstants {
	//MainFrame
	public static final int WIDTH_MAINFRAME = 1000;
	public static final int HEIGHT_MAINFRAME = 800;
	public static final String TITLE_MAINFRAME = "SimpleMerge";
	//ToolBar
	public static enum ToolBarButtons {NewFile, LoadFile, SaveFile, Undo, Redo, FindDiffInLine, NextDiff, PrevDiff, FirstDiff,
	NowDiff, LastDiff, ShiftRight, ShiftLeft, ShiftRightPro, ShiftLeftPro, Settings, AllShiftRight, AllShiftLeft, F5};
	public static final String IMG_URL = "images/";
	public static final String TOOLBAR_BTN = ".gif";
	//MenuBar
	public static final String TITLE_EDITMENU = "편집(E)";
	public static final String TITLE_FILEMENU = "파일(F)";
	public static final String TITLE_HELPMENU = "도움말(H)";
	public static final String TITLE_PLUGINSMENU = "플러그인(P)";
	public static final String TITLE_TOOLSMENU = "도구(T)";
	public static final String TITLE_VIEWMENU = "보기(V)";
	public static final String TITLE_WINDOWMENU = "창(W)";
	//Menu
	public static enum EditMenuItems {Menu1, Menu2, Menu3, Menu4};
	public static enum FileMenuItems {Menu1, Menu2, Menu3, Menu4};
	public static enum HelpMenuItems {Menu1, Menu2, Menu3, Menu4};
	public static enum PluginsMenuItems {Menu1, Menu2, Menu3, Menu4};
	public static enum ToolsMenuItems {Menu1, Menu2, Menu3, Menu4};
	public static enum ViewMenuItems {Menu1, Menu2, Menu3, Menu4};
	public static enum WindowMenuItems {Menu1, Menu2, Menu3, Menu4};
	
}
