package com.bond.controller;

import com.bond.bean.AuditAuditedInstitutions;
import com.bond.bean.AuditUser;
import com.bond.bean.Systemconfiguration;
import com.bond.service.AuditedService;
import com.bond.service.SystemService;
import com.bond.service.UserService;
import org.springframework.data.annotation.ReadOnlyProperty;
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
    private AuditedService auditedService=new AuditedService();
    @Resource
    private UserService userService=new UserService();
    @Resource
    private SystemService systemService;

    @RequestMapping("/auditedmanager")
    public String findall(Model model){
        List<AuditAuditedInstitutions> auditeds=auditedService.findall();
        model.addAttribute("auditeds",auditeds);
        List<Systemconfiguration> systemconfigurations=systemService.findDepts();
        model.addAttribute("depts",systemconfigurations);
        List<Systemconfiguration> posts=systemService.findPosts();
        model.addAttribute("posts",posts);
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
        return userService.findusers(auditedId);
    }

    @RequestMapping("/addaudited")
    @ResponseBody
    public int save(AuditAuditedInstitutions institutions){
        AuditAuditedInstitutions a= auditedService.insert(institutions);
        if (a!=null){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("/editaudited")
    @ResponseBody
    public int update(AuditAuditedInstitutions institutions){
        //AuditAuditedInstitutions a=auditedService.findById(institutions.getAuditedId());
        AuditAuditedInstitutions a=auditedService.insert(institutions);
        if(a!=null) {
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("/delaudited")
    @ResponseBody
    public int delau(Integer auditedId){
        auditedService.del(auditedId);
        return 1;
    }
}
