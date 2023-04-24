package com.bmt.qlnv.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "tmp_qua_trinh_dao_tao")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class QuaTrinhDaoTaoBoiDuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ho_so", foreignKey = @ForeignKey(name = "ma_ho_so_qua_trinh_dao_tao_Fk"))
    private HoSo hoSo;
    @Temporal(TemporalType.DATE)
    private Date tuNgay;
    @Temporal(TemporalType.DATE)
    private Date denNgay;
    private String tenChuyenNganhDaoTaoBoiDuong;
    private String trinhDoDaoTaoBoiDuong;
    private String coSoDaoTaoBoiDuong;
    private String trangThaiDaoTaoBoiDuong;

}
