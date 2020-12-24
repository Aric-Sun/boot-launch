package com.aricsun.boot.launch.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器
 * 第三种注册自定义事件监听器的方法，见application-dev.yml
 * @author AricSun
 * @date 2020.12.24 15:39
 */
@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        log.info(String.format("%s监听到事件源：%s.",
                MyListener3.class.getName(),
                myEvent.getSource()));
    }
}
