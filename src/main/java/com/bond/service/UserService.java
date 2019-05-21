package com.bond.service;

import com.bond.bean.AuditUser;
import com.bond.repository.AuditUserRep;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private AuditUserRep userRep;

    public List<AuditUser> findusers(Integer auditedId){
        return userRep.findByIns_AuditedId(auditedId);
    }
}


