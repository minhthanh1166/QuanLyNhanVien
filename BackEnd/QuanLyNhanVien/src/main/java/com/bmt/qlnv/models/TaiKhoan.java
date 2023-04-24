package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenDangNhap;
    private String matKhau;
    private String hoVaTen;
    private String soCmnd;
    private String dienThoaiDiDong;
    private String email;
    private int kichHoat;
    private int quyen;
}
