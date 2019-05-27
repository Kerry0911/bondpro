package com.bond.repository;

import com.bond.bean.AuditUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuditUserRep extends JpaRepository<AuditUser,Integer> {

    public List<AuditUser> findByURole(String role);

    @Query(value ="select * from audit_user where audited_id=?1" ,nativeQuery = true)
    public List<AuditUser> findByIns_AuditedId(Integer auditedId);


}
