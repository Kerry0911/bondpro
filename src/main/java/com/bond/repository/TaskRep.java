package com.bond.repository;

import com.bond.bean.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRep extends JpaRepository<Task,Integer> {
    public List<Task> findByAuditPlanproject_PpId(Integer id);
}
