package com.bond.service;

import com.bond.bean.AuditSonattribute;
import com.bond.repository.SonAttrDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SonAttrService {
    @Resource
    private SonAttrDao sonAttrDao;

    public List<AuditSonattribute> findbyaid(Integer aId){
        return sonAttrDao.findAuditSonattributesByAttribute(aId);
    }

    public void delson(Integer sonaId){
        sonAttrDao.deleteById(sonaId);
    }


    public int setson(String sonaCode,String sonaName,Integer sonaId){
        return sonAttrDao.updateson(sonaCode,sonaName,sonaId);
    }

    public AuditSonattribute addson(AuditSonattribute auditSonattribute){
        return sonAttrDao.save(auditSonattribute);
    }
 }
