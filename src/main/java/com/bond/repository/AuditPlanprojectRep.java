package com.bond.repository;

import com.bond.bean.AuditPlan;
import com.bond.bean.AuditPlanproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AuditPlanprojectRep extends JpaRepository<AuditPlanproject,Integer> {
    //通过审计计划的id查到项目
    public List<AuditPlanproject> findByAuditPlan_pId(Integer pid);
//    @Query(value ="insert into AuditPlanproject(ppId,ppName,ppType,ppAudited,ppStarttime,ppEndstart,ppCheck,ppJd) values (?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery = true)
//    public AuditPlanproject insertpro(Integer ppId, String ppType, String ppAudited, Date ppStarttime,Date ppEndtime,String ppCheck,String ppJd);
    public AuditPlanproject findByPpIdAndPpJd(Integer ppid,String ppjd);
}
