package com.multicampus.springex.mapper;

import com.multicampus.springex.domain.TodoVO;
import com.multicampus.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime() {

        System.out.println("testGetTime method called.");

        Assertions.assertNotNull(todoMapper);
        log.info(todoMapper);
        System.out.println("log info instance timeMapper.");
        log.info(todoMapper.getClass());
        System.out.println("log info instance timeMapper.getClass()");
        log.info(todoMapper.getClass().getName());
        System.out.println("log info instance timeMapper.getClass().getName()");
        log.info(todoMapper.getTime());
        System.out.println("log info timeMapper.getTime()");

    }

    @Test
    public void testInsert() {
        TodoVO todoVO = TodoVO.builder()
                .title("Spring Todo Test")
                .dueDate(LocalDate.of(2023,8,9))
                .writer("user1")
        .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO> voList = todoMapper.selectAll();

        // lambda
        voList.forEach(vo -> log.info(vo));

        // enhanced for
//        for (TodoVO vo : voList){
//            log.info(vo);
//        }

    }

    @Test
    public void testSelectOne() {
        TodoVO todoVO = todoMapper.selectOne(3L);
        log.info(todoVO);
    }

}

