package com.bmt.qlnv.service;

import com.bmt.qlnv.models.DuAn;
import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.repository.IDuAnRepository;
import com.bmt.qlnv.repository.IHoSoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DuAnServiceImpl implements IDuAnService {
    IDuAnRepository duAnRepository;

    @Autowired
    IHoSoRepository hoSoRes;

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
        if (da != null) {
            da.getId();
            da.setTenDuAn(duAn.getTenDuAn());
            da.setSoNhanSuLamDuAn(duAn.getSoNhanSuLamDuAn());
            da.setNgayLapHoSoDuAn(duAn.getNgayLapHoSoDuAn());
            da.setNgayTienHanhThucHienDuAn(duAn.getNgayTienHanhThucHienDuAn());
            da.setNgayKetThucDuAn(duAn.getNgayKetThucDuAn());
            da.setTongKinhPhi(duAn.getTongKinhPhi());
            da.setTrangThai(duAn.getTrangThai());
            return duAnRepository.save(da);
        }
        return null;
    }

    @Override
    public DuAn updateNhanVienDuAn(List<Long> nvl, long id) {
        DuAn da = duAnRepository.findDuAnById(id);
        List<HoSo> hsarr = new ArrayList<>();
        for (Long o : nvl) {
            hsarr.add(hoSoRes.findByIdHoSo(o));
        }
        System.out.println(hsarr.size());
        if (da != null) {
            da.setListNhanVien(hsarr);
            return duAnRepository.save(da);
        }
        return null;
    }

    @Override
    public DuAn deleteNhanVienDuAn(long idDuAn, List<Long> arrIdNhanVien) {
        DuAn da = duAnRepository.findDuAnById(idDuAn);
        arrIdNhanVien.forEach((value)-> {
            da.getListNhanVien().removeIf((item)-> item.getIdHoSo() == value);
        });
        return  duAnRepository.save(da);
    }

    @Override
    public void deleteById(long id) {
        duAnRepository.deleteById(id);
    }
}
