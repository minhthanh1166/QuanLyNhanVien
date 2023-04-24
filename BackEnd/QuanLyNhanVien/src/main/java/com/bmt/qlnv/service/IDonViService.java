package com.bmt.qlnv.service;



import com.bmt.qlnv.models.DonVi;

import java.util.List;

public interface IDonViService {
    List<DonVi> getAllDonVi();
    DonVi getDonViByName(String ten);

    void delete(String id);

    public DonVi getByIdDonVi(String id);

    DonVi update(String id, DonVi t);

    DonVi insert(DonVi t);
}
