package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "cham_cong")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ChamCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChamCong;

}
