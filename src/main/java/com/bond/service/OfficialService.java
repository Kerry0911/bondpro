package com.bond.service;

import com.bond.bean.Daibanthing;
import com.bond.bean.Officialdraft;
import com.bond.repository.DaibanDao;
import com.bond.repository.OfficialDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OfficialService {
    @Resource
    private DaibanDao daibanDao;
    @Resource
    private OfficialDao officialDao;

    public List<Officialdraft> findBypeople(String dSendpeople){
        return officialDao.findByDaibanthing_DSendpeople(dSendpeople);
    }

    //查询登录用户的待办事项
    public List<Daibanthing> findBySendname(String dSendname){
        return daibanDao.findByDSendpeople(dSendname);
    }
}
