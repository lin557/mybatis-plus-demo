package com.lin.study.mybatis;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;

@SpringBootApplication
//@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
@MapperScan("com.lin.study.mybatis.sql.mapper")
public class MybatisApplication {

private static Logger logger = LoggerFactory.getLogger(MybatisApplication.class);
    
    @Autowired
    private BuildProperties buildProperties;
    
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @PostConstruct
    private void init() {
        logger.info(buildProperties.getVersion());
    }
}
