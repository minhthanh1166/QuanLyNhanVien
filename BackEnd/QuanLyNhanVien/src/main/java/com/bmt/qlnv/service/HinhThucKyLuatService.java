package com.bmt.qlnv.service;


import com.bmt.qlnv.models.HinhThucKyLuat;
import com.bmt.qlnv.repository.IHinhThucKyLuatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HinhThucKyLuatService {
    private final IHinhThucKyLuatRepository quyetDinhKyLuatRepository;

    @Autowired
    public HinhThucKyLuatService(IHinhThucKyLuatRepository quyetDinhKyLuatRepository) {
        this.quyetDinhKyLuatRepository = quyetDinhKyLuatRepository;
    }

    public List<HinhThucKyLuat> getAll() {
        List<HinhThucKyLuat> listFromDb = new ArrayList<>();
        listFromDb = quyetDinhKyLuatRepository.findAll();
        return listFromDb;
    }


    public void deleteQD(int id) {
        quyetDinhKyLuatRepository.deleteById(id);
    }


    public HinhThucKyLuat getById(int id) {
        return quyetDinhKyLuatRepository.findQuyetDinhKyLuatByIdHT(id);
    }


    public HinhThucKyLuat updateQD(int id, HinhThucKyLuat dt) {
        HinhThucKyLuat editDT = quyetDinhKyLuatRepository.findQuyetDinhKyLuatByIdHT(id);
        editDT.setTenHT(dt.getTenHT());
        editDT.setGhiChu(dt.getGhiChu());
        return quyetDinhKyLuatRepository.save(editDT);
    }


    public HinhThucKyLuat insertQD(HinhThucKyLuat t) {
        return quyetDinhKyLuatRepository.save(t);
    }


//    public HinhThucKyLuat uploadFileQD(int id, MultipartFile file) throws IOException {
//        String fileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s", "");
//        HinhThucKyLuat qd = quyetDinhKyLuatRepository.findQuyetDinhKyLuatByIdQdkl(id);
//        qd.setTenFile(fileName);
//        qd.setFileKy(file.getBytes());
//        return quyetDinhKyLuatRepository.save(qd);
//    }

//    public byte[] downloadFile(int fileID) {
//        Optional<HinhThucKyLuat> dbFileData = quyetDinhKyLuatRepository.findById(fileID);
//        return dbFileData.get().getFileKy();
//    }
}
