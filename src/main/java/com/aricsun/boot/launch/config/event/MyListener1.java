package com.aricsun.boot.launch.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * 自定义事件监听器
 * 第一种注册自定义事件监听器的方法，见com/aricsun/boot/launch/BootLaunchApplication.java
 * @author AricSun
 * @date 2020.12.24 15:30
 */
@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        log.info(String.format("%s监听到事件源：%s.",
                MyListener1.class.getName(),
                myEvent.getSource()));
    }
}
