package com.bmt.qlnv.service;

import com.bmt.qlnv.models.DuAn;
import com.bmt.qlnv.models.HoSo;

import java.util.ArrayList;
import java.util.List;

public interface IDuAnService {
     List<DuAn> getAllListDuAn();
     DuAn getByIdDuAn(long id);
     DuAn insertDuAn(DuAn duAn);
     DuAn updateDuAn(DuAn duAn, long id);
     DuAn updateNhanVienDuAn(List<Long> nvl, long id);
     DuAn deleteNhanVienDuAn(long idDuAn, List<Long> idNhanVien);
     void deleteById(long id);
}
