package com.bond.service;

import com.bond.bean.AuditAttribute;
import com.bond.bean.AuditSonattribute;
import com.bond.bean.Model;
import com.bond.repository.ModelDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModelService {
    @Resource
    private ModelDao modelDao;

    public List<Model> findAll(){
        return modelDao.findAll();
    }


//    public List<AuditSonattribute> findbyaId(Integer aId){
//        return modelDao.findAllByAuditAttributes(aId);
//    }

    public Model modelById(Integer modelId){
        return modelDao.findById(modelId).get();
    }

}
