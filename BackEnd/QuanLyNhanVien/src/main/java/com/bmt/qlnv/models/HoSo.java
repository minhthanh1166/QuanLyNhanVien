package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DialectOverride;

import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "ho_so")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class HoSo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long idHoSo;
    private String soHieuNhanVien;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_don_vi", foreignKey = @ForeignKey(name = "ma_don_vi_ho_so_Fk"))
    private DonVi donVi;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_phong_ban", foreignKey = @ForeignKey(name = "ma_phong_ban_ho_so_Fk"))
    private PhongBan phongBan;
    @Lob
    private byte[] imageUrl;
    private String hoVaTen;
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    private String gioiTinh;
    private String noiSinh;
    private String hoKhauThuongTru;
    private String noiOHienTai;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dan_toc", foreignKey = @ForeignKey(name = "maDanToc"))
    private int danToc;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ton_giao", foreignKey = @ForeignKey(name = "maTonGiao"))
    private long tonGiao;
    private String soCmnd;

    @JoinColumn(name = "chuc_vu", foreignKey = @ForeignKey(name = "maChucVu"))
    private String chucVu;

    @Temporal(TemporalType.DATE)
    private Date ngayBoNhiem;
    private double luong;
    private String trinhDoGDPT;
    private String trinhDoChuyenMon;
    private String hocVi;
    private String hocHam;
    private String ngoaiNgu;
    private String soBaoHiemXh;
    private String danhGia;
    @Temporal(TemporalType.DATE)
    private Date ngayDanhGia;
    private String hinhThucKhenThuong;
    @Temporal(TemporalType.DATE)
    private Date ngayKhenThuong;
    private String quyetDinhKhenThuong;

    private String hinhThucKyLuat;
    @Temporal(TemporalType.DATE)
    private Date ngayKyLuat;
    private String quyetDinhKyLuat;
    private String trangThaiDaoTao;
    private String tenChuyenNganhDaoTao;
    @Temporal(TemporalType.DATE)
    private Date ngayDaoTao;
    private String trangThai;
    @Temporal(TemporalType.DATE)
    private Date ngayLapHoSo;
}