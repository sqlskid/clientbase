package cf.sqlskid.base.module.impl.combat;

import cf.sqlskid.base.Client;
import cf.sqlskid.base.event.EventTarget;
import cf.sqlskid.base.events.EventPreMotion;
import cf.sqlskid.base.module.Category;
import cf.sqlskid.base.module.Module;
import cf.sqlskid.base.utils.TimeHelper;
import com.sun.javafx.geom.Vec3d;
import de.Hero.clickgui.ClickGUI;
import de.Hero.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class Aura extends Module {


    TimeHelper time = new TimeHelper();

    private boolean isDead;
    private Entity currentEntity;
    public static List<EntityLivingBase> entities;
    public static EntityLivingBase target;

    public Aura() {
        super("Aura", "Aura", Keyboard.KEY_R, Category.COMBAT);
    }

    @Override
    public void setup(){
        Client.instance.settingsManager.rSetting(new Setting("Aura.Delay", "Delay", this, 9.69f, 1, 25, false));
        Client.instance.settingsManager.rSetting(new Setting("Aura.Range", "Range", this, 3.8f, 3, 8, false));
    }

    @EventTarget
    public void onPre(EventPreMotion e){
        List list = mc.theWorld.loadedEntityList;
        for (int k = 0; k < list.size(); k++) {
            if (((Entity) list.get(k)).getName() != mc.thePlayer.getName()) {
                Entity entityplayer = (Entity) list.get(1);
                entityplayer = (Entity) list.get(k);
                if (isValid(entityplayer)) {
                    if (entityplayer.isDead) {
                        this.isDead = true;
                    } else {
                        this.isDead = false;
                    }
                    if (!this.isDead) {
                        this.currentEntity = entityplayer;
                    }

                    float[] rotations = getNeededRotations((EntityLivingBase) currentEntity);
                    e.setYaw(rotations[0]);
                    e.setPitch(rotations[1]);

                    if(time.hasReached((long) Client.instance.settingsManager.getSettingByName("Aura.Delay").getValDouble()) ) {
                        mc.thePlayer.swingItem();
                        mc.playerController.attackEntity(mc.thePlayer, currentEntity);
                        time.reset();
                    }
                }
            }
        }
    }
    public static float[] getNeededRotations(final EntityLivingBase entity) {
        final Vec3d eyesPos = new Vec3d(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight(), Minecraft.getMinecraft().thePlayer.posZ);
        final AxisAlignedBB bb = entity.getEntityBoundingBox();
        final Vec3d vec = new Vec3d(bb.minX + (bb.maxX - bb.minX) * 0.5, bb.minY + (bb.maxY - bb.minY) * 0.5, bb.minZ + (bb.maxZ - bb.minZ) * 0.5);
        final double diffX = vec.x - eyesPos.x;
        final double diffY = vec.y - eyesPos.y;
        final double diffZ = vec.z - eyesPos.z;
        final double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);
        final float yaw = (float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0f;
        final float pitch = (float)(-Math.toDegrees(Math.atan2(diffY, diffXZ)));
        return new float[] { MathHelper.wrapAngleTo180_float(yaw), MathHelper.wrapAngleTo180_float(pitch) };
    }

    public static boolean isValid(Entity e) {
        float f = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(e);

        if (e instanceof EntityLivingBase && f <=Client.instance.settingsManager.getSettingByName("Aura.Range").getValDouble()
                && !e.isDead
                && !Minecraft.getMinecraft().thePlayer.isDead && !e.isInvisible() && ((EntityLivingBase) e).canEntityBeSeen(Minecraft.getMinecraft().thePlayer)) {
            return true;
        } else {
            return false;
        }
    }
}
