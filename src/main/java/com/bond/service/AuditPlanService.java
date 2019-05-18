package com.bond.service;

import com.bond.bean.AuditPlan;
import com.bond.bean.AuditPlanproject;
import com.bond.bean.AuditUser;
import com.bond.repository.AuditPlanRep;
import com.bond.repository.AuditPlanprojectRep;
import com.bond.repository.AuditUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    /**
     * 通过项目id查找项目
     * @return
     */
    public AuditPlanproject selectprobyppid(Integer ppid,String ppjd){
        return auditPlanprojectRep.findByPpIdAndPpJd(ppid,ppjd);
    }

    /**
     * 查找所有角色为审计人员的用户
     * @param role
     * @return
     */
    public List<AuditUser> selectuserbyrole(String role){
        return auditUserRep.findByURole(role);
    }

    public Optional<AuditPlanproject> selectbyppid(Integer ppid){
        return auditPlanprojectRep.findById(ppid);
    }
    @Transactional
    public AuditPlanproject addprorole(AuditPlanproject a){
        return auditPlanprojectRep.save(a);
    }
}
