package com.bmt.qlnv.repository;

import com.bmt.qlnv.models.TinhLuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITinhLuongReponsitory extends JpaRepository<TinhLuong, Long> {
    TinhLuong findTinhLuongByIdTinhLuong(long id);
}
