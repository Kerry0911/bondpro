package com.bond.dao;

import com.bond.bean.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelDao extends JpaRepository<Model,Integer> {

}
