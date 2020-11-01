package cf.sqlskid.base.module.impl.player;

import cf.sqlskid.base.event.EventTarget;
import cf.sqlskid.base.events.EventUpdate;
import cf.sqlskid.base.module.Category;
import cf.sqlskid.base.module.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoFall extends Module {
    public NoFall() {
        super("NoFall", "NoFall", 0, Category.PLAYER);
    }

    @EventTarget
    public void onUpdate(EventUpdate e){
        if(mc.thePlayer.fallDistance >= 3.0){
            mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
        }
    }
}
