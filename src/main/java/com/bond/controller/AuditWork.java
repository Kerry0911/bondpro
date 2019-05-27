package com.bond.controller;

import com.bond.bean.*;
import com.bond.service.AuditPlanService;
import org.apache.coyote.http11.HttpOutputBuffer;
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
    @RequestMapping("toauditScheme")
    public String toauditScheme(){
        return "auditWork/prorosalStage/auditScheme";
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
        if(ppjd.substring(ppjd.length()-1,ppjd.length()).equals(",")){//如果传过来的阶段后面有,那么就去掉
            ppjd = ppjd.substring(0,ppjd.length()-1);
        }
        if(ppjd.equals("仅非现场阶段,仅现场阶段")) {//他这里无论你怎么搞都是先添加非现场的
            String[] jd = ppjd.split(",");
            for (int i = 0; i < jd.length; i++) {
                AuditPlanproject a1 = new AuditPlanproject();
                a1.setPpId(ppid);
                Projectrole p = new Projectrole();
                p.setAuditPlanproject(a1);//第一步添加只需要一个项目id和阶段名称
                p.setJd(jd[i]);
                Projectrole projectrole = service.addprojectrole(p);
            }
        }else{//如果不是全选  那么你数据库里面就只会出现你指定阶段的人员角色配置
            AuditPlanproject a1 = new AuditPlanproject();
            a1.setPpId(ppid);
            Projectrole p = new Projectrole();
            p.setAuditPlanproject(a1);
            p.setJd(ppjd);
            Projectrole projectrole = service.addprojectrole(p);
        }
        return true;
    }
    @RequestMapping("/torole")
    public String roleassign(HttpSession session){
//        Optional<AuditPlanproject> optional = service.selectprobyppid(ppid);//如果上面没有添加成功 那么这里就通过这个id查不到东西  所以会报错
//        System.out.println(optional.get().getPpId());
//        session.setAttribute("o",optional.get());
        String role = "审计人员";
        List<AuditUser> user = service.selectuserbyrole(role);
        session.setAttribute("user",user);
        return "auditWork/prorosalStage/roleAssign";
    }
    /**
     * 角色分配页面的项目显示非现场的项目
     * @param ppid
     * @return
     */
    @RequestMapping("feixianchang")
    @ResponseBody
    public List<Projectrole> feixianchang(@RequestParam("ppid") Integer ppid,@RequestParam("ppjd")String ppjd){
        if(ppjd.substring(ppjd.length()-1,ppjd.length()).equals(",")){//如果传过来的阶段后面有,那么就去掉
            ppjd = ppjd.substring(0,ppjd.length()-1);
        }
        List<Projectrole> list = new ArrayList<Projectrole>();
        Projectrole optional = new Projectrole();
        //如果不是属于今非现场阶段  那么就不会从这个里面查  就算查也查不到数据 因为上面写了  如果不是全选的话   就只会添加指定阶段
        if(ppjd.equals("仅非现场阶段")||ppjd.equals("仅非现场阶段,仅现场阶段")){
            ppjd = "仅非现场阶段";
            optional = service.selectprobyppid(ppid,ppjd);
        }
        list.add(optional);
        return list;
    }
    /**
     * 角色分配页面的项目显示现场的项目
     * @param ppid
     * @return
     */
    @RequestMapping("xianchang")
    @ResponseBody
    public List<Projectrole> xianchang(@RequestParam("ppid") Integer ppid,@RequestParam("ppjd") String ppjd){
        if(ppjd.substring(ppjd.length()-1,ppjd.length()).equals(",")){//如果传过来的阶段后面有,那么就去掉
            ppjd = ppjd.substring(0,ppjd.length()-1);
        }
        List<Projectrole> list = new ArrayList<Projectrole>();
        Projectrole optional = new Projectrole();
        if(ppjd.equals("仅现场阶段")||ppjd.equals("仅非现场阶段,仅现场阶段")){
            ppjd="仅现场阶段";
            optional = service.selectprobyppid(ppid,ppjd);
        }
        list.add(optional);
        return list;
    }

    /**
     * 为项目添加角色
     * @param name
     * @param role
     * @param pqualification
     * @param ppid
     * @return
     */
    @RequestMapping("addrole")
    @ResponseBody
    public boolean addrole(@RequestParam("name") String [] name,@RequestParam("role") String [] role,@RequestParam("pqualification") String [] pqualification,@RequestParam("ppid") Integer ppid,@RequestParam("ppjd")String ppjd,@RequestParam("rid")Integer rid,@RequestParam("shifou")Integer shifou){
        boolean b = false;
        String zhushen = "";
        String zhushenrole = "";
        String zhushenpq = "";
        String zs = "";
        String zsrole = "";
        String zspq = "";
        for(int i=0;i<name.length;i++){
            if(role[i].equals("主审")){
                zhushen +=name[i]+",";
                zhushenrole = role[i];
                zhushenpq += pqualification[i]+"|";
            }
            if(role[i].equals("助审")){//如果我没有选择助审  那么是为空 所以都不符合这个条件 都不会进这个方法 zs zsrole zspq都会是没有值的
                zs +=name[i]+",";
                zsrole = role[i];
                zspq += pqualification[i]+"|";
            }
        }
        //如果这个字符串是，结尾 那么就不要这个， 这里是主审的人员 如果后面跟，  到时候在前台通过，分割的时候就会多出一列
        if(zhushen.substring(zhushen.length()-1,zhushen.length()).equals(",")){
            zhushen = zhushen.substring(0,zhushen.length()-1);
        }
        if(zhushenpq.substring(zhushenpq.length()-1,zhushenpq.length()).equals(",")){
            zhushenpq = zhushenpq.substring(0,zhushenpq.length()-1);
        }
        if(zspq.substring(zspq.length()-1,zspq.length()).equals(",")){
            zspq = zspq.substring(0,zspq.length()-1);
        }
        if(zs!=null&&zs!="") {
            if (zs.substring(zs.length() - 1, zs.length()).equals(",")) {
                zs = zs.substring(0, zs.length() - 1);
            }
        }
        if(shifou==0) {
            //通过项目角色id和项目阶段来查找   给对应的阶段分配角色 传进来的rid和ppjd会根据你选择的哪个阶段而不同
            Projectrole a = service.selectprolebyproleid(rid, ppjd);
            a.setZhushen(zhushen);
            a.setZhushenrole(zhushenrole);
            a.setZhushenpqualification(zhushenpq);
            a.setZs(zs);
            a.setZsrole(zsrole);
            a.setZspqualification(zspq);
            Projectrole projectrole = service.addprorole(a);
            if (projectrole != null) {
                b = true;
            }
        }
        if(shifou==1){
            Projectrole a = service.selectprolebyproleid(rid, ppjd);
            a.setZhushen(zhushen);
            a.setZhushenrole(zhushenrole);
            a.setZhushenpqualification(zhushenpq);
            a.setZs(zs);
            a.setZsrole(zsrole);
            a.setZspqualification(zspq);
            Projectrole projectrole = service.addprorole(a);
            Projectrole a1 = service.selectprolebyproleid(rid+1, "仅现场阶段");
            a1.setZhushen(zhushen);
            a1.setZhushenrole(zhushenrole);
            a1.setZhushenpqualification(zhushenpq);
            a1.setZs(zs);
            a1.setZsrole(zsrole);
            a1.setZspqualification(zspq);
            Projectrole projectrole1 = service.addprorole(a1);
            if (projectrole != null) {
                b = true;
            }
        }
        return b;
    }

    /**
     * 通过项目id查找项目
     * @param id
     * @return
     */
    @RequestMapping("feibyproppid")
    @ResponseBody
    public String feibyproppid(@RequestParam("id") Integer id){
        String jd = "仅非现场阶段";
        Projectrole p = service.selectprobyppid(id,jd);
        String pname =p.getAuditPlanproject().getPpName();
        return pname;
    }
    @RequestMapping("feibypppid")
    @ResponseBody
    public String feibypppid(@RequestParam("id") Integer id){
        String jd="仅非现场阶段";
        Projectrole p = service.selectprobyppid(id,jd);
        String pname =p.getAuditPlanproject().getPpAudited();
        return pname;
    }
    @RequestMapping("xbyproppid")
    @ResponseBody
    public String xbyproppid(@RequestParam("id") Integer id){
        String jd = "仅现场阶段";
        Projectrole p = service.selectprobyppid(id,jd);
        String pname =p.getAuditPlanproject().getPpName();
        return pname;
    }
    @RequestMapping("xbypppid")
    @ResponseBody
    public String xbypppid(@RequestParam("id") Integer id){
        String jd = "仅现场阶段";
        Projectrole p = service.selectprobyppid(id,jd);
        String pname =p.getAuditPlanproject().getPpAudited();
        return pname;
    }

    /**
     * 跳到任务分配
     * @param session
     * @return
     */
    @RequestMapping("/totask")
    public String totask(HttpSession session){
        String configcode = "Audit_points";
        List<Systemconfiguration> list = service.selectAll(configcode);
        List<AuditPlanproject> list1 = service.select();
        session.setAttribute("Auditpoints",list);
        session.setAttribute("auditpro",list1);
        return "auditWork/prorosalStage/taskAssign";
    }

    /**
     * 通过项目名称查项目
     * @param proid
     * @return
     */
    @RequestMapping("selectbyproid")
    @ResponseBody
    public String selectbyproname(@RequestParam("proid") Integer proid){
        System.out.println(proid);
        int is = 0;
        String name = "";
        List<Projectrole> list = service.selectbyproid(proid);
        String feiname =list.get(0).getZhushen()+","+list.get(0).getZs();//非现场阶段的人员的名字
        String xianname = list.get(1).getZhushen()+","+list.get(1).getZs();//现场阶段的人员的名字
        String[] fname = feiname.split(",");
        String[] xname = xianname.split(",");
        for(int i = 0;i< xname.length;i++){
            for(int j = 0;j<fname.length;j++){
                if(xname[i].equals(fname[j])){
                    is++;
                }
            }
            System.out.println(is);
            if(is==0){
                feiname +=","+xname[i];
            }
            System.out.println(feiname);
            is=0;
        }
        return feiname;
    }

    /**
     * 通过知识要点查
     * @param auditpoints
     * @return
     */
    @RequestMapping("selectbyauditpcode")
    @ResponseBody
    public List<Systemconfiguration> selectbyauditpcode(@RequestParam("auditpoints") String auditpoints){
        if(auditpoints.equals("")||auditpoints==null){
            auditpoints=null;
        }else {
            auditpoints = "%"+auditpoints+"%";
        }
        String configcode = "Audit_points";
        System.out.println(auditpoints);
        List<Systemconfiguration> list = service.selectbyauditp(configcode,auditpoints);
        return list;
    }

    /**
     * 通过时间查找项目
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping("selectbytime")
    @ResponseBody
    public List<AuditPlanproject> selectbytime(@RequestParam("starttime") String starttime, @RequestParam("endtime") String endtime){
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date start =null;
        Date end =null;
        try{
            if(!starttime.equals("")&&!endtime.equals("")) {
                System.out.println(starttime);
                System.out.println(endtime);
                start = s.parse(starttime);
                end = s.parse(endtime);
            }
        }catch (ParseException p){
            p.printStackTrace();
        }
        List<AuditPlanproject> list = service.findProject(start,end);
        return list;
    }

    /**
     * 项目人员分配任务
     * @param rw
     * @param people
     * @param ppid
     * @return
     */
    @RequestMapping("fenpeirenwu")
    @ResponseBody
    public boolean fenpeirenwu(@RequestParam("rw") String rw,@RequestParam("people") String people,@RequestParam("ppid")Integer ppid){
        boolean b = false;
        String [] a = rw.split("-");//将任务通过-分割 这样一搞 就把每个任务分开了
        for(int i = 0;i<a.length;i++) {
            String info =a[i].split(",")[0];//获得每个任务里面的审计要点
            String code =a[i].split(",")[1];//获得每个任务里面的审计编号  这些在前台拼接好了的
            AuditPlanproject auditp =new AuditPlanproject();
            auditp.setPpId(ppid);
            Task t = new Task();
            t.setAuditPlanproject(auditp);
            t.settAuditpoints(info);
            t.settCode(code);
            t.settName(people);
            t.settState("0");
            Task task = service.addrenwu(t);
            if(task!=null){
                b=true;
            }else{
                b=false;
            }
        }
        return b;
    }
    @RequestMapping("toauditscheme")
    public String toauditscheme(HttpSession session){
        Integer pp = 23671;
        Optional<AuditPlanproject> a =service.selectbid(pp);//通过项目id查到项目 可以直接在前台通过指定的变量点出项目所有属性
        List<Projectrole> p = service.selectbyproid(pp);
        List<Task> t = service.selectTaskbyppid(pp);
        session.setAttribute("a",a.get());
        session.setAttribute("p",p.get(0));//传过去的是一个对象 因为我在list里面拿到了第一个对象
        session.setAttribute("t",t);
        return "auditWork/prorosalStage/auditScheme";
    }
}
