package com.bmt.qlnv.service;
import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.models.PhongBan;
import com.bmt.qlnv.models.TinhLuong;

import java.util.List;

public interface ITinhLuongService {
    List<TinhLuong> getAllTinhLuong();
    List<TinhLuong> searchAllHoSoByName(HoSo maHoSo);
    List<TinhLuong> searchAllHoSoByDonVi(DonVi maDV);
    List<TinhLuong> searchAllHoSoByPhongBan(PhongBan maPB);
    TinhLuong getByIdTinhLuong(long id);
    void deleteById(long id);
    TinhLuong insertTinhLuong(TinhLuong tinhLuong);
    TinhLuong updateTinhLuong(long id, TinhLuong tinhLuong);

}
