package com.bond.controller;

import com.bond.bean.AuditBody;
import com.bond.service.AuditorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AuditorController {
    @Resource
    private AuditorService auditorService;

    @RequestMapping("/auditormanage")
    public String auditormanage(Model model){
        model.addAttribute("pre",auditorService.findpre());
        return "auditManager/auditorManage";
    }

    @RequestMapping("/preauditor")
    @ResponseBody
    public List<AuditBody> findpre(){
        return auditorService.findpre();
    }

    @RequestMapping("/sonauditor")
    @ResponseBody
    public List<AuditBody> findsonauditor(String abHigher){
        return auditorService.findson(abHigher);
    }

    @RequestMapping("/addbody")
    @ResponseBody
    public int addbody(AuditBody auditBody){
        AuditBody body=auditorService.insert(auditBody);
        if(body!=null){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("/editbody")
    @ResponseBody
    public int editbody(AuditBody auditBody){
        AuditBody body=auditorService.insert(auditBody);
        if(body!=null){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("/delbody")
    @ResponseBody
    public int delbody(String  abId){
        auditorService.delbody(abId);
        return 1;
    }
}
