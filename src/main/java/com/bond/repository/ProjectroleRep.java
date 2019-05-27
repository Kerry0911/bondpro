package com.bond.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bond.bean.Projectrole;

import java.util.List;

public interface ProjectroleRep extends JpaRepository<Projectrole,Integer> {
    public Projectrole findByAuditPlanproject_ppIdAndJd(Integer ppid,String ppjd);
//    public Projectrole findByAuditPlanproject_ppId(Integer ppid);
    public Projectrole findByIdAndJd(Integer id,String jd);
    public List<Projectrole> findByAuditPlanproject_PpId(Integer pid);
}
