package com.sitech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图controller
 */
@Controller
@RequestMapping("/microsrv")
public class ViewController {

    @GetMapping("login")
    public String login(){
        return "index";
    }

}
