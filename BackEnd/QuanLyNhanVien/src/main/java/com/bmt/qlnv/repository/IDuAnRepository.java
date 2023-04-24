package com.bmt.qlnv.repository;

import com.bmt.qlnv.models.DuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuAnRepository extends JpaRepository<DuAn, Long> {
    DuAn findDuAnById(long id);
}
