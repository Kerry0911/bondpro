package com.bond.repository;

import com.bond.bean.Systemconfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SystemconfigRep extends JpaRepository<Systemconfiguration,Integer>, JpaSpecificationExecutor<Systemconfiguration> {
    public List<Systemconfiguration> findByConfigcode(String configcode);

    public List<Systemconfiguration> findByConfigcodeAndConfigvalueidLike(String configcode,String configvalueid);
}
