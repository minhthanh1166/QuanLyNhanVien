package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "dm_dan_toc")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DanToc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDanToc;
    private String tenDanToc;
}
