package com.bond.repository;

import com.bond.bean.AuditSonattribute;
import com.bond.bean.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Null;
import java.util.List;

public interface ModelDao extends JpaRepository<Model,Integer> {

    //public List<AuditSonattribute> findAllByAuditAttributes(Integer aId);

}
