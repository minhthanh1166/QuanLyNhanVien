package com.bmt.qlnv.service;
import com.bmt.qlnv.models.TinhLuong;

import java.util.List;

public interface ITinhLuongService {
    List<TinhLuong> getAllTinhLuong();
    TinhLuong getByIdTinhLuong(long id);
    void deleteById(long id);
    TinhLuong insertTinhLuong(TinhLuong tinhLuong);
    TinhLuong updateTinhLuong(long id, TinhLuong tinhLuong);

}
