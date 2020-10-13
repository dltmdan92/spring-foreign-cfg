package com.seungmoo.springforeigncfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {
    /*
    @Value("${seungmoo.name}")
    private String name;

    @Value("${seungmoo.age}")
    private int age;
    */

    @Autowired
    private String hello;

    @Autowired
    private SeungmooProperties seungmoo;

    @Autowired
    private ProddbProperties proddb;

    private Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("=======================");
        logger.debug(seungmoo.getName());
        logger.debug(seungmoo.getFullName());
        System.out.println(seungmoo.getAge());
        logger.debug(seungmoo.getSessionTimeout().toString());
        logger.debug(hello);
        logger.debug(proddb.getValue1());
        logger.debug("=======================");
    }
}
