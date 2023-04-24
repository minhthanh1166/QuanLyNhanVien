package com.bmt.qlnv.service;


import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.PhongBan;
import com.bmt.qlnv.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanServiceImpl implements IPhongBanService{
    IPhongBanRepository phongBanRepository;

    @Autowired
    public PhongBanServiceImpl(IPhongBanRepository phongBanRepository) {
        this.phongBanRepository = phongBanRepository;
    }

    @Override
    public List<PhongBan> getAllPhongBan() {
        return phongBanRepository.findAll();
    }

    public PhongBan getPhongBanByName(String ten) {
        return phongBanRepository.findPhongBanByTenPhongBan(ten);
    }

    @Override
    public List<PhongBan> getAllPhongBanByDonVi(DonVi dv) {
        return phongBanRepository.getAllByMaDonVi(dv);
    }


    @Override
    public void delete(long id) {
        PhongBan ent = phongBanRepository.findPhongBanByMaPhongBan(id);
        phongBanRepository.delete(ent);
    }

    @Override
    public PhongBan getByIdPhongBan(long id) {
        return phongBanRepository.findPhongBanByMaPhongBan(id);
    }

    @Override
    public PhongBan update(long id, PhongBan t) {
        PhongBan editObj = phongBanRepository.findPhongBanByMaPhongBan(id);
        editObj.setTenPhongBan(t.getTenPhongBan());
        editObj.setMaDonVi(t.getMaDonVi());
        editObj.setGhiChu(t.getGhiChu());
        return phongBanRepository.save(editObj);
    }

    @Override
    public PhongBan insert(PhongBan t) {
        if(phongBanRepository.findById(t.getMaPhongBan()).isPresent()) {
            return null;
        }
        return phongBanRepository.save(t);
    }
}
