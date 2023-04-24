package com.bmt.qlnv.repository;

import com.bmt.qlnv.models.HinhThucKhenThuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHinhThucKhenThuongRepository extends JpaRepository<HinhThucKhenThuong, Integer> {
    HinhThucKhenThuong findQuyetDinhKhenThuongByIdHT(int id);

}