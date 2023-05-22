package com.bmt.qlnv.repository;

import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.models.PhongBan;
import com.bmt.qlnv.models.TinhLuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITinhLuongReponsitory extends JpaRepository<TinhLuong, Long> {
    TinhLuong findTinhLuongByIdTinhLuong(long id);

    List<TinhLuong> findByHoso(HoSo maHoSo);
    List<TinhLuong> findHoSoByDonVi(DonVi maDV);
    List<TinhLuong> findHoSoByPhongBan(PhongBan maPB);
}
