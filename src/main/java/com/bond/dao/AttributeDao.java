package com.bond.dao;

import com.bond.bean.AuditAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface AttributeDao extends JpaRepository<AuditAttribute,Integer> {
    List<AuditAttribute> findAllByAId(Integer aId);

    @Query(value = "select * from audit_attribute where a_name=?1",nativeQuery = true)
    public List<AuditAttribute> findAuditAttributeByAName(String aName);
}
