package com.bond.service;

import com.bond.bean.AuditPlan;
import com.bond.bean.AuditPlanproject;
import com.bond.bean.AuditUser;
import com.bond.repository.AuditPlanRep;
import com.bond.repository.AuditPlanprojectRep;
import com.bond.repository.AuditUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<AuditPlan> selectAll(){
        return auditPlanRep.findAll();
    }
    public List<AuditPlanproject> select(){
        return auditPlanprojectRep.findAll();
    }
    public Optional<AuditUser> selectbyid(Integer id){
        return auditUserRep.findById(id);
    }

    public List<AuditPlanproject> selectbypId(Integer id){
        return auditPlanprojectRep.findByAuditPlan_pId(id);
    }

    public List<AuditPlan> findAll(){
        return auditPlanRep.findAll();
    }

    public List<AuditPlan> findbypnd(String pnd){
        return auditPlanRep.findByPNd(pnd);
    }
    public AuditPlan addauditplan(AuditPlan auditPlan){
        return auditPlanRep.save(auditPlan);
    }
}
