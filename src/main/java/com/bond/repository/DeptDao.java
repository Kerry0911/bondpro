package com.bond.repository;

import com.bond.bean.AuditUser;
import com.bond.bean.Systemconfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeptDao extends JpaRepository<Systemconfiguration,Integer>,JpaSpecificationExecutor<Systemconfiguration> {
    //查询部门
    List<Systemconfiguration> findByConfigcode(String configcode);




 }
