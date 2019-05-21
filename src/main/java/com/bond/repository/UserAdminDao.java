package com.bond.repository;

import com.bond.bean.AuditUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserAdminDao extends JpaRepository<AuditUser,Integer>, JpaSpecificationExecutor<AuditUser> {
    //按部门查用户
    List<AuditUser> findByUDept(String udept);

    //按用户名称模糊查询用户
    List<AuditUser> findByUUsernameLike(String username);




 }
