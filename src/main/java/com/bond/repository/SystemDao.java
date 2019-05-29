package com.bond.repository;

import com.bond.bean.Systemconfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SystemDao extends JpaRepository<Systemconfiguration,Integer> {
    @Query(value = "select * from systemconfiguration where configCode='system_dept'",nativeQuery = true)
    public List<Systemconfiguration> findDepts();

    @Query(value = "select * from systemconfiguration where configCode='post'",nativeQuery = true)
    public List<Systemconfiguration> findPosts();
}
