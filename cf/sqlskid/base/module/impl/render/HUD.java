package cf.sqlskid.base.module.impl.render;

import cf.sqlskid.base.Client;
import cf.sqlskid.base.event.EventTarget;
import cf.sqlskid.base.events.EventRender2D;
import cf.sqlskid.base.module.Category;
import cf.sqlskid.base.module.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HUD extends Module {
    public HUD() {
        super("HUD", "HUD", 0, Category.RENDER);
        toggle();
    }

    @EventTarget
    public void onRender2D(EventRender2D e){
        mc.fontRendererObj.drawStringWithShadow(Client.NAME + " b" + Client.VERSION,  2, 2, 0x00FF00);


        //arraylist
        int count = 0;
        ScaledResolution sr = new ScaledResolution(mc);
        sr.getScaledWidth();
        sr.getScaledHeight();

        List<String> display = new ArrayList();
        for (Module m : Client.instance.moduleManager.getModules()) {
            if ((m.isEnabled())) {
                int right = sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(m.getDisplayName());
                mc.fontRendererObj.drawStringWithShadow( m.getDisplayName(), right - 1, 2 + (count * 10), 0x00FF00);
                count++;
            }
        }


        Collections.sort(Client.instance.moduleManager.getModules(), new Comparator<Module>() {

            @Override
            public int compare(Module mod1, Module mod2) {
                if (mc.fontRendererObj.getStringWidth(mod1.getDisplayName()) > mc.fontRendererObj.getStringWidth(mod2.getDisplayName())) {
                    return -1;
                }
                if (mc.fontRendererObj.getStringWidth(mod1.getDisplayName()) < mc.fontRendererObj.getStringWidth(mod2.getDisplayName())) {
                    return 1;
                }
                return 0;
            }
        });
    }
}



