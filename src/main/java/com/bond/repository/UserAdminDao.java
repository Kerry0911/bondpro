package com.bond.repository;

import com.bond.bean.AuditUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserAdminDao extends JpaRepository<AuditUser,Integer>, JpaSpecificationExecutor<AuditUser> {
    //按部门查用户
    List<AuditUser> findByUDept(String udept);

    //按用户名称模糊查询用户
    List<AuditUser> findByUUsernameLike(String username);

    @Transactional
    @Modifying
    @Query(value = "update audit_user set u_password=?2 where u_id=?1",nativeQuery = true)
    public int resetpwd(Integer uId,String uPassword);

    @Transactional
    @Modifying
    @Query(value = "update audit_user set state=?2 where u_id=?1",nativeQuery = true)
    public int use(Integer uId,String state);

    //登录
    public AuditUser findByUUsercodeAndUPassword(String uUsercode,String uPassword);

    //根据角色查询用户
    List<AuditUser> findByURole(String uRole);
 }
