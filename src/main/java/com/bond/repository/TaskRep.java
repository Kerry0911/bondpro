package com.bond.repository;

import com.bond.bean.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRep extends JpaRepository<Task,Integer>, JpaSpecificationExecutor<Task> {
    public List<Task> findByAuditPlanproject_PpId(Integer id);

    @Query(value = "select a.*,b.* from task a,audit_planproject b where a.pp_id=?1 and b.pp_state='0'",nativeQuery = true)
    public List<Task> findByPp(String ppId);
    public Task findByAuditPlanproject_PpIdAndTName(Integer ppid,String tname);

    //public List<Task> findTaskByTIdAndTAuditpoints(Integer tId,String tAuditpoints);
}
