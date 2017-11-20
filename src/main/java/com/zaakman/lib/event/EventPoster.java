package com.zaakman.lib.event;

/**
 * Created by ZaakMan on 2017/7/28.
 * 发送事件
 */

public class EventPoster {

    public static void Poster(String eventName, Object... objects) {
        EventQueue.getInstance().send(eventName, objects);
    }

}
