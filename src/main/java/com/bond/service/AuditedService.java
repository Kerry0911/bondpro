package com.bond.service;

import com.bond.bean.AuditAuditedInstitutions;
import com.bond.bean.AuditLog;
import com.bond.bean.AuditUser;
import com.bond.repository.AuditedDao;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuditedService {
    @Resource
    private AuditedDao auditedDao;

    public List<AuditAuditedInstitutions> findall(){
        return auditedDao.findall();
    }

//    public List<AuditAuditedInstitutions> findson(Integer preId){
//        return auditedDao.findson(preId);
//    }

    public List<AuditAuditedInstitutions> findAll(){
        return auditedDao.findAll();
    }

    //多条件查询
    @SuppressWarnings("serial")
    public List<AuditAuditedInstitutions> findSearch(Integer preId,String auditedBusiness){
        List<AuditAuditedInstitutions> logs=auditedDao.findAll(new Specification<AuditAuditedInstitutions>() {
            public Predicate toPredicate(Root<AuditAuditedInstitutions> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //本集合用于封装查询条件
                List<Predicate> predicates=new ArrayList<>();
                if (!StringUtils.isEmpty(auditedBusiness)){
                    predicates.add(criteriaBuilder.like(root.<String>get("auditedBusiness"),"%"+auditedBusiness+"%"));
                }
                if (preId!=null){
                    predicates.add(criteriaBuilder.equal(root.get("preId").as(Integer.class),preId));
                }
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        });
        List<AuditAuditedInstitutions> results=new ArrayList<>();
        //遍历查询出的操作日志对象
        for (AuditAuditedInstitutions l:logs){
            AuditAuditedInstitutions ll=new AuditAuditedInstitutions();
            ll.setAuditedBusiness(l.getAuditedBusiness());
            ll.setPreId(l.getPreId());
            ll.setAuditedAccounting(l.getAuditedAccounting());
            ll.setAuditedBeforetime(l.getAuditedBeforetime());
            ll.setAuditedCode(l.getAuditedCode());
            ll.setAuditedCreatetime(l.getAuditedCreatetime());
            ll.setAuditedCreditCode(l.getAuditedCreditCode());
            ll.setAuditedHigher(l.getAuditedHigher());
            ll.setAuditedLevel(l.getAuditedLevel());
            ll.setAuditedName(l.getAuditedName());
            ll.setAuditedId(l.getAuditedId());
            results.add(ll);
        }
        return results;
    }
}
