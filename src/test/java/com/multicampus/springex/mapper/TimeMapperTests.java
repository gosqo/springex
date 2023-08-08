package com.multicampus.springex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {

    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Test
    public void testGetTime() {

        System.out.println("testGetTime method called.");

        Assertions.assertNotNull(timeMapper);
        log.info(timeMapper);
        System.out.println("log info instance timeMapper.");
        log.info(timeMapper.getClass());
        System.out.println("log info instance timeMapper.getClass()");
        log.info(timeMapper.getClass().getName());
        System.out.println("log info instance timeMapper.getClass().getName()");
        log.info(timeMapper.getTime());
        System.out.println("log info timeMapper.getTime()");
    }

    @Test
    public void testGetTime2() {

        log.info("getTime2");
        log.info(timeMapper.getTime2());
    }
}
