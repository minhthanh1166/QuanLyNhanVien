package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "hinh_thuc_ky_luat")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class HinhThucKyLuat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHT;
	private String tenHT;
	private String ghiChu;

}
