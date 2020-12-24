package com.aricsun.boot.launch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 应用程序启动监听（第二种方法）
 * @author AricSun
 * @date 2020.12.24 16:23
 */
@Slf4j
@Component  // 应用启动监听器的实现方式 1 Component
public class AppStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunner参数名称：{}", args.getOptionNames());
        log.info("ApplicationRunner参数值：{}", args.getOptionValues("age"));  // 在idea的项目配置里， 设置程序参数：--name=zimug --age=18
        log.info("ApplicationRunner参数：{}", Arrays.toString(args.getSourceArgs()));
    }
}
