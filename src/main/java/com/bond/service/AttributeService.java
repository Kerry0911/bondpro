package com.bond.service;

import com.bond.bean.AuditAttribute;
import com.bond.repository.AttributeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttributeService {
    @Resource
    private AttributeDao attributeDao;

    /**
     * 查找所有属性
     * @return
     */
    public List<AuditAttribute> findAllType(){
        return attributeDao.findAllType();
    }

    /**
     * 添加属性
     * @param
     * @return
     */
    public AuditAttribute insert(AuditAttribute auditAttribute){
        return attributeDao.save(auditAttribute);
    }

    public AuditAttribute findAllByAname(String aName){
        return attributeDao.findAuditAttributeByAName(aName);
    }
}
