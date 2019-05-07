package com.bond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("/managerindex")
    public String index(){
        return "auditManager/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
