package com.bond.controller;

import com.bond.bean.*;
import com.bond.service.AuditPlanService;
import com.sun.net.httpserver.HttpsConfigurator;
import org.apache.coyote.http11.HttpOutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AuditWork {
    @Autowired
    private AuditPlanService service;

    @RequestMapping("/proindex")
    public String proindex() {
        return "auditManager/index";
    }

    public String index() {
        return "auditManager/index";
    }

    @RequestMapping("toauditScheme")
    public String toauditScheme() {
        return "auditWork/prorosalStage/auditScheme";
    }

    /**
     * @param session
     * @return
     */
    @RequestMapping(value = "auditPlan")
    public String auditPlan(HttpSession session) {
        List<AuditPlan> list = service.selectAll();
        session.setAttribute("list1", list);
        return "auditWork/auditPlan";
    }

    /**
     * 所有审计计划
     *
     * @return
     */
    @RequestMapping("selectAllAuditPlan")
    @ResponseBody
    public List<AuditPlan> selectAll() {
        List<AuditPlan> list = service.selectAll();
        return list;
    }

    /**
     * 通过用户id查找用户名字
     *
     * @param id
     * @return
     */
    @RequestMapping("selectnamebyuserid")
    @ResponseBody
    public String selectnamebyuserid(@RequestParam("id") Integer id) {
        Optional<AuditUser> optionalAuditUser = service.selectbyid(id);
        String name = optionalAuditUser.get().getuUsername();
        return name;
    }

    /**
     * 通过审计计划id查找该审计计划下面的项目
     *
     * @param pId
     * @return
     */
    @RequestMapping("selectbypId")
    @ResponseBody
    public Map<String, Object> selectbypId(@RequestParam("pId") Integer pId) {
        List<AuditPlanproject> list = service.selectbypId(pId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        return map;
    }

    /**
     * 通过审计计划类型查找审计计划
     *
     * @param pnd
     * @return
     */
    @RequestMapping("selectbypnd")
    @ResponseBody
    public List<AuditPlan> selectByPnd(@RequestParam("pnd") String pnd) {
        List<AuditPlan> list = service.findbypnd(pnd);
        return list;
    }

    /**
     * 添加审计计划
     *
     * @param auditPlan
     * @return
     */
    @RequestMapping("addauditplan")
    @ResponseBody
    public boolean addauditplan(AuditPlan auditPlan) {
        boolean b = false;
        AuditPlan a = service.addauditplan(auditPlan);
        if (a != null) {
            b = true;
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
    public String to(@RequestParam("pId") Integer pId, HttpSession session) {
        session.setAttribute("pId", pId);
        return "auditWork/auditplanpro";
    }

    /**
     * 通过计划id查到该计划下面的项目
     *
     * @param pId
     * @return
     */
    @RequestMapping("selectprobypId")
    @ResponseBody
    public List<AuditPlanproject> selectprobypid(@RequestParam("pId") Integer pId) {
        List<AuditPlanproject> list = service.selectbypId(pId);
        return list;
    }

    /**
     * 添加项目基本信息
     *
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
    public boolean addproject(HttpSession session, @RequestParam("ppid") Integer ppid, String ppname, String pptype, String ppaudited, String starttime, String endtime, String ppjd, String checkxiang) {
        boolean b = false;
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date startt = new Date();//前端传来的时间用string接 然后在通过simpledateformat转为date  再添加到数据库
        Date endt = new Date();
        try {
            startt = s.parse(starttime);
            endt = s.parse(endtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        AuditUser auditUser = (AuditUser) session.getAttribute("users");//获得登录人的信息
        AuditPlanproject a = new AuditPlanproject();
        a.setPpId(ppid);
        a.setPpName(ppname);
        a.setPpType(pptype);
        a.setPpAudited(ppaudited);
        a.setPpStarttime(startt);
        a.setPpEndstart(endt);
        a.setPpJd(ppjd);
        a.setPpCheck(checkxiang);
        a.setPpState("编辑中");
        a.setPpJieduan("立项阶段");
        a.setPpCreatepeople(auditUser.getuUsername());
        a.setPpCreatedate(new Date());
        AuditPlanproject auditPlanproject = service.addproject(a);//返回刚刚添加的项目的内容
        session.setAttribute("auditPlanproject", auditPlanproject);
        if (ppjd.substring(ppjd.length() - 1, ppjd.length()).equals(",")) {//如果传过来的阶段后面有,那么就去掉
            ppjd = ppjd.substring(0, ppjd.length() - 1);
        }
        System.out.println(ppjd);
        if (ppjd.equals("仅非现场阶段,仅现场阶段")) {//他这里无论你怎么搞都是先添加非现场的
            String[] jd = ppjd.split(",");
            for (int i = 0; i < jd.length; i++) {
                System.out.println(jd[i]);
                AuditPlanproject a1 = new AuditPlanproject();
                a1.setPpId(ppid);
                Projectrole p = new Projectrole();
                p.setAuditPlanproject(a1);//第一步添加只需要一个项目id和阶段名称
                p.setJd(jd[i]);
                Projectrole projectrole = service.addprojectrole(p);
            }
        } else {//如果不是全选  那么你数据库里面就只会出现你指定阶段的人员角色配置
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
    public String roleassign(HttpSession session) {
//        Optional<AuditPlanproject> optional = service.selectprobyppid(ppid);//如果上面没有添加成功 那么这里就通过这个id查不到东西  所以会报错
//        System.out.println(optional.get().getPpId());
//        session.setAttribute("o",optional.get());
        String role = "审计人员";
        List<AuditUser> user = service.selectuserbyrole(role);
        session.setAttribute("user", user);
        return "auditWork/prorosalStage/roleAssign";
    }
    @RequestMapping("/torole1")
    public String roleassign1(HttpSession session,@RequestParam("ppid")Integer ppid,@RequestParam("ppjd")String ppjd) {
        String role = "审计人员";
        List<AuditUser> user = service.selectuserbyrole(role);
        session.setAttribute("user", user);
        session.setAttribute("ppid",ppid);
        session.setAttribute("ppjd",ppjd);
        return "auditWork/prorosalStage/roleAssign1";
    }

    /**
     * 角色分配页面的项目显示非现场的项目
     *
     * @param ppid
     * @return
     */
    @RequestMapping("feixianchang")
    @ResponseBody
    public List<Projectrole> feixianchang(@RequestParam("ppid") Integer ppid, @RequestParam("ppjd") String ppjd) {
        System.out.println(ppjd);
        if (ppjd.substring(ppjd.length() - 1, ppjd.length()).equals(",")) {//如果传过来的阶段后面有,那么就去掉
            ppjd = ppjd.substring(0, ppjd.length() - 1);
        }
        List<Projectrole> list = new ArrayList<Projectrole>();
        Projectrole optional = new Projectrole();
        //如果不是属于今非现场阶段  那么就不会从这个里面查  就算查也查不到数据 因为上面写了  如果不是全选的话   就只会添加指定阶段
        if (ppjd.equals("仅非现场阶段") || ppjd.equals("仅非现场阶段,仅现场阶段")) {
            ppjd = "仅非现场阶段";
            optional = service.selectprobyppid(ppid, ppjd);
        }
        list.add(optional);
        return list;
    }

    /**
     * 角色分配页面的项目显示现场的项目
     *
     * @param ppid
     * @return
     */
    @RequestMapping("xianchang")
    @ResponseBody
    public List<Projectrole> xianchang(@RequestParam("ppid") Integer ppid, @RequestParam("ppjd") String ppjd) {
        if (ppjd.substring(ppjd.length() - 1, ppjd.length()).equals(",")) {//如果传过来的阶段后面有,那么就去掉
            ppjd = ppjd.substring(0, ppjd.length() - 1);
        }
        List<Projectrole> list = new ArrayList<Projectrole>();
        Projectrole optional = new Projectrole();
        if (ppjd.equals("仅现场阶段") || ppjd.equals("仅非现场阶段,仅现场阶段")) {
            ppjd = "仅现场阶段";
            optional = service.selectprobyppid(ppid, ppjd);
        }
        list.add(optional);
        return list;
    }

    /**
     * 为项目添加角色
     *
     * @param name
     * @param role
     * @param pqualification
     * @param ppid
     * @return
     */
    @RequestMapping("addrole")
    @ResponseBody
    public boolean addrole(@RequestParam("name") String[] name, @RequestParam("role") String[] role, @RequestParam("pqualification") String[] pqualification, @RequestParam("ppid") Integer ppid, @RequestParam("ppjd") String ppjd, @RequestParam("rid") Integer rid, @RequestParam("shifou") Integer shifou) {
        boolean b = false;
        String zhushen = "";
        String zhushenrole = "";
        String zhushenpq = "";
        String zs = "";
        String zsrole = "";
        String zspq = "";
        for (int i = 0; i < name.length; i++) {
            if (role[i].equals("主审")) {
                zhushen += name[i] + ",";
                zhushenrole = role[i];
                zhushenpq += pqualification[i] + "|";
            }
            if (role[i].equals("助审")) {//如果我没有选择助审  那么是为空 所以都不符合这个条件 都不会进这个方法 zs zsrole zspq都会是没有值的
                zs += name[i] + ",";
                zsrole = role[i];
                zspq += pqualification[i] + "|";
            }
        }
        //如果这个字符串是，结尾 那么就不要这个， 这里是主审的人员 如果后面跟，  到时候在前台通过，分割的时候就会多出一列
        if (zhushen.substring(zhushen.length() - 1, zhushen.length()).equals(",")) {
            zhushen = zhushen.substring(0, zhushen.length() - 1);
        }
        if (zhushenpq.substring(zhushenpq.length() - 1, zhushenpq.length()).equals(",")) {
            zhushenpq = zhushenpq.substring(0, zhushenpq.length() - 1);
        }
        if (zspq != null && zspq != "") {//如果这个助审的资质为空就表示我没有选择助审  所以就不需要进行这个去后面尾部多余符号的语句 你都没有资质你还进行这个处理干啥 都是空的 就没必要处理
            if (zspq.substring(zspq.length() - 1, zspq.length()).equals(",")) {
                zspq = zspq.substring(0, zspq.length() - 1);
            }
        }
        if (zs != null && zs != "") {
            if (zs.substring(zs.length() - 1, zs.length()).equals(",")) {
                zs = zs.substring(0, zs.length() - 1);
            }
        }
        if (shifou == 0) {
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
        if (shifou == 1) {//这里是两个阶段的都一起进行修改
            Projectrole a = service.selectprolebyproleid(rid, ppjd);
            a.setZhushen(zhushen);
            a.setZhushenrole(zhushenrole);
            a.setZhushenpqualification(zhushenpq);
            a.setZs(zs);
            a.setZsrole(zsrole);
            a.setZspqualification(zspq);
            Projectrole projectrole = service.addprorole(a);
            //如果那边只选择非现场阶段 那么添加的时候前面在角色里面就会只添加非现场阶段的数据 如果一起修改的话会导致查不到现场阶段的数据 就会报错
            // 因为根本没添加进现场阶段的角色数据 所以数据库里面根本就没有这一个数据  所以导致查不到 就会报错
            Projectrole a1 = service.selectprolebyproleid(rid + 1, "仅现场阶段");
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
     *
     * @param id
     * @return
     */
    @RequestMapping("feibyproppid")
    @ResponseBody
    public String feibyproppid(@RequestParam("id") Integer id) {
        String jd = "仅非现场阶段";
        Projectrole p = service.selectprobyppid(id, jd);
        String pname = p.getAuditPlanproject().getPpName();
        return pname;
    }

    @RequestMapping("feibypppid")
    @ResponseBody
    public String feibypppid(@RequestParam("id") Integer id) {
        String jd = "仅非现场阶段";
        Projectrole p = service.selectprobyppid(id, jd);
        String pname = p.getAuditPlanproject().getPpAudited();
        return pname;
    }

    @RequestMapping("xbyproppid")
    @ResponseBody
    public String xbyproppid(@RequestParam("id") Integer id) {
        String jd = "仅现场阶段";
        Projectrole p = service.selectprobyppid(id, jd);
        String pname = p.getAuditPlanproject().getPpName();
        return pname;
    }

    @RequestMapping("xbypppid")
    @ResponseBody
    public String xbypppid(@RequestParam("id") Integer id) {
        String jd = "仅现场阶段";
        Projectrole p = service.selectprobyppid(id, jd);
        String pname = p.getAuditPlanproject().getPpAudited();
        return pname;
    }

    /**
     * 跳到任务分配
     *
     * @param session
     * @return
     */
    @RequestMapping("/totask")
    public String totask(HttpSession session) {
        String configcode = "Audit_points";
        List<Systemconfiguration> list = service.selectAll(configcode);
        List<AuditPlanproject> list1 = service.select();
        session.setAttribute("Auditpoints", list);
        session.setAttribute("auditpro", list1);
        return "auditWork/prorosalStage/taskAssign";
    }
    @RequestMapping("/totask1")
    public String totask1(HttpSession session) {
        String configcode = "Audit_points";
        List<Systemconfiguration> list = service.selectAll(configcode);
        List<AuditPlanproject> list1 = service.select();
        session.setAttribute("Auditpoints", list);
        session.setAttribute("auditpro", list1);
        return "auditWork/prorosalStage/taskAssign1";
    }

    /**
     * 通过项目名称查项目
     *
     * @param proid
     * @return
     */
    @RequestMapping("selectbyproid")
    @ResponseBody
    public String selectbyproname(@RequestParam("proid") Integer proid) {
        int is = 0;
        String feiname = "";
        String xianname = "";
        List<Projectrole> list = service.selectbyproid(proid);//在项目角色里面通过项目id查找
        if(list.size()>=2) {//如果等于二就表示这个项目有两个阶段  那么就要在这两个阶段中对人员进行去重 如果不等于二就不走这里 就不会报list[1]为null
            feiname = list.get(0).getZhushen() + "," + list.get(0).getZs();//非现场阶段的人员的名字
            xianname = list.get(1).getZhushen() + "," + list.get(1).getZs();//现场阶段的人员的名字
            String[] fname = feiname.split(",");
            String[] xname = xianname.split(",");
            for (int i = 0; i < xname.length; i++) {
                for (int j = 0; j < fname.length; j++) {
                    if (xname[i].equals(fname[j])) {
                        is++;
                    }
                }
                if (is == 0) {
                    feiname += "," + xname[i];
                }
                is = 0;
            }
        }
        if(list.size()==1){//如果等于1就表示没有两个阶段
            feiname = list.get(0).getZhushen() + "," + list.get(0).getZs();//非现场阶段的人员的名字
        }
        return feiname;
    }

    /**
     * 通过知识要点查
     *
     * @param auditpoints
     * @return
     */
    @RequestMapping("selectbyauditpcode")
    @ResponseBody
    public List<Systemconfiguration> selectbyauditpcode(@RequestParam("auditpoints") String auditpoints) {
        if (auditpoints.equals("") || auditpoints == null) {
            auditpoints = null;
        } else {
            auditpoints = "%" + auditpoints + "%";
        }
        String configcode = "Audit_points";
        List<Systemconfiguration> list = service.selectbyauditp(configcode, auditpoints);
        return list;
    }

    /**
     * 通过时间查找项目
     *
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping("selectbytime")
    @ResponseBody
    public List<AuditPlanproject> selectbytime(@RequestParam("starttime") String starttime, @RequestParam("endtime") String endtime) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            if (!starttime.equals("") && !endtime.equals("")) {
                start = s.parse(starttime);
                end = s.parse(endtime);
            }
        } catch (ParseException p) {
            p.printStackTrace();
        }
        List<AuditPlanproject> list = service.findProject(start, end);
        return list;
    }

    /**
     * 项目人员分配任务
     *
     * @param rw
     * @param people
     * @param ppid
     * @return
     */
    @RequestMapping("fenpeirenwu")
    @ResponseBody
    public boolean fenpeirenwu(@RequestParam("rw") String rw, @RequestParam("people") String people, @RequestParam("ppid") Integer ppid) {
        boolean b = false;
        String[] a = rw.split("-");//将任务通过-分割 这样一搞 就把每个任务分开了
        for (int i = 0; i < a.length; i++) {
            String info = a[i].split(",")[0];//获得每个任务里面的审计要点
            String code = a[i].split(",")[1];//获得每个任务里面的审计编号  这些在前台拼接好了的
            AuditPlanproject auditp = new AuditPlanproject();
            auditp.setPpId(ppid);
            Task t = new Task();
            t.setAuditPlanproject(auditp);
            t.settAuditpoints(info);
            t.settCode(code);
            t.settName(people);
            t.settState("开展中");
            Task task = service.addrenwu(t);
            if (task != null) {
                b = true;
            } else {
                b = false;
            }
        }
        return b;
    }
    @RequestMapping("fenpeirenwu1")
    @ResponseBody
    public boolean fenpeirenwu1(@RequestParam("rw") String rw, @RequestParam("people") String people, @RequestParam("ppid") Integer ppid) {
        boolean b = false;
        Task task = service.selectrenwubyppidandp(ppid,people);//通过人和项目id找到我现在正在修改的对象
        String[] a = rw.split("-");//将任务通过-分割 这样一搞 就把每个任务分开了
        for (int i = 0; i < a.length; i++) {
            String info = a[i].split(",")[0];//获得每个任务里面的审计要点
            String code = a[i].split(",")[1];//获得每个任务里面的审计编号  这些在前台拼接好了的
            AuditPlanproject auditp = new AuditPlanproject();
            auditp.setPpId(ppid);
            task.setAuditPlanproject(auditp);
            task.settAuditpoints(info);
            task.settCode(code);
            task.settName(people);
            task.settState("开展中");
            Task t = service.addrenwu(task);
            if (t != null) {
                b = true;
            } else {
                b = false;
            }
        }
        return b;
    }

    /**
     * 跳转到审计方案
     *
     * @param session
     * @return
     */
    @RequestMapping("toauditscheme")
    public String toauditscheme(HttpSession session, @RequestParam("id") Integer id) {
        Optional<AuditPlanproject> a = service.selectbid(id);//通过项目id查到项目 可以直接在前台通过指定的变量点出项目所有属性
        List<Projectrole> p = service.selectbyproid(id);
        List<Task> t = service.selectTaskbyppid(id);
        session.setAttribute("a", a.get());//传过去现在的项目
        session.setAttribute("p", p.get(0));//传过去的是一个对象 因为我在list里面拿到了第一个对象
        session.setAttribute("t", t);
        return "auditWork/prorosalStage/auditScheme";
    }
    @RequestMapping("toauditscheme1")
    public String toauditscheme1(HttpSession session, @RequestParam("id") Integer id) {
        Optional<AuditPlanproject> a = service.selectbid(id);//通过项目id查到项目 可以直接在前台通过指定的变量点出项目所有属性
        List<Projectrole> p = service.selectbyproid(id);
        List<Task> t = service.selectTaskbyppid(id);
        session.setAttribute("a", a.get());//传过去现在的项目
        session.setAttribute("p", p.get(0));//传过去的是一个对象 因为我在list里面拿到了第一个对象
        session.setAttribute("t", t);
        return "auditWork/prorosalStage/auditScheme1";
    }

    /**
     * 保存审计方案
     *
     * @param id
     * @param des
     * @return
     */
    @RequestMapping("savafangan")
    @ResponseBody
    public AuditFangan savafangan(@RequestParam("id") Integer id, @RequestParam("des") String des) {//得到项目id
        boolean b = false;
        AuditFangan fangan = new AuditFangan();
        AuditPlanproject a = new AuditPlanproject();
        a.setPpId(id);
        fangan.setAuditPlanproject(a);
        fangan.setfDes(des);
        AuditFangan auditFangan = service.addfangan(fangan);//将刚刚添加的方案返回给页面 然后在传到后台来将这个方案提交审核
        return auditFangan;
    }

    /**
     * 提交审核 添加待审
     *
     * @param id
     * @return
     */
    @RequestMapping("tijiaoshenhe")
    @ResponseBody
    public boolean tijiaoshenhe(@RequestParam("fanganid") Integer id, @RequestParam("sendpeople") String sendpeople) {//传来的是方案id
        Date d = new Date();
        AuditFangan fangan = new AuditFangan();
        String daibantype = "项目方案审计";
        Date sendtime = d;
        Integer fid = id;
        String state = "审核中";
        fangan.setfId(fid);
        Daibanthing daibanthing = new Daibanthing();
        daibanthing.setdSendpeople(sendpeople);
        daibanthing.setdSendtime(sendtime);
        daibanthing.setdType(daibantype);
        daibanthing.setAuditFangan(fangan);
        daibanthing.setState(state);
        Daibanthing daibanthing1 = service.adddaiban(daibanthing);//添加完了的待办事项  返回的就是刚刚添加的代办事项的内容
        Officialdraft o = new Officialdraft();
        String jieshoupeople = "经理";
        o.setDaibanthing(daibanthing1);//直接把这个待办事项的内容添加到off里面 这个里面是有这个待办事项的id的
        o.setoJieshoudept(jieshoupeople);
        o.setState(0);
        Officialdraft officialdraft = service.addoff(o);
        boolean b = false;
        if (daibanthing1 != null) {
            b = true;
        }
        return b;
    }

    /**
     * 进场会
     *
     * @param session
     * @return
     */
    @RequestMapping("toinmeeting")
    public String toxianchangres(HttpSession session) {
        AuditPlanproject a = (AuditPlanproject) session.getAttribute("auditPlanproject");
        Integer id = a.getPpId();
        List<Projectfile> projectfiles = service.selectprojectfilebyppid(id);
        Optional<AuditPlanproject> optionalAuditPlanproject = service.selectbid(id);
        session.setAttribute("optionalAuditPlanproject", optionalAuditPlanproject.get());
        session.setAttribute("projectfiles", projectfiles);
        return "auditWork/insite/inmeeting";
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public Projectfile upload(HttpSession session, @RequestParam("fileinfo") MultipartFile file) {
        AuditPlanproject a = (AuditPlanproject) session.getAttribute("auditPlanproject");
        Projectfile projectfile = service.uploadfile(file, a.getPpId());
        return projectfile;
    }

    /**
     * 这里只是通过ajax传过来文件id  然后查到文件 再传到页面进行操作
     *
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("xiazaifile")
    @ResponseBody
    public Projectfile xiazai(@RequestParam("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
        Optional<Projectfile> projectfile = service.selectbyfileid(id);
        File file = new File(projectfile.get().getFilelujing());//意思是从这个路径里面下载文件
        return projectfile.get();
    }

    /**
     * 在页面通过form表单下载  传路径过来
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("xiazai")
    @ResponseBody
    public String xz(HttpServletRequest request, HttpServletResponse response) {
        String lujing = request.getParameter("filelujing");
        File file = new File(lujing);//意思是从这个路径里面下载文件
//        File file = new File(realPath , fileName);
        if (file.exists()) {
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("multipart/form-data");
//            response.setHeader("Content-Disposition",
//                    "attachment;fileName="+URLEncoder.encode(fileName, "UTF-8"));
            try {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(lujing, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }

    /**
     * 删除文件
     */
    @RequestMapping("del")
    @ResponseBody
    public List<Projectfile> delete(@RequestParam("id") Integer id) {
        service.delete(id);
        List<Projectfile> projectfiles = service.selectAllprojectfile();
        return projectfiles;
    }

    /**
     * 跳转到数据抽取
     */
    @RequestMapping("chouqu")
    @ResponseBody
    public List<Task> dataget(HttpSession session) {
        AuditPlanproject a = (AuditPlanproject) session.getAttribute("auditPlanproject");
        Integer id = a.getPpId();
        List<Task> tasks = service.selectTaskbyppid(id);
        return tasks;
    }

    @RequestMapping("sousuobycodeandaudit")
    @ResponseBody
    public List<Task> sousuobycodeandaudit(HttpSession session, @RequestParam("tauditpoints") String tauditpoints, @RequestParam("tcode") String tcode) {
        AuditPlanproject a = (AuditPlanproject) session.getAttribute("auditPlanproject");
        Integer id = a.getPpId();
        AuditPlanproject aa = new AuditPlanproject();
        aa.setPpId(id);
        if (tcode.equals("") || tcode == null) {
            tcode = null;
        } else {
            tcode = "%" + tcode + "%";
        }
        if (tauditpoints.equals("") || tauditpoints == null) {
            tauditpoints = null;
        } else {
            tauditpoints = "%" + tauditpoints + "%";
        }
        List<Task> tasks = service.selecttaskbycodeandauditpoints(tcode, tauditpoints, aa);
        return tasks;
    }

    @RequestMapping("chongzuo")
    @ResponseBody
    public Task chongzuo(HttpSession session, @RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("tAuditpoints") String tAuditpoints, @RequestParam("tCode") String tcode) {
        AuditPlanproject a = (AuditPlanproject) session.getAttribute("auditPlanproject");
        Integer idd = a.getPpId();
        AuditPlanproject aa = new AuditPlanproject();
        aa.setPpId(idd);
        Task t = new Task();
        t.settId(id);
        t.settState("重做中");
        t.settName(name);
        t.settCode(tcode);
        t.settAuditpoints(tAuditpoints);
        t.setAuditPlanproject(aa);
        Task task = service.addrenwu(t);
        return task;
    }
    @RequestMapping("toauditp")
    public String to(HttpSession session){
        String role = "审计人员";
        List<AuditUser> auditUsers = service.selectuserbyrole(role);
        session.setAttribute("auditUsers",auditUsers);
        return "auditWork/auditPro";
    }
    /**
     * 进入审计项目管理后datagrid查询数据
     * @param session
     * @return
     */
        @RequestMapping("toauditpro")
        @ResponseBody
        public List<AuditPlanproject> auditpro(HttpSession session){
            AuditPlanproject a = (AuditPlanproject)session.getAttribute("auditPlanproject");
            List<AuditPlanproject> auditPlanprojectsall = service.select();
            return auditPlanprojectsall;
        }

        /**
         * 通过项目id查找角色查找主审角色
         * @param id
         * @return
         */
        @RequestMapping("findzhushenrole")
        @ResponseBody
        public String findzhushenrole(@RequestParam("id")Integer id){
            List<Projectrole> projectroles= service.selectbyproid(id);
            String zhushen = projectroles.get(0).getZhushen();
            return zhushen;
        }
        @RequestMapping("sousuopro")
        @ResponseBody
        public List<AuditPlanproject> sousoupro(@RequestParam("id")Integer id,@RequestParam("name")String name,@RequestParam("createpeople")String createpeople,@RequestParam("type")String type,@RequestParam("state")String state){
            System.out.println(name);
            if (name.equals("") || name == null) {
                name = null;
            } else {
                name = "%" + name + "%";
            }
            if (createpeople.equals("") || createpeople == null) {
                createpeople = null;
            } else {
                createpeople = "%" + createpeople + "%";
            }
            if (type.equals("") || type == null) {
                type = null;
            } else {
                type = "%" + type + "%";
            }
            if (state.equals("") || state == null) {
                state = null;
            } else {
                state = "%" + state + "%";
            }
            List<AuditPlanproject> auditPlanprojects = service.selectbyfive(id,name,createpeople,type,state);//动态查询之后 返回的内容
            return auditPlanprojects;
        }
}
