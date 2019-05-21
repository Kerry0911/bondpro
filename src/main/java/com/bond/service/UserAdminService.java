package com.bond.service;

import com.bond.bean.AuditUser;
import com.bond.bean.Systemconfiguration;
import com.bond.repository.DeptDao;
import com.bond.repository.UserAdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserAdminService {
    @Autowired
    private UserAdminDao dao1;

    @Autowired
    private DeptDao dao2;




    //查部门
    public List<Systemconfiguration>  findBydept(String configcode){
        return dao2.findByConfigcode(configcode);
    }

    //根据部门查用户
    public List<AuditUser> findByUdept(String udpet){
        return dao1.findByUDept(udpet);
    }

    //根据用户名称模糊查询
    public List<AuditUser> findByUUsernameLike (String username){
        return dao1.findByUUsernameLike(username);
    }

    //添加用户
    @Transactional
     public void saveAll(AuditUser users){
            dao1.save(users);
     }

     //删除用户
    @Transactional
    public void  deleteById(Integer uId){
     dao1.deleteById(uId);
    }
}
