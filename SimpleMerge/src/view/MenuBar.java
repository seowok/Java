<<<<<<< HEAD
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
=======
package view;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar{
	private MenuFile menu_file;
	private MenuEdit menu_edit;
	private MenuHelp menu_help;
	private MenuMerge menu_merge;
	private MenuPlugins menu_plugins;
	private MenuTools menu_tools;
	private MenuView menu_view;
	private MenuWindow menu_window;
	
	public MenuBar()
	{
		menu_edit = new MenuEdit(SMConstants.TITLE_EDITMENU);
		add(menu_edit);
		menu_file = new MenuFile(SMConstants.TITLE_FILEMENU);
		add(menu_file);
		menu_help = new MenuHelp(SMConstants.TITLE_HELPMENU);
		add(menu_help);
		menu_merge = new MenuMerge(SMConstants.TITLE_MERGEMENU);
		add(menu_merge);
		menu_plugins = new MenuPlugins(SMConstants.TITLE_PLUGINSMENU);
		add(menu_plugins);
		menu_tools = new MenuTools(SMConstants.TITLE_TOOLSMENU);
		add(menu_tools);
		menu_view = new MenuView(SMConstants.TITLE_VIEWMENU);
		add(menu_view);
		menu_window = new MenuWindow(SMConstants.TITLE_WINDOWMENU);
		add(menu_window);
	}
	public void initial()
	{
		
	}
}
>>>>>>> e45d3bbc1a3274c6fb6ade56f3e6a5e22427220a
