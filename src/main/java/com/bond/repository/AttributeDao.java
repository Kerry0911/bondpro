package com.bond.repository;

import com.bond.bean.AuditAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
public interface AttributeDao extends JpaRepository<AuditAttribute,Integer> {

    @Query(value = "select a.* from audit_attribute a group by a.a_name",nativeQuery = true)
    List<AuditAttribute> findAllType();

    @Query(value = "select a.* from audit_attribute a where a.`a_name`=?1",nativeQuery = true)
    public AuditAttribute findAuditAttributeByAName(String aName);

    @Query(value ="select * from audit_attribute where model_id=?1" ,nativeQuery = true)
    public List<AuditAttribute> findbymodel(Integer modelId);

    @Transactional
    @Modifying
    @Query(value = "update audit_attribute set a_name=?1, a_type=?2,a_jurisdiction=?3 where a_id=?4",nativeQuery = true)
    public int updatepro(String aName,String aType,String aJurisdiction,Integer aId);
}
