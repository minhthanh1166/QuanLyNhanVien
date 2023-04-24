package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "dm_phong_ban")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maPhongBan;

    private String tenPhongBan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_don_vi", foreignKey = @ForeignKey(name = "ma_don_vi_phong_ban_Fk"))
    private DonVi maDonVi;

    private String ghiChu;

}
