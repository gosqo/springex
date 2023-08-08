package com.multicampus.springex.controller;

import com.multicampus.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    // localhost:8090/todo/list
    @RequestMapping("/list")
    public void list() {
        log.info("todo_list ...");
    }

    @GetMapping("/register")
    public void register() {
        log.info("todo_register ...");
    }

    @PostMapping("/register")
    public void regiserPost(TodoDTO todoDTO) {

        log.info("POST todo register ...");
        log.info(todoDTO);

    }

}
