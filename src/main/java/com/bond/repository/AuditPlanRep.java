package com.bond.repository;

import com.bond.bean.AuditPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuditPlanRep extends JpaRepository<AuditPlan,Integer> {
    @Query("select a from AuditPlan a where a.pNd = ?1")
    List<AuditPlan> findByPNd(String pnd);
}
