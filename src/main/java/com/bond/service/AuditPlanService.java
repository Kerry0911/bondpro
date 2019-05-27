package com.bond.service;

import com.bond.bean.*;
import com.bond.repository.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuditPlanService {
    @Autowired
    private AuditPlanRep auditPlanRep;
    @Autowired
    private AuditUserRep auditUserRep;
    @Autowired
    private AuditPlanprojectRep auditPlanprojectRep;
    @Autowired
    private SystemconfigRep systemconfigRep;
    @Autowired
    private TaskRep taskRep;
    @Autowired
    private ProjectroleRep projectroleRep;

    /**
     * 查找所有的审计计划
     * @return
     */
    public List<AuditPlan> selectAll(){
        return auditPlanRep.findAll();
    }

    /**
     * 查找所有的审计计划项目
     * @return
     */
    public List<AuditPlanproject> select(){
        return auditPlanprojectRep.findAll();
    }

    /**
     * 通过用户id查找用户
     * @param id
     * @return
     */
    public Optional<AuditUser> selectbyid(Integer id){
        return auditUserRep.findById(id);
    }

    /**
     * 通过审计计划id查找该审计计划下面的项目
     * @param id
     * @return
     */
    public List<AuditPlanproject> selectbypId(Integer id){
        return auditPlanprojectRep.findByAuditPlan_pId(id);
    }

    /**
     * 查找所有的审计计划项目
     * @return
     */
    public List<AuditPlan> findAll(){
        return auditPlanRep.findAll();
    }

    /**
     * 通过计划年度查找计划
     * @param pnd
     * @return
     */
    public List<AuditPlan> findbypnd(String pnd){
        return auditPlanRep.findByPNd(pnd);
    }

    /**
     * 添加审计计划项目
     * @param auditPlan
     * @return
     */
    public AuditPlan addauditplan(AuditPlan auditPlan){
        return auditPlanRep.save(auditPlan);
    }

    /**
     * 添加项目
     * @param a
     * @return
     */
    public AuditPlanproject addproject(AuditPlanproject a){
        return auditPlanprojectRep.saveAndFlush(a);
    }
    public Projectrole addprojectrole(Projectrole projectrole){
        return projectroleRep.save(projectrole);
    }

    /**
     * 通过项目id和阶段查找项目
     * @return
     */
    public Projectrole selectprobyppid(Integer ppid,String ppjd){
        return projectroleRep.findByAuditPlanproject_ppIdAndJd(ppid,ppjd);
    }

    /**
     * 通过id查找项目
     * @param id
     * @return
     */
    public Optional<AuditPlanproject> selectbid(Integer id){
        return auditPlanprojectRep.findById(id);
    }
    /**
     * 查找所有角色为审计人员的用户
     * @param role
     * @return
     */
    public List<AuditUser> selectuserbyrole(String role){
        return auditUserRep.findByURole(role);
    }

//    public Projectrole selectprobyppid(Integer ppid){
//        return projectroleRep.findByAuditPlanproject_ppId(ppid);
//    }
    /**
     * 通过id查找项目角色
     */
    public Projectrole selectprolebyproleid(Integer id,String jd){
        return projectroleRep.findByIdAndJd(id,jd);
    }
    /**
     * 修改项目 给项目添加角色
     * @param a
     * @return
     */
    @Transactional
    public Projectrole addprorole(Projectrole a){
        //sava方法就是 如果传入进来的id在数据库里面存在了 那么就进行修改 如果传进来的没有存在 就增加
        return projectroleRep.save(a);
    }

    /**
     * 查找所有审计要点
     * @return
     */
    public List<Systemconfiguration> selectAll(String configcode){
        return systemconfigRep.findByConfigcode(configcode);
    }

    /**
     * 通过项目id查找项目
     * @param pid
     * @return
     */
    public List<Projectrole> selectbyproid(Integer pid){
        return projectroleRep.findByAuditPlanproject_PpId(pid);
    }

    /**
     * 模糊查询审计要点 直接在这里调用findall方法
     * @param configcode
     * @param configvalueid
     * @return
     */
    @SuppressWarnings("serial")
    public List<Systemconfiguration> selectbyauditp(String configcode,String configvalueid){
        List<Systemconfiguration> list = systemconfigRep.findAll(new Specification<Systemconfiguration>() {
            @Override
            public Predicate toPredicate(Root<Systemconfiguration> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(configcode)){
                    predicates.add(criteriaBuilder.like(root.<String>get("configcode"),"%"+configcode+"%"));
                }
                //如果传进来的这个不等于空 就拼接上这个进行查  如果等于空 就不拼接这个 就只通过上面那个查
                if (!StringUtils.isEmpty(configvalueid)){
                    predicates.add(criteriaBuilder.like(root.<String>get("configvalueid"),"%"+configvalueid+"%"));
                }
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        });
        List<Systemconfiguration> list1 = new ArrayList<>();
        for(Systemconfiguration s:list){//将查询出来的值循环
            Systemconfiguration sys = new Systemconfiguration();
            sys.setConfigcode(s.getConfigcode());
            sys.setConfigname(s.getConfigname());
            sys.setConfigvalueid(s.getConfigvalueid());
            sys.setConfigvaluename(s.getConfigvaluename());
            sys.setDescription(s.getDescription());
            sys.setId(s.getId());
            sys.setIsstart(s.getIsstart());
            list1.add(sys);
        }
        return list1;
    };

    /**
     * 通过时间查找项目 动态查询 通过传入的值判断哪些值是空哪些不是  然后只对不是空的值进行拼接查询
     * @param start
     * @param end
     * @return
     */
    @SuppressWarnings("serial")
    public List<AuditPlanproject> findProject(Date start,Date end){
        List<AuditPlanproject> list = auditPlanprojectRep.findAll(new Specification<AuditPlanproject>() {
            //这个方法就等于一个Predicate
            @Override
            public Predicate toPredicate(Root<AuditPlanproject> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                List<Predicate> predicates = new ArrayList<>();
                //拼接时间  通过传进来的两个时间 查找这两个时间里面的项目 如果为空 就不走这里 直接就查询全部
                if (!StringUtils.isEmpty(start) && !StringUtils.isEmpty(end)) {
                    predicates.add(criteriaBuilder.between(root.get("ppCreatedate"),start,end));
                }
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        });
        List<AuditPlanproject> auditPlanprojects = new ArrayList<>();
        for(AuditPlanproject a:list){
            AuditPlanproject auditpro = new AuditPlanproject();
            auditpro.setPpCheck(a.getPpCheck());
            auditpro.setPpJd(a.getPpJd());//指定项目是非现场阶段还是现场阶段
            auditpro.setPpEndstart(a.getPpEndstart());
            auditpro.setPpStarttime(a.getPpStarttime());
            auditpro.setPpName(a.getPpName());
            auditpro.setPpAudited(a.getPpAudited());
            auditpro.setPpType(a.getPpType());
            auditpro.setPpId(a.getPpId());
            auditpro.setAuditPlan(a.getAuditPlan());
            auditpro.setPpCreatedate(a.getPpCreatedate());
            auditpro.setPpCreatepeople(a.getPpCreatepeople());
            auditpro.setPpGeneratepeople(a.getPpGeneratepeople());
            auditpro.setPpJieduan(a.getPpJieduan());//指的是项目到了那个阶段
            auditpro.setPpSpecific(a.getPpSpecific());
            auditpro.setPpState(a.getPpState());
            auditPlanprojects.add(auditpro);
        }
        return auditPlanprojects;
    }

    /**
     * 添加审计项目人员任务
     * @param t
     * @return
     */
    public Task addrenwu(Task t){
        return taskRep.save(t);
    }
    public List<Task> selectTaskbyppid(Integer id){
        return taskRep.findByAuditPlanproject_PpId(id);
    }
}
