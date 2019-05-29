package com.bond.repository;

import com.bond.bean.Projectfile;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProjectfileRep extends JpaRepository<Projectfile,Integer> {
    public List<Projectfile> findByAuditPlanproject_PpId(Integer id);
    public Optional<Projectfile> findById(Integer id);
}
