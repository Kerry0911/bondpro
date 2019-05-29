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

    //修改用户
    @Transactional
    public void updateById(Integer uId){

    }
    //修改i用户状态
    @Transactional
    public AuditUser savestate(AuditUser auditUser){return  dao1.save(auditUser);}


    //查看角色
    public List<Systemconfiguration>  findByrole(String configcode){
        return dao2.findByConfigcode(configcode);
    }

    //修改用户状态前先根据id查询一遍
    public AuditUser findOne(Integer uId){ return dao1.getOne(uId); }

    //用户批量删除
    @Transactional
    public void delpiliang(Integer [] uId){
        for(int i=0;i<uId.length;i++){
            dao1.deleteById(uId[i]);
        }
    }

    public AuditUser insert(AuditUser user){
        return dao1.save(user);
    }

    public List<AuditUser> findAll(){
        return dao1.findAll();
    }

    public int resetpwd(Integer uId,String uPassword){
        return dao1.resetpwd(uId,uPassword);
    }

    public int use(Integer uId,String state){
        return dao1.use(uId,state);
    }

    //根据角色查询用户
    public List<AuditUser> findByroles(String uRole){
        return dao1.findByURole(uRole);
    }

    //增加角色
    public void adduRole(Systemconfiguration systemconfiguration){
        dao2.save(systemconfiguration);
    }

    //角色批量删除
    @Transactional
    public void delRolePiLiang(Integer [] id){
        for(int i=0;i<id.length;i++){
            dao2.deleteById(id[i]);
        }
    }

    //角色修改
    @Transactional
    public void upRole(Integer id,String configValuename,String description){
        dao1.upRole(id,configValuename,description);
    }

    //登录
    public AuditUser getUser(String uUsercode,String uPassword){
        return  dao1.findByUUsercodeAndUPassword(uUsercode,uPassword);
    }
}
