package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "tinh_luong")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TinhLuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTinhLuong;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ho_so", foreignKey = @ForeignKey(name = "ho_so_Fk"))
    private HoSo hoso;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "don_vi", foreignKey = @ForeignKey(name = "don_vi_Fk"))
    private DonVi donVi;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phong_ban", foreignKey = @ForeignKey(name = "phong_ban_Fk"))
    private PhongBan phongBan;
    @Column(name = "he_so_luong")
    private float heSoLuong;
    @Column(name = "phu_cap")
    private double phuCap;
    @Column(name = "so_ngay_di_lam")
    private int soNgayDiLam;
    @Column(name = "luong_co_ban")
    private double luongCoBan;
    @Column(name= "luong_chinh_thuc")
    private double luongChinhThuc;
    @Column(name="thoi_gian_cap_nhat")
    private Date thoiGianCapNhat;
    @Column(name = "ghi_chu")
    private String ghiChu;
}
