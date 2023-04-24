package com.bmt.qlnv.repository;


import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.models.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHoSoRepository extends JpaRepository<HoSo, Long> {


    HoSo findBySoHieuNhanVien(String soHieuNhanVien);

    @Query(value = "SELECT * FROM ho_so WHERE ho_va_ten LIKE %?1% or so_hieu_nhan_vien LIKE %?1%", nativeQuery = true)
    List<HoSo> findByHoVaTen(String hoVaTen);

    List<HoSo> findHoSoByDonVi(DonVi maDV);
    List<HoSo> findHoSoByPhongBan(PhongBan maPB);
    HoSo findByIdHoSo(Long id);
}
