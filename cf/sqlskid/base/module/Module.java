package cf.sqlskid.base.module;

import cf.sqlskid.base.event.EventManager;
import net.minecraft.client.Minecraft;

public class Module {
    private String name;
    private String displayName;
    private int key;
    private Category category;
    private boolean toggled;

    protected Minecraft mc;

    public Module(String name, String displayName, int key, Category category){
       this.name = name;
       this.displayName = displayName;
       this.key = key;
       this.category = category;
       mc = Minecraft.getMinecraft();
       setup();
    }

    public void setup(){}

    public void onEnable(){
        EventManager.register(this);
    }
    public void onDisable(){
        EventManager.unregister(this);
    }

    public void toggle(){
        if(toggled){
            onDisable();
            toggled = false;
        }else
        {
            toggled = true;
            onEnable();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isEnabled(){
        return toggled;
    }

}
