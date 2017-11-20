package com.zaakman.lib.event;

import java.util.HashMap;

/**
 * Created by ZaakMan on 2017/7/28.
 * 事件队列
 */

public class EventQueue {

    private HashMap<String, EventListener> mHashMap = new HashMap<>();

    private static EventQueue mEventQueue = null;

    private EventQueue() {
    }

    public static EventQueue getInstance() {
        if (mEventQueue == null) {
            mEventQueue = new EventQueue();
        }
        return mEventQueue;
    }

    public void put(String key, EventListener listener) {
        mHashMap.put(key, listener);
    }

    public EventListener get(String key) {
        return mHashMap.get(key);
    }

    public void delete(String key) {
        mHashMap.remove(key);
    }


    public void send(String key, Object... objects) {
        EventListener listener = mHashMap.get(key);
        Object[] os = objects;
        if (listener != null) {
            listener.onEvent(os);
        }
    }

}
