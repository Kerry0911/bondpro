package com.bond.service;

import com.bond.bean.AuditBody;
import com.bond.repository.AuditorDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuditorService {
    @Resource
    private AuditorDao auditorDao;

    public List<AuditBody> findpre(){
        return auditorDao.findpre();
    }

    public List<AuditBody> findson(String abId){
        return auditorDao.findson(abId);
    }

    public AuditBody insert(AuditBody auditBody){
        return auditorDao.save(auditBody);
    }

    public void delbody(String abId){
        auditorDao.deleteById(abId);
    }
}
