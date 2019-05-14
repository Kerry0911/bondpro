package com.bond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("/todolist")
    public String todolist(){return "todoList"; }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/worklog")
    public String worklog(){
        return "workLog";
    }

    @RequestMapping("/auditlib")
    public String auditlib(){
        return "auditLib";
    }

    @RequestMapping("/processdefine")
    public String processdefine(){
        return "processDefine";
    }


    /**
     * 领导工作台
     * @return
     */
    @RequestMapping("/persontask")
    public String persontask(){return "leadWorkbench/personTask"; }

    @RequestMapping("/proprocess")
    public String proprocess(){return "leadWorkbench/proProcess"; }


    /**
     * 总经理
     * @return
     */
    @RequestMapping("/auditedmanager")
    public String manager(){
        return "auditManager/auditedManage";
    }

    @RequestMapping("/useradmin")
    public String useradmin(){
        return "auditManager/auditUserAdministration";
    }

    @RequestMapping("/managerindex")
    public String index(){
        return "auditManager/index";
    }

    @RequestMapping("/protype")
    public String protype(){
        return "auditManager/proType";
    }

    @RequestMapping("/oplog")
    public String oplog(){
        return "auditManager/opLog";
    }

    @RequestMapping("/auditormanage")
    public String auditormanage(){
        return "auditManager/auditorManage";
    }


    /**
     * 初始角色
     * @return
     */
    @RequestMapping("/roleindex")
    public String roleindex(){
        return "initialRoles/index";
    }

    @RequestMapping("/propertymanage")
    public String propertymanage(){
        return "initialRoles/propertyManage";
    }

    @RequestMapping("/propertyset")
    public String propertyset(){
        return "initialRoles/propertySet";
    }


    @RequestMapping("/viewindex")
    public String viewindex(){ return "projectViewer/index"; }


    /**
     * 审计人员
     * auditors
     * @return
     */
    @RequestMapping("/auditorindex")
    public String auditorindex(){ return "auditors/index"; }


    /**
     * 工作台
     * workbench
     * @return
     */
    @RequestMapping("/approved")
    public String approved1(){ return "workbench/approved";
    }

    @RequestMapping("/message")
    public String mynews(){ return "workbench/message"; }

    @RequestMapping("/directory")
    public String myfolder(){ return "workbench/directory"; }



    @RequestMapping("/auditplan")
    public String auditplan(){
        return "auditWork/auditPlan";
    }

    @RequestMapping("/auditpro")
    public String auditpro(){
        return "auditWork/auditPro";
    }
    /**
     * 非现场检查
     * offsite
     * @return
     */
    @RequestMapping("/dataget")
    public String dataget(){ return "auditWork/offsite/dataget"; }

    @RequestMapping("/doublelib")
    public String doublelib(){ return "auditWork/offsite/doubleLib"; }

    @RequestMapping("/result")
    public String result(){ return "auditWork/offsite/result"; }

    @RequestMapping("/result1")
    public String result1(){ return "auditWork/offsite/result1"; }


    /**
     * 现场检查
     * insite
     * @return
     */

    @RequestMapping("/inmeeting")
    public String inmeeting(){ return "auditWork/insite/inmeeting"; }

    @RequestMapping("/list")
    public String list(){ return "auditWork/insite/list"; }

    @RequestMapping("/outmeeting")
    public String outmeeting(){ return "auditWork/insite/outmeeting"; }

    @RequestMapping("/insiteresult")
    public String insiteresult(){ return "auditWork/insite/result"; }

    @RequestMapping("/riskmatrix")
    public String riskmatrix(){ return "auditWork/insite/riskMatrix"; }

    @RequestMapping("/score")
    public String score(){ return "auditWork/insite/score"; }

    /**
     * 立项阶段
     * prorosalstage
     * @return
     */
    @RequestMapping("/proinfo")
    public String proinfo(){
        return "auditWork/prorosalStage/proInfo";
    }
    @RequestMapping("/auditscheme")
    public String auditscheme(){
        return "auditWork/prorosalStage/auditScheme";
    }

    @RequestMapping("/roleassign")
    public String roleassign(){
        return "auditWork/prorosalStage/roleAssign";
    }

    @RequestMapping("/taskassign")
    public String taskassign(){
        return "auditWork/prorosalStage/taskAssign";
    }


    /**
     * 结束阶段
     * @return
     */
    @RequestMapping("/changelist")
    public String changelist(){
        return "auditWork/end/changeList";
    }

    @RequestMapping("/fordraft")
    public String fordraft(){
        return "auditWork/end/forDraft";
    }

    @RequestMapping("/manuscript")
    public String manuscript(){
        return "auditWork/end/manuscript";
    }

    @RequestMapping("/officialdraft")
    public String officialdraft(){
        return "auditWork/end/officialDraft";
    }

    @RequestMapping("/profile")
    public String profile(){
        return "auditWork/end/profile";
    }
}
