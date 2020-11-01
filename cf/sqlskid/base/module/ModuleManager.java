package cf.sqlskid.base.module;

import cf.sqlskid.base.event.EventTarget;
import cf.sqlskid.base.events.EventKey;
import cf.sqlskid.base.module.impl.combat.Aura;
import cf.sqlskid.base.module.impl.combat.Velocity;
import cf.sqlskid.base.module.impl.movement.Sprint;
import cf.sqlskid.base.module.impl.player.NoFall;
import cf.sqlskid.base.module.impl.render.GUIMOD;
import cf.sqlskid.base.module.impl.render.HUD;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private List<Module> moduleList = new ArrayList<>();

    public ModuleManager(){
        moduleList.add(new Sprint());
        moduleList.add(new HUD());
        moduleList.add(new Aura());
        moduleList.add(new GUIMOD());
        moduleList.add(new Velocity());
        moduleList.add(new NoFall());
    }
    public List<Module> getModules(){
        return moduleList;
    }

    public Module getModuleByName(String name){
        for(Module m: getModules()){
            if(name == m.getName()){
                return m;
            }
        }
        return null;
    }

    @EventTarget
    public void onKey(EventKey e){
        for(Module m: getModules()){
            if(e.getKey() == m.getKey()){
                m.toggle();
            }
        }
    }

}
