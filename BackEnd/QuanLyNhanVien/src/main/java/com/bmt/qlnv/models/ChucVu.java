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
@Table(name = "dm_chuc_danh")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ChucVu implements Serializable {
    @Id
    private String maChucDanh;
    private String tenChucDanh;
    private String ghiChu;
    private String nhomChucDanh;

}
