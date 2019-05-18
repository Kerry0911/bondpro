package com.bond.repository;

import com.bond.bean.AuditUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditUserRep extends JpaRepository<AuditUser,Integer> {
    public List<AuditUser> findByURole(String role);
}
