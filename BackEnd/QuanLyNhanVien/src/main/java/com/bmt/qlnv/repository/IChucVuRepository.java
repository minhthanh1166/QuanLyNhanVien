package com.bmt.qlnv.repository;


import com.bmt.qlnv.models.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChucVuRepository extends JpaRepository<ChucVu, String> {
    ChucVu findChucVuByMaChucDanh(String maChucDanh);

}
