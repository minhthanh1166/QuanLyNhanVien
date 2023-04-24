package com.bmt.qlnv.repository;


import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPhongBanRepository extends JpaRepository<PhongBan, Long> {
    PhongBan findPhongBanByMaPhongBan(long maPB);
    PhongBan findPhongBanByTenPhongBan(String tenPB);

    List<PhongBan> getAllByMaDonVi(DonVi dv);
}
