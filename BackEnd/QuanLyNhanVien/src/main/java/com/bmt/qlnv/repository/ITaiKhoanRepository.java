package com.bmt.qlnv.repository;

import com.bmt.qlnv.models.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ITaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
        TaiKhoan findTaiKhoanByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
        TaiKhoan findTaiKhoanById(int id);
        TaiKhoan findTaiKhoanByTenDangNhap(String u);

        ArrayList<TaiKhoan> findByTenDangNhap(String u);
}
