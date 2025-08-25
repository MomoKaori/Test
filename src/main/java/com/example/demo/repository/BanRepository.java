package com.example.demo.repository;

import com.example.demo.entity.Ban;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BanRepository extends JpaRepository<Ban,Long> {
    @Modifying
    @Transactional
    @Query("delete from Ban b where b.ma=?1")
    void deleteByMa(String ma);

    @Query("select b from Ban b where b.ma = ?1")
    Ban findByMa(String ma);
}
