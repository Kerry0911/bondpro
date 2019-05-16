package com.bond.service;

import com.bond.bean.Model;
import com.bond.dao.ModelDao;
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
}
