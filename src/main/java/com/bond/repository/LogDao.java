package com.bond.repository;

import com.bond.bean.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LogDao extends JpaRepository<AuditLog,Integer>, JpaSpecificationExecutor<AuditLog> {


}
