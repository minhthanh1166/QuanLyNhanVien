package com.bmt.qlnv.Controllers;


import com.bmt.qlnv.models.HinhThucKhenThuong;
import com.bmt.qlnv.models.HinhThucKyLuat;
import com.bmt.qlnv.service.HinhThucKyLuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HinhThucKyLuatController {
    private final HinhThucKyLuatService htklService;

    @Autowired
    public HinhThucKyLuatController(HinhThucKyLuatService htklService) {
        this.htklService = htklService;
    }

    @GetMapping("/htkl/list")
    public ResponseEntity<List<HinhThucKyLuat>> getAllQuyetDinhKyLuat(@RequestParam(required = false, name = "donvi") String donVi) throws Throwable {
        try {
            List<HinhThucKyLuat> ds;
            ds = htklService.getAll();
            return new ResponseEntity<>(ds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/htkl/add")
    public ResponseEntity<HinhThucKyLuat> createQuyetDinhKyLuat(@RequestBody HinhThucKyLuat item) throws ParseException, SQLException {
        try {
            HinhThucKyLuat d = htklService.insertQD(item);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/htkl/{id}")
    public ResponseEntity<HinhThucKhenThuong> deleteById(@PathVariable int id) throws ParseException, SQLException {
        try {
            htklService.deleteQD(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/htkl/{id}")
    public ResponseEntity<HinhThucKyLuat> updateKL(@PathVariable int id,
                                                       @RequestBody HinhThucKyLuat kl) throws ParseException, SQLException {
        HinhThucKyLuat d = htklService.updateQD(id, kl);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

//    @PutMapping("/htkl/uploadfile")
//    public ResponseEntity<?> uploadFileQuyetDinhKL(
//            @RequestParam(name = "id") int id,
//            @RequestPart(name = "file") MultipartFile file) throws ParseException, SQLException {
//        try {
//
//            HinhThucKyLuat d = htklService.uploadFileQD(id, file);
//            return new ResponseEntity<>(d, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @GetMapping("htkl/open/{id}")
//    public ResponseEntity<?> downloadFile(@PathVariable int id) {
//        byte[] fileData = htklService.downloadFile(id);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("application/pdf"))
//                .body(fileData);
//    }


}
