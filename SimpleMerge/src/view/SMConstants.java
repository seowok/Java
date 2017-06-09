package view;

public class SMConstants {
	//MainFrame
	public static final int WIDTH_MAINFRAME = 1500;
	public static final int HEIGHT_MAINFRAME = 1200;
	public static final String TITLE_MAINFRAME = "SimpleMerge";
	//ToolBar
	public static enum ToolBarButtons {NewFile, LoadFile, SaveFile, NextDiff, PrevDiff, FirstDiff,
	 LastDiff, ShiftRight, ShiftLeft, AllShiftRight, AllShiftLeft, F5};
	public static final String IMG_URL = "images/";
	public static final String TOOLBAR_BTN = ".gif";
	//MenuBar
	public static final String TITLE_EDITMENU = "����(E)";
	public static final String TITLE_FILEMENU = "����(F)";
	public static final String TITLE_HELPMENU = "����(H)";
	public static final String TITLE_PLUGINSMENU = "�÷�����(P)";
	public static final String TITLE_TOOLSMENU = "����(T)";
	public static final String TITLE_VIEWMENU = "����(V)";
	public static final String TITLE_WINDOWMENU = "â(W)";
	//Menu
	public static enum FileMenuItems {NewFile, LoadFile, SaveFile};
	public static enum EditMenuItems {Undo, Restart, Cut, Copy, Paste, LineDiffChoice, AllChoice, Find, Change, Script, Details, BookMark, Move, Settings};
	public static enum HelpMenuItems {Instruction, ReleaseNote, Translation, Settings,CompressFile,GNELisence,WinmergeINFO}
	public static enum PluginsMenuItems {List,UnAutoUnpack, AutoUnpack, UnpackerUseEdit,Prediffer,PluginReload};
	public static enum ToolsMenuItems {Filter, PatchMaking, ReportMaking};
	public static enum ViewMenuItems {SelectFont,UseBasicFont,Enlarge,Reduce,SentenceEmphasize,LockWindow,SeeBlank,SeeLineDifference,SeeLineNumber,AutoLineChanging,ChangeLeftRight,ToolCollection,StateLine,TabToolCollection,SeeSelectCompare,SeeLocation,Language,Renew};
	public static enum WindowMenuItems {Close,CloseAll,ChangeWindow,VerticalSort,HorizentalSort,StepSort}
	
}
