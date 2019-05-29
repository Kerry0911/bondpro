package com.bond.service;

import com.bond.bean.Task;
import com.bond.repository.TaskRep;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Resource
    private TaskRep taskRep;

    public List<Task> findByPp(String ppId){
        return taskRep.findByPp(ppId);
    }
    public List<Task> findAll(){
        return taskRep.findAll();
    }

    @SuppressWarnings("serial")
    public List<Task> searchby(Integer tId,String tAuditpoints){
        List<Task> tasks=taskRep.findAll(new Specification<Task>() {
            public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //本集合用于封装查询条件
                List<Predicate> predicates=new ArrayList<>();
                if (!StringUtils.isEmpty(tAuditpoints)){
                    predicates.add(criteriaBuilder.like(root.<String>get("tAuditpoints"),"%"+tAuditpoints+"%"));
                }
                if (tId!=null){
                    predicates.add(criteriaBuilder.equal(root.get("tId").as(Integer.class),tId));
                }
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        });
        List<Task> results=new ArrayList<>();
        //遍历查询出的操作日志对象
        for (Task l:tasks){
            Task ll=new Task();
            ll.settId(l.gettId());
            ll.setAuditPlanproject(l.getAuditPlanproject());
            ll.settAuditpoints(l.gettAuditpoints());
            ll.settCode(l.gettCode());
            ll.settName(l.gettName());
            ll.settState(l.gettState());
            results.add(ll);
        }
        return results;
    }
}
