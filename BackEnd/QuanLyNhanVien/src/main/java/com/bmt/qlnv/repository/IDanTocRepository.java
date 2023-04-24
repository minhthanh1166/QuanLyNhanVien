package com.bmt.qlnv.repository;

import com.bmt.qlnv.models.DanToc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDanTocRepository extends JpaRepository<DanToc, Integer> {
    DanToc findByMaDanToc(int id);
    DanToc findByTenDanToc(String name);

}
