package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "du_an")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    private String tenDuAn;
//    @OneToMany(mappedBy = "duAn", cascade = CascadeType.ALL)
//    private List<HoSo> listNhanVien;
    @Temporal(TemporalType.DATE)
    private Date ngayLapHoSoDuAn;
    @Temporal(TemporalType.DATE)
    private Date ngayTienHanhThucHienDuAn;
    @Temporal(TemporalType.DATE)
    private Date ngayKetThucDuAn;
    private byte soNhanSuLamDuAn;
    private byte trangThai;
    private double tongKinhPhi;
}
