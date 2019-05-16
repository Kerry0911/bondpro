package com.bond.repository;

import com.bond.bean.AuditSonattribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SonAttrDao extends JpaRepository<AuditSonattribute,Integer> {

    @Query(value = "select * from audit_sonattribute where a_id=?1",nativeQuery = true)
    public List<AuditSonattribute> findAuditSonattributesByAttribute(Integer aId);


}
