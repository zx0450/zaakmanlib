package com.zaakman.lib.event;

/**
 * Created by ZaakMan on 2017/7/28.
 * 事件监听器
 */

public interface EventListener<T extends Object> {

    void onEvent(T... t);

}
