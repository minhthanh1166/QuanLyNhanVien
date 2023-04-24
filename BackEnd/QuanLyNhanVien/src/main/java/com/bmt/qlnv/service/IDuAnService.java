package com.bmt.qlnv.service;

import com.bmt.qlnv.models.DuAn;

import java.util.List;

public interface IDuAnService {
     List<DuAn> getAllListDuAn();
     DuAn getByIdDuAn(long id);
     DuAn insertDuAn(DuAn duAn);
     DuAn updateDuAn(DuAn duAn, long id);
     void deleteById(long id);
}
