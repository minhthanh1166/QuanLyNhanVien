package com.bmt.qlnv.service;

import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.models.PhongBan;
import com.bmt.qlnv.models.TinhLuong;
import com.bmt.qlnv.repository.IDonViRepository;
import com.bmt.qlnv.repository.IHoSoRepository;
import com.bmt.qlnv.repository.IPhongBanRepository;
import com.bmt.qlnv.repository.ITinhLuongReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TinhLuongService implements ITinhLuongService{

    private final ITinhLuongReponsitory iTinhLuongReponsitory;
    private final IHoSoRepository iHoSoRepository;
    private final IDonViRepository iDonViRepository;
    private final IPhongBanRepository iPhongBanRepository;

    private static  LocalDate currentDate = LocalDate.now();

    @Autowired
    public TinhLuongService(ITinhLuongReponsitory iTinhLuongReponsitory, IHoSoRepository iHoSoRepository, IDonViRepository iDonViRepository, IPhongBanRepository iPhongBanRepository) {
        this.iTinhLuongReponsitory = iTinhLuongReponsitory;
        this.iHoSoRepository = iHoSoRepository;
        this.iDonViRepository = iDonViRepository;
        this.iPhongBanRepository = iPhongBanRepository;
    }

    @Override
    public List<TinhLuong> getAllTinhLuong() {
        return iTinhLuongReponsitory.findAll();
    }

    @Override
    public List<TinhLuong> searchAllHoSoByName(HoSo maHoSo) {
        return iTinhLuongReponsitory.findByHoso(maHoSo);
    }

    @Override
    public List<TinhLuong> searchAllHoSoByDonVi(DonVi maDV) {
        return iTinhLuongReponsitory.findHoSoByDonVi(maDV);
    }

    @Override
    public List<TinhLuong> searchAllHoSoByPhongBan(PhongBan maPB) {
        return iTinhLuongReponsitory.findHoSoByPhongBan(maPB);
    }

    @Override
    public TinhLuong getByIdTinhLuong(long id) {
        return iTinhLuongReponsitory.findTinhLuongByIdTinhLuong(id);
    }

    @Override
    public void deleteById(long id) {
        iTinhLuongReponsitory.deleteById(id);
    }

    @Override
    public TinhLuong insertTinhLuong(TinhLuong tinhLuong) {
        if(tinhLuong.getLuongCoBan() != 0){
            int daysInMonth = currentDate.lengthOfMonth();
            tinhLuong.setLuongChinhThuc((((tinhLuong.getLuongCoBan() * tinhLuong.getHeSoLuong()) / daysInMonth - 4) * tinhLuong.getSoNgayDiLam()) + tinhLuong.getPhuCap());
        }
        return iTinhLuongReponsitory.save(tinhLuong);
    }

    @Override
    public TinhLuong updateTinhLuong(long id, TinhLuong tinhLuong) {
        TinhLuong tl = iTinhLuongReponsitory.findTinhLuongByIdTinhLuong(id);
        if(tl != null){
            tl.setHoso(tinhLuong.getHoso());
            tl.setDonVi(tinhLuong.getDonVi());
            tl.setPhongBan(tinhLuong.getPhongBan());
            tl.setHeSoLuong(tinhLuong.getHeSoLuong());
            tl.setLuongCoBan(tinhLuong.getLuongCoBan());
            tl.setPhuCap(tinhLuong.getPhuCap());
            tl.setHeSoLuong(tinhLuong.getHeSoLuong());
            tl.setGhiChu(tinhLuong.getGhiChu());
            tl.setThoiGianCapNhat(new Date());
            tl.setSoNgayDiLam(tinhLuong.getSoNgayDiLam());
            if(tinhLuong.getLuongCoBan() != 0 && tinhLuong.getSoNgayDiLam() != 0){

                int daysInMonth = currentDate.lengthOfMonth();

                tl.setLuongChinhThuc((((tinhLuong.getLuongCoBan() * tinhLuong.getHeSoLuong()) / daysInMonth - 4) * tinhLuong.getSoNgayDiLam()) + tinhLuong.getPhuCap());
            }
            System.out.println(tinhLuong.getSoNgayDiLam());
            return iTinhLuongReponsitory.save(tl);
        }else{
            return null;
        }
    }
}
