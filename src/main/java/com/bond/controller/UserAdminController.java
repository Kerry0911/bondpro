package com.bond.controller;

import com.bond.bean.AuditAuditedInstitutions;
import com.bond.bean.AuditUser;
import com.bond.bean.Systemconfiguration;
import com.bond.repository.DeptDao;
import com.bond.service.AuditedService;
import com.bond.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserAdminController {

    @Autowired
    private UserAdminService service1=new UserAdminService();

    @Autowired
    private DeptDao dao1;

    @Resource
    private AuditedService auditedService=new AuditedService();


    //查询部门
    @RequestMapping("/useradmin")
    public String useradmin(Model model){
        List<Systemconfiguration> list1=service1.findBydept("system_dept");
        model.addAttribute("depts",list1);
        return "auditManager/auditUserAdministration";
    }

    //根据部门查询用户
    @RequestMapping("/usersshow")
    @ResponseBody
    public List<AuditUser> findByudept(@RequestParam("udept") String udpet){
        List<AuditUser> usersInfo=service1.findByUdept(udpet);
        return usersInfo;
    }

    //根据姓名模糊查询
    @RequestMapping("/nameshow")
    @ResponseBody
    public List<AuditUser> findByUUsernameLike(@RequestParam("username") String username){
        if(username==null||username.equals("")){
              username=null;
        }else{
            username="%"+username+"%";
        }
        List<AuditUser> uname=service1.findByUUsernameLike(username);
        return uname;
    }

   //添加用户
    @RequestMapping("/save")
    @ResponseBody
    public void save(String uCode,String uUsername,String uRole,String uDept,String uPost,String uPqualification,String uPassword){
        AuditUser auditUser=new AuditUser();
        auditUser.setuCode(uCode);
        auditUser.setuUsername(uUsername);
        auditUser.setuRole(uRole);
        auditUser.setuDept(uDept);
        auditUser.setuPost(uPost);
        auditUser.setuPqualification(uPqualification);
        auditUser.setuPassword(uPassword);
        service1.saveAll(auditUser);
    }

    //删除用户
    @RequestMapping("/delById")
    @ResponseBody
    public int deleteById(Integer uId){
        service1.deleteById(uId);
        return 1;
    }


    @RequestMapping("/addauser")
    @ResponseBody
    public int addauser(AuditUser auditUser){
        List<AuditUser> list=new ArrayList<>();
        AuditAuditedInstitutions institutions=new AuditAuditedInstitutions();
        list.add(auditUser);
        institutions.setUsers(list);
        AuditAuditedInstitutions a=auditedService.insert(institutions);
        if (a!=null){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("/editauser")
    @ResponseBody
    public int editauser(AuditUser auditUser){
        AuditUser user=service1.insert(auditUser);
        if (user!=null){
            return 1;
        }else{
            return 0;
        }
    }

    @RequestMapping("/allusers")
    @ResponseBody
    public List<AuditUser> findall(){
        return service1.findAll();
    }

    @RequestMapping("/resetpwd")
    @ResponseBody
    public int reset(Integer uid,String pwd){
        int i=service1.resetpwd(uid,pwd);
        return i;
    }

    @RequestMapping("/use")
    @ResponseBody
    public int use(Integer uId,String state){
        return service1.use(uId,state);
    }
}
