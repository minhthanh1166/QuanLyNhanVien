package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "loai_quyet_dinh")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LoaiQuyetDinh implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_loaiQuyetDinh;
	private String tenLoaiQuyetDinh;
}
