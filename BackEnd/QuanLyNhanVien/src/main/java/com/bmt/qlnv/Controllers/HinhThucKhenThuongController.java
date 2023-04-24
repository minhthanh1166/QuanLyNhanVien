package com.bmt.qlnv.Controllers;


import com.bmt.qlnv.models.HinhThucKhenThuong;
import com.bmt.qlnv.service.HinhThucKhenThuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class HinhThucKhenThuongController {
    private final HinhThucKhenThuongService htktService;

    @Autowired
    public HinhThucKhenThuongController(HinhThucKhenThuongService htktService) {
        this.htktService = htktService;
    }

    @GetMapping("/htkt/list")
    public ResponseEntity<List<HinhThucKhenThuong>> getAllQuyetDinhKhenThuong(@RequestParam(required = false, name = "donvi") String donVi) throws Throwable {
        try {
            List<HinhThucKhenThuong> ds = htktService.getAll();
            return new ResponseEntity<>(ds, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/htkt/add")
    public ResponseEntity<HinhThucKhenThuong> createQuyetDinhKhenThuong(
            @RequestBody() HinhThucKhenThuong htkt) throws ParseException, SQLException {
        try {
            HinhThucKhenThuong d = htktService.insertQD(htkt);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/htkt/add")
//    public ResponseEntity<HinhThucKhenThuong> createQuyetDinhKhenThuong(
//            @RequestBody() HinhThucKhenThuong htkt,
//            @RequestPart(name = "file", required = false) MultipartFile file) throws ParseException, SQLException {
//        try {
//
//            HinhThucKhenThuong d = htktService.insertQD(htkt);
//            return new ResponseEntity<>(d, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @PutMapping("/htkt/uploadfile")
//    public ResponseEntity<?> uploadFileQuyetDinhKhenThuong(
//            @RequestParam(name = "id") int id,
//            @RequestPart(name = "file") MultipartFile file) throws ParseException, SQLException {
//        try {
//
//            HinhThucKhenThuong d = htktService.uploadFileQD(id, file);
//            return new ResponseEntity<>(d, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/htkt/{id}")
    public ResponseEntity<HinhThucKhenThuong> updateKT(@PathVariable int id, @RequestBody HinhThucKhenThuong kt) throws ParseException, SQLException {
        HinhThucKhenThuong d = htktService.updateQD(id, kt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/htkt/{id}")
    public ResponseEntity<HinhThucKhenThuong> deleteById(@PathVariable int id) throws ParseException, SQLException {
        try {
            htktService.deleteQD(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @GetMapping("htkt/open/{id}")
//    public ResponseEntity<?> downloadFile(@PathVariable int id) {
//        byte[] fileData = htktService.downloadFile(id);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(fileData);
//    }

}
