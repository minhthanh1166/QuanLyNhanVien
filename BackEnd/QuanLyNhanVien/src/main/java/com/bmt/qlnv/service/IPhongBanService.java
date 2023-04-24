package com.bmt.qlnv.service;



import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.PhongBan;

import java.util.List;

public interface IPhongBanService {
    public List<PhongBan> getAllPhongBan();
    PhongBan getPhongBanByName(String ten);
    List<PhongBan> getAllPhongBanByDonVi(DonVi dv);

    void delete(long id);

    public PhongBan getByIdPhongBan(long id);

    PhongBan update(long id, PhongBan t);

    PhongBan insert(PhongBan t);
}
