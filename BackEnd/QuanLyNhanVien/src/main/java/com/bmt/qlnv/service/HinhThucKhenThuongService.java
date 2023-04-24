package com.bmt.qlnv.service;


import com.bmt.qlnv.models.HinhThucKhenThuong;
import com.bmt.qlnv.repository.IHinhThucKhenThuongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HinhThucKhenThuongService {
    private final IHinhThucKhenThuongRepository qdktRepo;

    @Autowired
    public HinhThucKhenThuongService(IHinhThucKhenThuongRepository qdktRepo) {
        this.qdktRepo = qdktRepo;
    }

    public List<HinhThucKhenThuong> getAll() {
        List<HinhThucKhenThuong> listFromDb = new ArrayList<>();
        listFromDb = qdktRepo.findAll();
        return listFromDb;
    }



    public void deleteQD(int id) {
        qdktRepo.deleteById(id);
    }


    public HinhThucKhenThuong getById(int id) {
        return qdktRepo.findQuyetDinhKhenThuongByIdHT(id);
    }


    public HinhThucKhenThuong updateQD(int id, HinhThucKhenThuong dt) {
        HinhThucKhenThuong editDT = qdktRepo.findQuyetDinhKhenThuongByIdHT(id);
        editDT.setTenHT(dt.getTenHT());
        editDT.setGhiChu(dt.getGhiChu());
        return qdktRepo.save(editDT);
    }


    public HinhThucKhenThuong insertQD(HinhThucKhenThuong t) throws IOException {
        return qdktRepo.save(t);
    }

//    public HinhThucKhenThuong uploadFileQD(int id, MultipartFile file) throws IOException {
//        String fileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s", "");
//        HinhThucKhenThuong qd = qdktRepo.findQuyetDinhKhenThuongByIdQdKhenThuong(id);
//        qd.setTenFile(fileName);
//        qd.setFileKy(file.getBytes());
//        return qdktRepo.save(qd);
//    }

//    public byte[] downloadFile(int fileID) {
//        Optional<HinhThucKhenThuong> dbFileData = qdktRepo.findById(fileID);
//        return dbFileData.get().getFileKy();
//    }


}
