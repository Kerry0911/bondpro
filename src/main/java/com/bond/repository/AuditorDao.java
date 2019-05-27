package com.bond.repository;

import com.bond.bean.AuditBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AuditorDao extends JpaRepository<AuditBody,String> {
    @Query(value = "select * from audit_body where ab_higher='0'",nativeQuery =true)
    public List<AuditBody> findpre();

    @Query(value = "select * from audit_body where ab_higher=?1",nativeQuery =true)
    public List<AuditBody> findson(String abHigher);

}
