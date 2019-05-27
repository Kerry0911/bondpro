package com.bond.controller;

import com.bond.bean.AuditLog;
import com.bond.repository.LogDao;
import com.bond.service.LogService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class LogController {
    @Resource
    private LogService logService;

//    @InitBinder
//    public void initbinder(WebDataBinder dataBinder){
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        format.setLenient(false);
//        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(format,false));
//    }

    @RequestMapping("/logs")
    @ResponseBody
    public List<AuditLog> findall(){
        return logService.findAll();
    }

    @RequestMapping("/findby")
    @ResponseBody
    public List<AuditLog> findby(HttpServletRequest request){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String lName=request.getParameter("lName");
        String lDept=request.getParameter("lDept");
        String lType=request.getParameter("lType");
        String lInfo=request.getParameter("lInfo");
        Date lTime= null;
        Date eTime=null;
        try {
            if(lTime!=null&&eTime!=null) {
                lTime = format.parse(request.getParameter("lTime"));
                eTime = format.parse(request.getParameter("eTime"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String lMk=request.getParameter("lMk");
        return logService.findSearch(lName,lDept,lType,lInfo,lTime,eTime,lMk);
    }
}
