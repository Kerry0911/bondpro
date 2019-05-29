package com.bond.repository;

import com.bond.bean.Officialdraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfficialDao extends JpaRepository<Officialdraft,Integer> {
    @Query(value = "select a.*,b.* from officialdraft a,daibanthing b where a.d_id=b.d_id and b.d_sendpeople=?1",nativeQuery = true)
    public List<Officialdraft> findByDaibanthing_DSendpeople(String dSendpeople);
}
