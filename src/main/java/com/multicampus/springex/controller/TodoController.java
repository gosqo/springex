package com.multicampus.springex.controller;

import com.multicampus.springex.dto.PageRequestDTO;
import com.multicampus.springex.dto.TodoDTO;
import com.multicampus.springex.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // localhost:8090/todo/list
//    @RequestMapping("/list")
//    public void list(Model model) {
//
//        log.info("todo_list ...");
//
//        // model 'dtoList' 이름으로 목록 데이터가 담겨있다.
//        model.addAttribute("dtoList", todoService.getAll());
//    }

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO,
                     BindingResult bindingResult,
                     Model model) {

        log.info(pageRequestDTO);

        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        // model 'responseDTO' 이름으로 목록 데이터가 담겨있다.
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void registerGET() {
        log.info("todo_register ...");
    }

    @PostMapping("/register")
    public String regiserPost(@Valid TodoDTO todoDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        log.info("POST todo register ...");

        if(bindingResult.hasErrors()) {
            log.info("has errors ...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);
        todoService.register(todoDTO);

        return "list";

    }

    @GetMapping({"/read", "/modify"})
    public void read(Long tno, Model model) {
        
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);

    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("has errors ...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        log.info(todoDTO);

        todoService.modify(todoDTO);

        redirectAttributes.addAttribute("tno", todoDTO.getTno());

        return "redirect:/todo/read";

    }

    @PostMapping("/remove")
    public String remove(Long tno,
                         RedirectAttributes redirectAttributes) {

        log.info("------------remove------------");
        log.info("tno : " + tno);

        todoService.remove(tno);

        return "redirect:/todo/list";

    }

}
