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
import javax.servlet.http.HttpSession;
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

    //用户批量删除
    @RequestMapping("/delpiliang")
    @ResponseBody
    public void delpiliang(Integer [] uId){
        service1.delpiliang(uId);
    }

    //修改用户信息
    @RequestMapping("/upById")
    @ResponseBody
    public int upById(AuditUser auditUser){
        AuditUser user= service1.insert(auditUser);
        if (user!=null){
            return 1;
        }else{
            return 0;
        }
    }

    //修改用户状态
    @RequestMapping("/upByState")
    @ResponseBody
    public int upByState(AuditUser auUser,Integer uId){
        AuditUser a=service1.findOne(uId);
        String c= a.getState();
        System.out.println(c);
        if(c.equals("禁用")){
            a.setState("正常");
        }else {
            a.setState("禁用");
        }

        AuditUser user= service1.insert(a);
        if (user!=null){
            return 1;
        }else{
            return 0;
        }
    }

    //查询角色
    @RequestMapping("/rolemanage")
    public String rolemanage(Model model){
        List<Systemconfiguration> rolelist=service1.findByrole("role");
        model.addAttribute("rolelist",rolelist);
        return "auditManager/roleManage";
    }


    //根据角色查询用户
    @RequestMapping("/rolesshow")
    @ResponseBody
    public List<AuditUser> findByrole(String uRole){
        List<AuditUser> byroles=service1.findByroles(uRole);
        return byroles;
    }

    //增加角色
    @RequestMapping("/adduRole")
    @ResponseBody
    public void adduRole(String configvaluename,String description){
        Systemconfiguration syscon=new Systemconfiguration();
        syscon.setConfigvaluename(configvaluename);
        syscon.setDescription(description);
        syscon.setConfigcode("role");
        service1.adduRole(syscon);
    }

    //角色批量删除
    @RequestMapping("/delRolePiLiang")
    @ResponseBody
    public void delRolePiLiang(Integer [] id){
        service1.delRolePiLiang(id);
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


    //角色修改
    @RequestMapping("/upRole")
    @ResponseBody
    public void upRole(Systemconfiguration sys,Integer id){
        System.out.println(id);
        service1.upRole(sys);
    }

    @RequestMapping("/loginshow")
    public String loginshow(){
        return "login";
    }
    //登录
    @RequestMapping("/login")
    public String  login(String uUsercode, String uPassword, HttpSession session){
        System.out.println(uUsercode+"----------"+uPassword  );
        AuditUser user=service1.getUser(uUsercode,uPassword);
        if(user==null){
            session.setAttribute("a","用户名或密码错误");
        }
        if (user!=null&&!user.getState().equals("禁用")){
            session.setAttribute("a","登陆成功");
            session.setAttribute("users",user);
            if(user.getuRole().equals("审计人员")){
                return "";
            }else if(user.getuRole().equals("审计部总经理")){
                return "auditManager/index";
            }else if(user.getuRole().equals("系统初始化角色")){
                return "initialRoles/index";
            }
        }else{
            session.setAttribute("c","你的账号因涉嫌违规不可描述的事已被封号，请联系管理员解封");
        }
        return "redirect:loginshow";

    }
}
