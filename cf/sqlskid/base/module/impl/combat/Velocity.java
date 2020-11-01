package cf.sqlskid.base.module.impl.combat;

import cf.sqlskid.base.event.EventTarget;
import cf.sqlskid.base.events.EventUpdate;
import cf.sqlskid.base.module.Category;
import cf.sqlskid.base.module.Module;

public class Velocity extends Module {
    public Velocity() {
        super("Velocity", "Velocity", 0, Category.COMBAT);
    }

    @EventTarget
    public void onUpdate(EventUpdate e){

    }

}
