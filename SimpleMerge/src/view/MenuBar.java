package view;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar{
	private MenuFile menu_file;
	private MenuEdit menu_edit;
	private MenuHelp menu_help;
	private MenuPlugins menu_plugins;
	private MenuTools menu_tools;
	private MenuView menu_view;
	private MenuWindow menu_window;
	private TextViewer textviewer;
	
	public MenuBar()
	{
		menu_file = new MenuFile(SMConstants.TITLE_FILEMENU);
		add(menu_file);
		menu_edit = new MenuEdit(SMConstants.TITLE_EDITMENU);
		add(menu_edit);
		menu_view = new MenuView(SMConstants.TITLE_VIEWMENU);
		add(menu_view);
		menu_tools = new MenuTools(SMConstants.TITLE_TOOLSMENU);
		add(menu_tools);
		menu_plugins = new MenuPlugins(SMConstants.TITLE_PLUGINSMENU);
		add(menu_plugins);
		menu_window = new MenuWindow(SMConstants.TITLE_WINDOWMENU);
		add(menu_window);
		menu_help = new MenuHelp(SMConstants.TITLE_HELPMENU);
		add(menu_help);
	}
	public void initial(TextViewer textviewer)
	{
		this.textviewer = textviewer;
	}
}
