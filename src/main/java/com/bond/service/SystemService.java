package com.bond.service;

import com.bond.bean.Systemconfiguration;
import com.bond.repository.SystemDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemService {
    @Resource
    private SystemDao systemDao;

    public List<Systemconfiguration> findDepts(){
        return systemDao.findDepts();
    }

    public List<Systemconfiguration> findPosts(){
        return systemDao.findPosts();
    }
}
