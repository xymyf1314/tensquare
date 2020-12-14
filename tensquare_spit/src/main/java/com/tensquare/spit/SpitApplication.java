package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * <p>
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.spit.SpitApplication.java
 * <p>作者: miyf1
 * <p>创建时间: 2020年10月28日 10:12
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
@SpringBootApplication
public class SpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
