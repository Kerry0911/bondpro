package com.bond.controller;

import com.bond.bean.AuditAttribute;
import com.bond.bean.Model;
import com.bond.service.AttributeService;
import com.bond.service.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ModelController {
    @Resource
    private ModelService modelService;
    @Resource
    private AttributeService attservice=new AttributeService();

    @RequestMapping("/models")
    @ResponseBody
    public List<Model> models(){
        return modelService.findAll();
    }

    @RequestMapping("/modelid")
    @ResponseBody
    public List<AuditAttribute> modelbyid(Integer modelId){
        return attservice.findModelId(modelId);
    }

    //新增属性
    @RequestMapping("/modeladdpro")
    @ResponseBody
    public int modeladdpro(HttpServletRequest request, String aName, Integer modelId){
        AuditAttribute attribute=new AuditAttribute(aName,modelId);
        //System.out.println(attribute.getModel().getModelId());
        AuditAttribute a=attservice.insert(attribute);
        if (a!=null){
            return 1;
        }else {
            return 0;
        }
    }
}

