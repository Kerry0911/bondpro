package com.bond.repository;

import com.bond.bean.Daibanthing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoDao extends JpaRepository<Daibanthing,Integer> {
    
}
