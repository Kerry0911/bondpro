package com.bond.repository;

import com.bond.bean.AuditAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface AttributeDao extends JpaRepository<AuditAttribute,Integer> {

    @Query(value = "select a.* from audit_attribute a group by a.a_name",nativeQuery = true)
    List<AuditAttribute> findAllType();

    @Query(value = "select a.* from audit_attribute a where a.`a_name`=?1",nativeQuery = true)
    public AuditAttribute findAuditAttributeByAName(String aName);
}
