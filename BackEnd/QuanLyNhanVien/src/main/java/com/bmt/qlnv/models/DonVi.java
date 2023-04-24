package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "dm_don_vi")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DonVi implements Serializable {
    @Id
    private String maDonVi;
    private String tenDonVi;
    private String maCapTren;
    private String loaiDonVi;
    private String tenThuTruongDonVi;
    private String diaChi;
    private String soDienThoai;
    private String ghiChu;
}
