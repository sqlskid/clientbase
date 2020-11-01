package cf.sqlskid.base.module.impl.movement;

import cf.sqlskid.base.event.EventTarget;
import cf.sqlskid.base.events.EventUpdate;
import cf.sqlskid.base.module.Category;
import cf.sqlskid.base.module.Module;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", "Sprint", Keyboard.KEY_F, Category.MOVEMENT);
    }

    @EventTarget
    public void onUpdate(EventUpdate e)
    {
        mc.thePlayer.setSprinting(true);
    }
}
