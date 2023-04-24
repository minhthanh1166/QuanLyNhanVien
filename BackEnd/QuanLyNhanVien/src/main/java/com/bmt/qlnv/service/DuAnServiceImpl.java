package com.bmt.qlnv.service;

import com.bmt.qlnv.models.DuAn;
import com.bmt.qlnv.repository.IDuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuAnServiceImpl implements IDuAnService {
    IDuAnRepository duAnRepository;
    @Autowired
    public DuAnServiceImpl(IDuAnRepository duAnRepository) {
        this.duAnRepository = duAnRepository;
    }
    @Override
    public List<DuAn> getAllListDuAn() {
        return duAnRepository.findAll();
    }
    @Override
    public DuAn getByIdDuAn(long id) {
        return duAnRepository.findDuAnById(id);
    }
    @Override
    public DuAn insertDuAn(DuAn duAn) {
        return duAnRepository.save(duAn);
    }
    @Override
    public DuAn updateDuAn(DuAn duAn, long id) {
        DuAn da = duAnRepository.findDuAnById(id);
        if(da != null) {
            da.getId();
            da.setTenDuAn(duAn.getTenDuAn());
            da.setSoNhanSuLamDuAn(duAn.getSoNhanSuLamDuAn());
            da.setNgayLapHoSoDuAn(duAn.getNgayLapHoSoDuAn());
            da.setNgayTienHanhThucHienDuAn(duAn.getNgayTienHanhThucHienDuAn());
            da.setNgayKetThucDuAn(duAn.getNgayKetThucDuAn());
            da.setTongKinhPhi(duAn.getTongKinhPhi());
            da.setTrangThai(duAn.getTrangThai());
//            da.setListNhanVien(duAn.getListNhanVien());
            return duAnRepository.save(da);
        }
        return null;
    }
    @Override
    public void deleteById(long id) {
        duAnRepository.deleteById(id);
    }
}
