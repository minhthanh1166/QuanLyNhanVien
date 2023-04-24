package com.bmt.qlnv.service;



import com.bmt.qlnv.models.ChucVu;

import java.util.List;

public interface IChucVuService {
    public List<ChucVu> getAllChucVu();

    void delete(String id);

    ChucVu getByIdChucVu(String id);

    ChucVu update(String id, ChucVu t);

    ChucVu insert(ChucVu t);
}
