package com.aricsun.boot.launch.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器
 * @author AricSun
 * @date 2020.12.24 15:35
 */
@Slf4j
@Component  // 第二种注册自定义事件监听器的方法（推荐）
public class MyListener2 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        log.info(String.format("%s监听到事件源：%s.",
                MyListener2.class.getName(),
                myEvent.getSource()));
    }
}
