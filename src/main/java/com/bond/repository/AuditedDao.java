package com.bond.repository;

import com.bond.bean.AuditAuditedInstitutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuditedDao  extends JpaRepository<AuditAuditedInstitutions,Integer>, JpaSpecificationExecutor<AuditAuditedInstitutions> {
    @Query(value = "select * from audit_audited_institutions where pre_id=0",nativeQuery = true)
    public List<AuditAuditedInstitutions> findall();

//    @Query(value = "select * from audit_audited_institutions where pre_id =?1",nativeQuery = true)
//    public List<AuditAuditedInstitutions> findson(Integer preId);

}
