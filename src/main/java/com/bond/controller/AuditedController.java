package com.bond.controller;

import com.bond.bean.AuditAuditedInstitutions;
import com.bond.bean.AuditUser;
import com.bond.service.AuditedService;
import com.bond.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AuditedController {
    @Resource
    private AuditedService auditedService;
    @Resource
    private UserService userService;

    @RequestMapping("/auditedmanager")
    public String findall(Model model){
        List<AuditAuditedInstitutions> auditeds=auditedService.findall();
        model.addAttribute("auditeds",auditeds);
        return "auditManager/auditedManage";
    }

    @RequestMapping("/sons")
    @ResponseBody
    public List<AuditAuditedInstitutions> findson(HttpSession session,Integer preId, String auditedBusiness){
        return auditedService.findSearch(preId,auditedBusiness);
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<AuditAuditedInstitutions> findAll(){
        return auditedService.findAll();
    }

    @RequestMapping("/seleusers")
    @ResponseBody
    public List<AuditUser> sss(@RequestParam("auditedId") Integer auditedId){
        System.out.println(userService.findusers(auditedId).size()+"******************");
        return userService.findusers(auditedId);
    }
}
