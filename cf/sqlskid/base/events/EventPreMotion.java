package cf.sqlskid.base.events;

import cf.sqlskid.base.event.Event;

public class EventPreMotion extends Event {
    private float yaw,pitch;
    private boolean ground;
    private double x,y,z;
    private boolean isSneaking;

    public boolean isGround() {
        return ground;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean isSneaking() {
        return isSneaking;
    }

    public void setSneaking(boolean sneaking) {
        isSneaking = sneaking;
    }

    public boolean isSprinting() {
        return isSprinting;
    }

    public void setSprinting(boolean sprinting) {
        isSprinting = sprinting;
    }

    private boolean isSprinting;

    public EventPreMotion(float yaw, float pitch, boolean ground, double x, double y,double z, boolean isSprinting, boolean isSneaking){
        this.yaw = yaw;
        this.pitch = pitch;
        this.ground = ground;
        this.x = x;
        this.z = z;
        this.y = y;
    }

    public float getYaw(){
        return yaw;
    }

    public void setYaw(float yaw){
        this.yaw = yaw;
    }
    public float getPitch(){
        return pitch;
    }
    public void setPitch(float pitch){
        this.pitch = pitch;
    }
    public boolean onGround(){
        return ground;
    }
    public void setGround(boolean ground){
        this.ground = ground;
    }
}
