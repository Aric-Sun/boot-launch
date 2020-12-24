package com.aricsun.boot.launch.config.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件：事件角色
 * @author AricSun
 * @date 2020.12.24 15:27
 */
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}
