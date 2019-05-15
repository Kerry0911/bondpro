package com.bond.repository;

import com.bond.bean.AuditPlan;
import com.bond.bean.AuditPlanproject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditPlanprojectRep extends JpaRepository<AuditPlanproject,Integer> {
    //通过审计计划的ia查到项目
    public List<AuditPlanproject> findByAuditPlan_pId(Integer pid);
 }
