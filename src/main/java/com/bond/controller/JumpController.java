package com.bond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
    @RequestMapping("/todolist")
    public String todolist(){return "todoList"; }

    @RequestMapping("/manager")
    public String manager(){
        return "auditManager/auditedManage";
    }

    @RequestMapping("/useradmin")
    public String useradmin(){
        return "auditManager/auditUserAdministration";
    }

    @RequestMapping("/managerindex")
    public String index(){
        return "auditManager/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
