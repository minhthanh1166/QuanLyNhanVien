package com.bmt.qlnv.service;


import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.repository.IDonViRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonViServiceImpl implements IDonViService{
    IDonViRepository donViRepository;

    @Autowired
    public DonViServiceImpl(IDonViRepository donViRepository) {
        this.donViRepository = donViRepository;
    }

    @Override
    public List<DonVi> getAllDonVi() {
        return donViRepository.findAll();
    }

    public DonVi getDonViByName(String ten) {
        return donViRepository.findDonViByTenDonVi(ten);
    }


    @Override
    public void delete(String id) {
        DonVi ent = donViRepository.findByMaDonVi(id);
        donViRepository.delete(ent);
    }

    @Override
    public DonVi getByIdDonVi(String id) {
        return donViRepository.findByMaDonVi(id);
    }

    @Override
    public DonVi update(String id, DonVi t) {
        DonVi editObj = donViRepository.findByMaDonVi(id);
        editObj.setTenDonVi(t.getTenDonVi());
        editObj.setMaCapTren(t.getMaCapTren());
        editObj.setLoaiDonVi(t.getLoaiDonVi());
        editObj.setTenThuTruongDonVi(t.getTenThuTruongDonVi());
        editObj.setDiaChi(t.getDiaChi());
        editObj.setSoDienThoai(t.getSoDienThoai());
        editObj.setGhiChu(t.getGhiChu());
        return donViRepository.save(editObj);
    }

    @Override
    public DonVi insert(DonVi t) {
        if(donViRepository.findById(t.getMaDonVi()).isPresent()) {
            return null;
        }
        return donViRepository.save(t);
    }
}
