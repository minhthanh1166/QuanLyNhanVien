package com.bmt.qlnv.Controllers;


import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.models.PhongBan;
import com.bmt.qlnv.service.IDonViService;
import com.bmt.qlnv.service.IHoSoService;
import com.bmt.qlnv.service.IPhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HoSoController {
    IHoSoService hoSoService;

    @Autowired
    IDonViService donViService;
    @Autowired
    IPhongBanService phongBanService;

    @Autowired
    public HoSoController(IHoSoService hoSoService) {
        this.hoSoService = hoSoService;
    }

    @GetMapping("/hoso/list")
    public ResponseEntity<List<HoSo>> getAllHoSo(@RequestParam(required = false, name = "hoten") String hoTen,
                                                 @RequestParam(required = false, name = "madv") String maDV,
                                                 @RequestParam(required = false, name = "mapb") String maPB) throws Throwable {
        try {
            List<HoSo> listHoSo;
            if (hoTen != null) {
                listHoSo = hoSoService.searchAllHoSoByName(hoTen);
            } else if (maDV != null) {
                DonVi dv = donViService.getByIdDonVi(maDV);
                listHoSo = hoSoService.searchAllHoSoByDonVi(dv);
            }
            else if (maPB != null) {
                PhongBan pb = phongBanService.getByIdPhongBan(Long.parseLong(maPB));
                listHoSo = hoSoService.searchAllHoSoByPhongBan(pb);
            }
            else {
                listHoSo = hoSoService.getAllHoSo();
            }

            return new ResponseEntity<>(listHoSo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/hoso/get")
    public ResponseEntity<HoSo> getHoSoByID(@RequestParam(name = "id") Long id) throws Throwable {
        try {
            HoSo hoSo;
            hoSo = hoSoService.getByIdHoSo(id);
            return new ResponseEntity<>(hoSo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/hoso/add")
    public ResponseEntity<HoSo> addHoSo(@RequestBody HoSo hoSo) throws Throwable {
        try {
            HoSo ins = hoSoService.insert(hoSo);
            if (ins != null) {
                return new ResponseEntity<>(ins, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/hoso/update")
    public ResponseEntity<HoSo> putHoSo(@RequestParam("id") long idhs, @RequestBody HoSo hoSo) {
        try {
            HoSo putById = hoSoService.update(idhs, hoSo);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hoso/upload-image")
    public ResponseEntity<?> uploadFileImage(
            @RequestParam(name="id") long id,
            @RequestPart(name="file") MultipartFile file) throws ParseException, SQLException {
        try {

            HoSo d = hoSoService.uploadImage(id, file);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("hoso/open/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable long id){
        byte[] fileData = hoSoService.downloadFile(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_JPEG)
                .body(fileData);
    }

//    @PutMapping("/hoso/updateheso")
//    public ResponseEntity<HoSo> putHoSoMucLuong(@RequestParam("bac") int bac,
//                                                @RequestParam("heso") double heso,
//                                                @RequestParam("macb") long macb) {
//        try {
//            HoSo putById = hoSoService.updateMucLuong(bac, heso, macb);
//            return new ResponseEntity<>(putById, HttpStatus.OK);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



    @PutMapping("/hoso/danhgia")
    public ResponseEntity<HoSo> putHoSoDanhGia(@RequestBody() String dg,
                                                @RequestParam("ngaydg") String ngayDG,
                                                @RequestParam("id") long macb) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
            Date date = sdf.parse(ngayDG);
            HoSo putById = hoSoService.updateDanhGia(date, dg, macb);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hoso/khenthuong")
    public ResponseEntity<HoSo> putHoSoKhenThuong(@RequestBody() String dg,
                                               @RequestParam("soqd") String soQD,
                                               @RequestParam("ngayqd") String ngayQD,
                                               @RequestParam("id") long macb) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
            Date date = sdf.parse(ngayQD);
            HoSo putById = hoSoService.updateKhenThuong(soQD, date, dg, macb);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hoso/kyluat")
    public ResponseEntity<HoSo> putHoSoKyLuat(@RequestBody() String dg,
                                                  @RequestParam("soqd") String soQD,
                                                  @RequestParam("ngayqd") String ngayQD,
                                                  @RequestParam("id") long macb) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
            Date date = sdf.parse(ngayQD);
            HoSo putById = hoSoService.updateKyLuat(soQD, date, dg, macb);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hoso/daotaoboiduong")
    public ResponseEntity<HoSo> putHoSoDTBD(@RequestBody() String trangThaiDTBD,
                                              @RequestParam("tencn") String tenCNDTBD,
                                              @RequestParam("ngayguidtbd") String ngayGuiDTBD,
                                              @RequestParam("id") long macb) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
            Date date = sdf.parse(ngayGuiDTBD);
            HoSo putById = hoSoService.updateQTDT(date, tenCNDTBD, trangThaiDTBD, macb);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/hoso/delete")
    public ResponseEntity<HoSo> deleteHoSo(@RequestParam("id") long idhs) {
        try {
            hoSoService.delete(idhs);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
