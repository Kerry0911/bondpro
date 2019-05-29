package com.bond.controller;

import com.bond.bean.AuditUser;
import com.bond.bean.Daibanthing;
import com.bond.bean.Officialdraft;
import com.bond.service.OfficialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TodoController {
    @Resource
    private OfficialService officialService;

    @RequestMapping("/things")
    @ResponseBody
    public List<Daibanthing> findby(HttpSession session){
        AuditUser user=(AuditUser) session.getAttribute("users");
        return officialService.findBySendname(user.getuUsercode());
    }

    @RequestMapping("/approveds")
    @ResponseBody
    public List<Officialdraft> findbupeople(HttpSession session){
        AuditUser user=(AuditUser) session.getAttribute("users");
        return officialService.findBypeople(user.getuUsercode());
    }
}
