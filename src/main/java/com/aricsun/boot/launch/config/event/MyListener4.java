package com.aricsun.boot.launch.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器
 * @author AricSun
 * @date 2020.12.24 15:39
 */
@Slf4j
@Component
public class MyListener4{
    @EventListener  // 第四种注册自定义事件监听器的方法
    public void listener(MyEvent myEvent) {
        log.info(String.format("%s监听到事件源：%s.",
                MyListener4.class.getName(),
                myEvent.getSource()));
    }
}
