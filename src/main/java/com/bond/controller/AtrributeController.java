package com.bond.controller;

import com.bond.bean.AuditAttribute;
import com.bond.bean.AuditSonattribute;
import com.bond.service.AttributeService;
import com.bond.service.ModelService;
import com.bond.service.SonAttrService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AtrributeController {
    @Resource
    private AttributeService attservice=new AttributeService();
    @Resource
    private ModelService modelService;
    @Resource
    private SonAttrService sonAttrService;

    //查询所有
    @RequestMapping("/attlist")
    @ResponseBody
    public List<AuditAttribute> propertymanage(){
        List<AuditAttribute> atts=attservice.findAllType();
        return atts;
    }

    @RequestMapping("/attbyname")
    @ResponseBody
    public List<AuditSonattribute> attbyname(Integer aId){
       return sonAttrService.findbyaid(aId);
    }

    //新增属性
    @RequestMapping("/addproperty")
    @ResponseBody
    public int saveproperty(HttpServletRequest request,String aName,String aType){
//        String aName=request.getParameter("aName");
//        String aType=request.getParameter("aType");
        System.out.println(aName+"//"+aType);
        AuditAttribute attribute=new AuditAttribute(aName,aType);
        AuditAttribute a=attservice.insert(attribute);
        if (a!=null){
            return 1;
        }else {
            return 0;
        }
    }

    //删除属性
    @RequestMapping("/delpro")
    @ResponseBody
    public int delpro(Integer aId){
        attservice.delpro(aId);
        return 1;
    }
}
