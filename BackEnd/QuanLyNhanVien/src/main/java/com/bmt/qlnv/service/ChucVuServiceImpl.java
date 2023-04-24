package com.bmt.qlnv.service;


import com.bmt.qlnv.models.ChucVu;
import com.bmt.qlnv.repository.IChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServiceImpl implements IChucVuService{

    private final IChucVuRepository chucVuRepository;

    @Autowired
    public ChucVuServiceImpl(IChucVuRepository chucVuRepository) {
        this.chucVuRepository = chucVuRepository;
    }

    @Override
    public List<ChucVu> getAllChucVu() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu getByIdChucVu(String id) {
        return chucVuRepository.findChucVuByMaChucDanh(id);
    }

    @Override
    public ChucVu update(String id, ChucVu t) {
        ChucVu editCV = chucVuRepository.findChucVuByMaChucDanh(id);
        editCV.setTenChucDanh(t.getTenChucDanh());
        editCV.setNhomChucDanh(t.getNhomChucDanh());
        editCV.setGhiChu(t.getGhiChu());
        return chucVuRepository.save(editCV);
    }

    @Override
    public ChucVu insert(ChucVu t) {
        return chucVuRepository.save(t);
    }

    @Override
    public void delete(String id) {
        ChucVu del = chucVuRepository.findChucVuByMaChucDanh(id);
        chucVuRepository.delete(del);
    }
}
