package com.bond.repository;

import com.bond.bean.AuditUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditUserRep extends JpaRepository<AuditUser,Integer> {
}
