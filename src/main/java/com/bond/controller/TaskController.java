package com.bond.controller;

import com.bond.bean.Task;
import com.bond.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TaskController {
    @Resource
    private TaskService taskService;

    @RequestMapping("/datas")
    @ResponseBody
    public List<Task> findbypp(String ppId){
        return taskService.findByPp("96005");
    }

    @RequestMapping("/searchtask")
    @ResponseBody
    public List<Task> searchtask(Integer tId,String tAuditpoints){
        System.out.println(tId+"//"+tAuditpoints);
        System.out.println(taskService.searchby(tId,tAuditpoints).size());
        return taskService.searchby(tId,tAuditpoints);
    }
}
