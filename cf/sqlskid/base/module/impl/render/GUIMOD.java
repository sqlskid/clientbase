package cf.sqlskid.base.module.impl.render;

import cf.sqlskid.base.Client;
import cf.sqlskid.base.module.Category;
import cf.sqlskid.base.module.Module;
import de.Hero.settings.Setting;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class GUIMOD extends Module {
    public GUIMOD() {
        super("ClickGUI", "ClickGUI", Keyboard.KEY_RSHIFT, Category.RENDER);
    }


    @Override
    public void setup(){
        ArrayList<String> options = new ArrayList<>();
        options.add("JellyLike");
        options.add("New");
        Client.instance.settingsManager.rSetting(new Setting("Clickgui.Design","Design", this, "New", options));
        Client.instance.settingsManager.rSetting(new Setting("Clickgui.Sound", "Sound", this, false));
        Client.instance.settingsManager.rSetting(new Setting("GuiRed","R", this, 255, 0, 255, true));
        Client.instance.settingsManager.rSetting(new Setting("GuiGreen","G", this, 26, 0, 255, true));
        Client.instance.settingsManager.rSetting(new Setting("GuiBlue","B", this, 42, 0, 255, true));
    }

    @Override
    public void onEnable()
    {
        mc.displayGuiScreen(Client.instance.clickGUI);
        toggle();
        super.onEnable();
    }
}
