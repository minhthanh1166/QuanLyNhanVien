package com.bmt.qlnv.service;


import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.models.PhongBan;
import com.bmt.qlnv.repository.IHoSoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HoSoServiceImpl implements IHoSoService {
    IHoSoRepository hoSoRepository;

    @Autowired
    public HoSoServiceImpl(IHoSoRepository hoSoRepository) {
        this.hoSoRepository = hoSoRepository;
    }

    @Override
    public List<HoSo> getAllHoSo() {
        return hoSoRepository.findAll();
    }

    public List<HoSo> searchAllHoSoByName(String name) {
        return hoSoRepository.findByHoVaTen(name);
    }

    public List<HoSo> searchAllHoSoByDonVi(DonVi maDV) {
        return hoSoRepository.findHoSoByDonVi(maDV);
    }

    @Override
    public List<HoSo> searchAllHoSoByPhongBan(PhongBan maPB) {
        return hoSoRepository.findHoSoByPhongBan(maPB);
    }

    @Override
    public void delete(long id) {
        hoSoRepository.deleteById(id);
    }

    @Override
    public HoSo getByIdHoSo(long id) {
        return hoSoRepository.findByIdHoSo(id);
    }

    @Override
    public HoSo update(long id, HoSo hoSo) {
        if (hoSo != null) {
            HoSo editItem = hoSoRepository.findByIdHoSo(id);
            if (editItem != null) {
                editItem.setSoHieuNhanVien(hoSo.getSoHieuNhanVien());
                editItem.setDonVi(hoSo.getDonVi());
                editItem.setPhongBan(hoSo.getPhongBan());
                editItem.setHoVaTen(hoSo.getHoVaTen());
                editItem.setNgaySinh(hoSo.getNgaySinh());
                editItem.setGioiTinh(hoSo.getGioiTinh());
                editItem.setNoiSinh(hoSo.getNoiSinh());
                editItem.setHoKhauThuongTru(hoSo.getHoKhauThuongTru());
                editItem.setNoiOHienTai(hoSo.getNoiOHienTai());
                editItem.setDanToc(hoSo.getDanToc());
                editItem.setTonGiao(hoSo.getTonGiao());
                editItem.setSoCmnd(hoSo.getSoCmnd());
                editItem.setChucVu(hoSo.getChucVu());
                editItem.setNgayBoNhiem(hoSo.getNgayBoNhiem());
                editItem.setTrinhDoGDPT(hoSo.getTrinhDoGDPT());
                editItem.setTrinhDoChuyenMon(hoSo.getTrinhDoChuyenMon());
                editItem.setHocVi(hoSo.getHocVi());
                editItem.setHocHam(hoSo.getHocHam());
                editItem.setNgoaiNgu(hoSo.getNgoaiNgu());
                editItem.setSoBaoHiemXh(hoSo.getSoBaoHiemXh());
                editItem.setTrangThai(hoSo.getTrangThai());
                editItem.setLuong(hoSo.getLuong());
                editItem.setNgayLapHoSo(hoSo.getNgayLapHoSo());
                return hoSoRepository.save(editItem);
            }
        }
        return null;
    }


    public HoSo updateDanhGia(Date ngayDG, String danhGia, long id) {
        HoSo edt = hoSoRepository.findByIdHoSo(id);
        if (edt != null) {
            edt.setDanhGia(danhGia);
            edt.setNgayDanhGia(ngayDG);
            return hoSoRepository.save(edt);
        }
        return null;
    }

    @Override
    public HoSo updateQTDT(Date ngayDaoTao, String tenChuyenNganhDaoTao,
                             String trangThaiDaoTao, long id) {
        HoSo edt = hoSoRepository.findByIdHoSo(id);
        if (edt != null) {
            edt.setNgayDaoTao(ngayDaoTao);
            edt.setTenChuyenNganhDaoTao(tenChuyenNganhDaoTao);
            edt.setTrangThaiDaoTao(trangThaiDaoTao);
            return hoSoRepository.save(edt);
        }
        return null;
    }


    @Override
    public HoSo updateKhenThuong(String soQD, Date ngayQD, String hinhThuc, long id) {
        HoSo edt = hoSoRepository.findByIdHoSo(id);
        if (edt != null) {
            edt.setQuyetDinhKhenThuong(soQD);
            edt.setHinhThucKhenThuong(hinhThuc);
            edt.setNgayKhenThuong(ngayQD);
            return hoSoRepository.save(edt);
        }
        return null;
    }

    @Override
    public HoSo updateKyLuat(String soQD, Date ngayQD, String hinhThuc, long id) {
        HoSo edt = hoSoRepository.findByIdHoSo(id);
        if (edt != null) {
            edt.setQuyetDinhKyLuat(soQD);
            edt.setHinhThucKyLuat(hinhThuc);
            edt.setNgayKyLuat(ngayQD);
            return hoSoRepository.save(edt);
        }
        return null;
    }

    @Override
    public HoSo insert(HoSo t) {
        if (hoSoRepository.findBySoHieuNhanVien(t.getSoHieuNhanVien()) != null) {
            return null;
        }
        return hoSoRepository.save(t);
    }


    @Override
    public HoSo uploadImage(long id, MultipartFile file) throws IOException {
        String fileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s", "");
        HoSo qd = hoSoRepository.findByIdHoSo(id);
        qd.setImageUrl(file.getBytes());
        return hoSoRepository.save(qd);
    }

    @Override
    public byte[] downloadFile(long fileID) {
        Optional<HoSo> dbFileData = hoSoRepository.findById(fileID);
        return dbFileData.get().getImageUrl();
    }
}
