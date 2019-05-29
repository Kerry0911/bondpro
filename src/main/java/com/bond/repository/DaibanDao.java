package com.bond.repository;

import com.bond.bean.Daibanthing;
import com.bond.bean.Officialdraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DaibanDao extends JpaRepository<Daibanthing,Integer> {
    public List<Daibanthing> findByDSendpeople(String dSendpeople);

}
