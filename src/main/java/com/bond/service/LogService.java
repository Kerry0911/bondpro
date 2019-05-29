package com.bond.service;

import com.bond.bean.AuditLog;
import com.bond.repository.LogDao;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LogService {
    @Resource
    private LogDao logDao;

    public List<AuditLog> findAll(){
        return logDao.findAll();
    }

    @SuppressWarnings("serial")
    public List<AuditLog> findSearch(String lName,String lDept,String lType,String lInfo,Date stime,Date etime,String lMk){
        List<AuditLog> logs=logDao.findAll(new Specification<AuditLog>() {
            @Override
            public Predicate toPredicate(Root<AuditLog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                //本集合用于封装查询条件
                List<Predicate> predicates=new ArrayList<>();
                    /**是否传入了姓名来查询*/
                    if (!StringUtils.isEmpty(lName)){
                        predicates.add(criteriaBuilder.like(root.<String>get("lName"),"%"+lName+"%"));
                    }
                    /**是否传入了操作单位来查询*/
                    if (!StringUtils.isEmpty(lDept)){
                        predicates.add(criteriaBuilder.like(root.<String>get("lDept"),"%"+lDept+"%"));
                    }
                    /**是否传入了模块来查询*/
                    if (!StringUtils.isEmpty(lMk)){
                        predicates.add(criteriaBuilder.like(root.<String>get("lMk"),"%"+lMk+"%"));
                    }
                    /**是否传入了操作类型来查询*/
                    if (!StringUtils.isEmpty(lType)){
                        predicates.add(criteriaBuilder.like(root.<String>get("lType"),"%"+lType+"%"));
                    }
                    /**是否传入了操作内容来查询*/
                    if (!StringUtils.isEmpty(lInfo)){
                        predicates.add(criteriaBuilder.like(root.<String>get("lInfo"),"%"+lInfo+"%"));
                    }
                    /**是否传入了操作时间来查询*/
                if (!StringUtils.isEmpty(stime) && !StringUtils.isEmpty(etime)) {
                    predicates.add(criteriaBuilder.between(root.get("lTime"),stime,etime));
                }

                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        });
        List<AuditLog> results=new ArrayList<>();
        //遍历查询出的操作日志对象
        for (AuditLog l:logs){
            AuditLog ll=new AuditLog();
            ll.setlName(l.getlName());
            ll.setlDept(l.getlDept());
            ll.setlMk(l.getlMk());
            ll.setlType(l.getlType());
            ll.setlInfo(l.getlInfo());
            ll.setlTime(l.getlTime());
            results.add(ll);
        }
        return logs;
    }
}
