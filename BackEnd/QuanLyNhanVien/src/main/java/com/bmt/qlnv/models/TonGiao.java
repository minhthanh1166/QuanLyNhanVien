package com.bmt.qlnv.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "dm_ton_giao")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TonGiao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maTonGiao;
    private String tenTonGiao;
}
