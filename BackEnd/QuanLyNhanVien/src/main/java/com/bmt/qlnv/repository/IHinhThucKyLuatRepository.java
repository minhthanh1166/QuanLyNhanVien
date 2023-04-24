package com.bmt.qlnv.repository;


import com.bmt.qlnv.models.HinhThucKyLuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHinhThucKyLuatRepository extends JpaRepository<HinhThucKyLuat, Integer> {
    HinhThucKyLuat findQuyetDinhKyLuatByIdHT(int id);



}
