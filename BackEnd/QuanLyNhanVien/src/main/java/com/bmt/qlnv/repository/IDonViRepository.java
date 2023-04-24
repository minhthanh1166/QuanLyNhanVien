package com.bmt.qlnv.repository;


import com.bmt.qlnv.models.DonVi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDonViRepository extends JpaRepository<DonVi, String> {
    DonVi findByMaDonVi(String maDonVi);
    DonVi findDonViByTenDonVi(String ten);
}
