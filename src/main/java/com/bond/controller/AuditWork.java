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
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AuditWork {
    @Autowired
    private AuditPlanService service;
    @RequestMapping("/proindex")
    public String proindex(){
        return "auditManager/index";
    }
    public String index(){
        return "auditManager/index";
    }
    /**
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "auditPlan")
    public String auditPlan(HttpSession session){
        List<AuditPlan> list=  service.selectAll();
        session.setAttribute("list1",list);
        return "auditWork/auditPlan";
    }

    /**
     * 所有审计计划
     * @return
     */
    @RequestMapping("selectAllAuditPlan")
    @ResponseBody
    public List<AuditPlan> selectAll(){
        List<AuditPlan> list=  service.selectAll();
        return list;
    }

    /**
     * 通过用户id查找用户名字
     * @param id
     * @return
     */
    @RequestMapping("selectnamebyuserid")
    @ResponseBody
    public String selectnamebyuserid(@RequestParam("id") Integer id){
        Optional<AuditUser> optionalAuditUser = service.selectbyid(id);
        String name =optionalAuditUser.get().getuUsername();
        return name;
    }

    /**
     * 通过审计计划id查找该审计计划下面的项目
     * @param pId
     * @return
     */
    @RequestMapping("selectbypId")
    @ResponseBody
    public Map<String, Object> selectbypId(@RequestParam("pId")Integer pId){
        List<AuditPlanproject> list = service.selectbypId(pId);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("list",list);
        return map;
    }

    /**
     * 通过审计计划类型查找审计计划
     * @param pnd
     * @return
     */
    @RequestMapping("selectbypnd")
    @ResponseBody
    public List<AuditPlan> selectByPnd(@RequestParam("pnd")String pnd){
        List<AuditPlan> list = service.findbypnd(pnd);
        return list;
    }

    /**
     * 添加审计计划
     * @param auditPlan
     * @return
     */
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
    /**
     * 双击计划跳到该计划下面的项目展示页面
     * @param pId
     * @param session
     * @return
     */
    @RequestMapping("auditplantoauditproject")
    public String to(@RequestParam("pId")Integer pId,HttpSession session){
        session.setAttribute("pId",pId);
        return "auditWork/auditplanpro";
    }

    /**
     * 通过计划id查到该计划下面的项目
     * @param pId
     * @return
     */
    @RequestMapping("selectprobypId")
    @ResponseBody
    public List<AuditPlanproject> selectprobypid(@RequestParam("pId")Integer pId){
        List<AuditPlanproject> list = service.selectbypId(pId);
        return list;
    }
    /**
     * 添加项目基本信息
     * @param ppid
     * @param ppname
     * @param pptype
     * @param ppaudited
     * @param starttime
     * @param endtime
     * @param ppjd
     * @param checkxiang
     * @return
     */
    @RequestMapping("addproject")
    @ResponseBody
    public boolean addproject(@RequestParam("ppid") Integer ppid, String ppname, String pptype, String ppaudited, String  starttime, String endtime, String ppjd, String checkxiang){
        boolean b = false;
        System.out.println(ppid);
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date startt = new Date();
        Date endt = new Date();
        try{
            startt = s.parse(starttime);
            endt = s.parse(endtime);
        }catch (ParseException e){
            e.printStackTrace();
        }
        AuditPlanproject a = new AuditPlanproject();
        a.setPpId(ppid);a.setPpName(ppname);a.setPpType(pptype);a.setPpAudited(ppaudited);a.setPpStarttime(startt);a.setPpEndstart(endt);a.setPpJd(ppjd);a.setPpCheck(checkxiang);
        AuditPlanproject auditPlanproject = service.addproject(a);
        return b;
    }
    @RequestMapping("/torole")
    public String roleassign(@RequestParam("ppid")Integer ppid,HttpSession session){
        Optional<AuditPlanproject> optional = service.selectprobyppid(ppid);//如果上面没有添加成功 那么这里就通过这个id查不到东西  所以会报错
        System.out.println(optional.get().getPpId());
        session.setAttribute("o",optional.get());
        return "auditWork/prorosalStage/roleAssign";
    }
    /**
     * 角色分配页面的项目显示
     * @param ppid
     * @return
     */
    @RequestMapping("feixianchang")
    @ResponseBody
    public AuditPlanproject rolefenpei(@RequestParam("ppid") Integer ppid){
        Optional<AuditPlanproject> optional = service.selectprobyppid(ppid);
        return optional.get();
    }

}
