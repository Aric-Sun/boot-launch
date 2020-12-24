package com.aricsun.boot.launch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 应用程序启动监听（第一种方法）
 * @author AricSun
 * @date 2020.12.24 16:18
 */
@Slf4j
@Component  // 应用启动监听器的实现方式 2 Component
public class CommandLineStartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner传入参数：{}", Arrays.toString(args));
    }
}
