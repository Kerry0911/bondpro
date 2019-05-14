package com.bond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuditWork {
    @RequestMapping("auditPlan")
    public String auditPlan(){
        return "auditWork/auditPlan";
    }
}
