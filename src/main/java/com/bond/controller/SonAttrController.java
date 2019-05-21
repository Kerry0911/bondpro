package com.bond.controller;

import com.bond.bean.AuditSonattribute;
import com.bond.service.AttributeService;
import com.bond.service.SonAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SonAttrController {
    @Resource
    private SonAttrService sonAttrService;

    @RequestMapping("/addson")
    @ResponseBody
    public int addson(String sonaCode,String sonaName,Integer aId){
        AuditSonattribute son=new AuditSonattribute(sonaCode,aId,sonaName);
        AuditSonattribute s=sonAttrService.addson(son);
        if (s!=null){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("/editson")
    @ResponseBody
    public int editson(String sonaCode,String sonaName,Integer sonaId){
        return sonAttrService.setson(sonaCode,sonaName,sonaId);
    }


    @RequestMapping("/delson")
    @ResponseBody
    public int delson(Integer sonaId){
        sonAttrService.delson(sonaId);
        return 1;
    }
}
