package com.bond.controller;

import com.bond.bean.AuditAttribute;
import com.bond.service.AttributeService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AtrributeController {
    @Resource
    private AttributeService attservice=new AttributeService();

    //查询所有
    @RequestMapping("/attlist")
    @ResponseBody
    public List<AuditAttribute> propertymanage(){
        List<AuditAttribute> atts=attservice.findAll();
        System.out.println(atts.size());
        return atts;
    }

    @RequestMapping("/attbyname")
    @ResponseBody
    public List<AuditAttribute> attbyname(String name){
        System.out.println(name+"*************");
        return attservice.findAllByAname(name);
    }

    //新增属性
    @RequestMapping("/addproperty")
    @ResponseBody
    public int saveproperty(HttpServletRequest request){
        String aName=request.getParameter("aName");
        String aType=request.getParameter("aType");
        AuditAttribute attribute=new AuditAttribute(aName,aType);
        AuditAttribute a=attservice.insert(attribute);
        if (a!=null){
            return 1;
        }else {
            return 0;
        }
    }
}
