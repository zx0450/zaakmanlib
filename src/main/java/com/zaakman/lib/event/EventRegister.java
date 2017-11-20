package com.zaakman.lib.event;

/**
 * Created by ZaakMan on 2017/7/28.
 * 事件注册
 */

public class EventRegister {

    public static void Register(String eventName, EventListener listener) {
        EventQueue.getInstance().put(eventName, listener);
    }

    public static void Unregister(String eventName) {
        EventQueue.getInstance().delete(eventName);
    }
}
