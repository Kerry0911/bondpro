package com.bond.controller;

import com.bond.bean.Model;
import com.bond.service.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ModelController {
    @Resource
    private ModelService modelService;

    @RequestMapping("/models")
    @ResponseBody
    public List<Model> models(){
        return modelService.findAll();
    }
}

