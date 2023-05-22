package com.bmt.qlnv.Controllers;

import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.models.PhongBan;
import com.bmt.qlnv.models.TinhLuong;
import com.bmt.qlnv.service.DonViServiceImpl;
import com.bmt.qlnv.service.HoSoServiceImpl;
import com.bmt.qlnv.service.PhongBanServiceImpl;
import com.bmt.qlnv.service.TinhLuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TinhLuongController {
    private final TinhLuongService tinhLuongService;
    private final HoSoServiceImpl hoSoService;
    private final DonViServiceImpl donViService;
    private final PhongBanServiceImpl phongBanService;

    @Autowired
    public TinhLuongController(TinhLuongService tinhLuongService, HoSoServiceImpl hoSoService, DonViServiceImpl donViService, PhongBanServiceImpl phongBanService) {
        this.tinhLuongService = tinhLuongService;
        this.hoSoService = hoSoService;
        this.donViService = donViService;
        this.phongBanService = phongBanService;
    }


//    @GetMapping("/tinhluong/list")
//    public ResponseEntity<List<TinhLuong>> getAll() throws SQLException {
//        List<TinhLuong> ltinhLuong =  tinhLuongService.getAllTinhLuong();
//        return new ResponseEntity<>(ltinhLuong, HttpStatus.OK);
//    }

    @GetMapping("/tinhluong/list")
    public ResponseEntity<List<TinhLuong>> getAllTinhLuong(@RequestParam(required = false, name = "mahs") Long maHoSo,
                                                           @RequestParam(required = false, name = "madv") String maDV,
                                                           @RequestParam(required = false, name = "mapb") String maPB) {
        try {
            List<TinhLuong> listTinhLuong = new ArrayList<>();

            if (maHoSo != null) {
                HoSo hs = hoSoService.getByIdHoSo(maHoSo);
                listTinhLuong = tinhLuongService.searchAllHoSoByName(hs);
            } else if (maDV != null) {
                DonVi dv = donViService.getByIdDonVi(maDV);
                listTinhLuong = tinhLuongService.searchAllHoSoByDonVi(dv);
            } else if (maPB != null) {
                PhongBan pb = phongBanService.getByIdPhongBan(Long.parseLong(maPB));
                listTinhLuong = tinhLuongService.searchAllHoSoByPhongBan(pb);
            } else {
                listTinhLuong = tinhLuongService.getAllTinhLuong();
            }

            return new ResponseEntity<>(listTinhLuong, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/tinhluong/get/{id}")
    public ResponseEntity<TinhLuong> getById(@PathVariable long id) throws ParseException, SQLException {
        TinhLuong d = tinhLuongService.getByIdTinhLuong(id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PostMapping("/tinhluong/add")
    public ResponseEntity<TinhLuong> createTinhLuong(@RequestBody TinhLuong tinhLuong) throws ParseException, SQLException {
        TinhLuong d = tinhLuongService.insertTinhLuong(tinhLuong);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PutMapping("/tinhluong/{id}")
    public ResponseEntity<TinhLuong> updateTinhLuong(@PathVariable long id, @RequestBody TinhLuong tinhLuong) throws ParseException, SQLException {
        TinhLuong d = tinhLuongService.updateTinhLuong(id, tinhLuong);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/tinhluong/{id}")
    public ResponseEntity<TinhLuong> deleteById(@PathVariable long id) throws ParseException, SQLException {
        try{
            tinhLuongService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
