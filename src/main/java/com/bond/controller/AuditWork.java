package com.bond.controller;

import com.bond.bean.AuditPlan;
import com.bond.bean.AuditPlanproject;
import com.bond.bean.AuditUser;
import com.bond.service.AuditPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class AuditWork {
    @Autowired
    private AuditPlanService service;

    @RequestMapping(value = "auditPlan")
    public String auditPlan(HttpSession session){
        List<AuditPlan> list=  service.selectAll();
        session.setAttribute("list1",list);
        return "auditWork/auditPlan";
    }
    @RequestMapping("selectAllAuditPlan")
    @ResponseBody
    public List<AuditPlan> selectAll(){
        List<AuditPlan> list=  service.selectAll();
        return list;
    }
    @RequestMapping("selectnamebyuserid")
    @ResponseBody
    public String selectnamebyuserid(@RequestParam("id") Integer id){
        Optional<AuditUser> optionalAuditUser = service.selectbyid(id);
        String name =optionalAuditUser.get().getuUsername();
        return name;
    }
    @RequestMapping("selectbypId")
    @ResponseBody
    public Map<String, Object> selectbypId(@RequestParam("pId")Integer pId){
        List<AuditPlanproject> list = service.selectbypId(pId);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("list",list);
        return map;
    }

    @RequestMapping("selectbypnd")
    @ResponseBody
    public List<AuditPlan> selectByPnd(@RequestParam("pnd")String pnd){
        List<AuditPlan> list = service.findbypnd(pnd);
        return list;
    }

    @RequestMapping("addauditplan")
    @ResponseBody
    public boolean addauditplan(AuditPlan auditPlan){
        boolean b = false;
        AuditPlan a = service.addauditplan(auditPlan);
        if(a!=null){
            b=true;
        }
        return b;
    }
}
