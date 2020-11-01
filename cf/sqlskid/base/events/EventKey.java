package cf.sqlskid.base.events;

import cf.sqlskid.base.event.Event;

public class EventKey extends Event {

    private int key;

    public EventKey(int k)
    {
        key = k;
    }

    public int getKey(){
        return key;
    }


}
