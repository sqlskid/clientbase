package cf.sqlskid.base;

import cf.sqlskid.base.event.EventManager;
import cf.sqlskid.base.module.ModuleManager;
import de.Hero.clickgui.ClickGUI;
import de.Hero.settings.SettingsManager;

public class Client {

    public static Client instance;

    //useless variables
    public static String NAME = "Base";
    public static int VERSION = 1;

    public ModuleManager moduleManager;
    public SettingsManager settingsManager;
    public ClickGUI clickGUI;

    public void startClient(){
        instance = this;

        settingsManager = new SettingsManager();
        moduleManager = new ModuleManager();
        clickGUI = new ClickGUI();

        EventManager.register(moduleManager);
    }


}
