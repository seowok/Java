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
	public static final String TITLE_EDITMENU = "편집(E)";
	public static final String TITLE_FILEMENU = "파일(F)";
	public static final String TITLE_HELPMENU = "도움말(H)";
	public static final String TITLE_PLUGINSMENU = "플러그인(P)";
	public static final String TITLE_TOOLSMENU = "도구(T)";
	public static final String TITLE_VIEWMENU = "보기(V)";
	public static final String TITLE_WINDOWMENU = "창(W)";
	//Menu
	public static enum FileMenuItems {NewFile, LoadFile, SaveFile};
	public static enum EditMenuItems {Undo, Restart, Cut, Copy, Paste, LineDiffChoice, AllChoice, Find, Change, Script, Details, BookMark, Move, Settings};
	public static enum HelpMenuItems {Instruction, ReleaseNote, Translation, Settings,CompressFile,GNELisence,WinmergeINFO}
	public static enum PluginsMenuItems {List,UnAutoUnpack, AutoUnpack, UnpackerUseEdit,Prediffer,PluginReload};
	public static enum ToolsMenuItems {Filter, PatchMaking, ReportMaking};
	public static enum ViewMenuItems {SelectFont,UseBasicFont,Enlarge,Reduce,SentenceEmphasize,LockWindow,SeeBlank,SeeLineDifference,SeeLineNumber,AutoLineChanging,ChangeLeftRight,ToolCollection,StateLine,TabToolCollection,SeeSelectCompare,SeeLocation,Language,Renew};
	public static enum WindowMenuItems {Close,CloseAll,ChangeWindow,VerticalSort,HorizentalSort,StepSort}
	
}
