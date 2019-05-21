package com.bond.repository;

import com.bond.bean.AuditSonattribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SonAttrDao extends JpaRepository<AuditSonattribute,Integer> {

    @Query(value = "select * from audit_sonattribute where a_id=?1",nativeQuery = true)
    public List<AuditSonattribute> findAuditSonattributesByAttribute(Integer aId);

    @Transactional
    @Modifying
    @Query(value = "update audit_sonattribute set sona_code=?1,sona_name=?2 where sona_id =?3",nativeQuery = true)
    public int updateson(String sonaCode,String sonaName,int sonaId);
}
