package com.bmt.qlnv.Controllers;

import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.DuAn;
import com.bmt.qlnv.service.IDuAnService;
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
public class DuAnController {
    IDuAnService duAnService;

    @Autowired
    public DuAnController(IDuAnService duAnService) {
        this.duAnService = duAnService;
    }


    @GetMapping("/duan/list")
    public ResponseEntity<List<DuAn>> getAllDuAn() throws Throwable {
        try {
            List<DuAn> listDuAn;
            listDuAn = duAnService.getAllListDuAn();

            return new ResponseEntity<>(listDuAn, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/duan/add")
    public ResponseEntity<DuAn> createDuAn(@RequestBody DuAn da) throws ParseException, SQLException {
        DuAn d = duAnService.insertDuAn(da);
        if (d == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }

    @PutMapping("/duan/{id}")
    public ResponseEntity<DuAn> editDuAn(@RequestBody DuAn da, @PathVariable long id) throws ParseException, SQLException {
        DuAn d = duAnService.updateDuAn(da, id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PutMapping("/duan/addnhanvien")
    public ResponseEntity<DuAn> editDuAnNhanVien(@RequestBody List<Long> da,
                                                 @RequestParam(name = "id") long id) throws ParseException, SQLException {
        DuAn d = duAnService.updateNhanVienDuAn(da, id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @GetMapping("/duan/{id}")
    public ResponseEntity<DuAn> getDuAnByTen(@PathVariable long id) throws ParseException, SQLException {
        DuAn d = duAnService.getByIdDuAn(id);
        if (d == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/duan/{id}")
    public ResponseEntity<DonVi> deleteDonVi(@PathVariable long id) throws ParseException, SQLException {
        duAnService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/duan/delete/nhanvien")
    public ResponseEntity<DuAn> deleteDonVi(@RequestParam long idda,
                                            @RequestBody List<Long> idnvArr) throws ParseException, SQLException {
        try {
          DuAn d =   duAnService.deleteNhanVienDuAn(idda, idnvArr);

            return new ResponseEntity<>(d, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
