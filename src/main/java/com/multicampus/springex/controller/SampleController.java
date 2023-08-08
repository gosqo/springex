package com.multicampus.springex.controller;

import com.multicampus.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

// 스프링 MVC 에서 컨트롤러 역할, 스프링  Bean 으로 등록 처리.
@Controller
@Log4j2
public class SampleController {

    // Get 방식으로 들어오는 요청을 처리하기 위한 애너테이션
    @GetMapping("/hello")
    public void hello() {
        log.info("hello~");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1 ...");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name ="name" ,defaultValue = "CCC") String name,
                    @RequestParam(name ="age", defaultValue = "20") int age) {
        log.info("ex2 ...");
        log.info("name : " + name);
        log.info("age : " + age);

    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3 ...");
        log.info(dueDate);
    }

    @GetMapping("/ex4")
    public void ex3(Model model) {
        log.info("ex4 ...");
        model.addAttribute("message", "Hello Spring project!");
        model.addAttribute("sentence", "This is a sentence.");
    }

    @GetMapping("/ex4_1")
    public void ex4Extra(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
        log.info("ex4_1 ...");
        log.info(todoDTO);
        model.addAttribute("message", "Hello ex4_1.");
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", "Hello ABC");
        redirectAttributes.addFlashAttribute("result","seccess");
        return "redirect: /ex6";
    }

    @GetMapping("/ex6")
    public void ex6() {

    }
}
