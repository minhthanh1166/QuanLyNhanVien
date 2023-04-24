package com.bmt.qlnv.Controllers;


import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.service.IDonViService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DonViController {
    IDonViService donViService;

    @Autowired
    public DonViController(IDonViService donViService) {
        this.donViService = donViService;
    }


    @GetMapping("/donvi/list")
    public ResponseEntity<List<DonVi>> getAllDonVi() throws Throwable {
        try {
            List<DonVi> listDonVi;
            listDonVi = donViService.getAllDonVi();

            return new ResponseEntity<>(listDonVi, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/donvi/add")
    public ResponseEntity<DonVi> createDonVi(@RequestBody DonVi dv) throws ParseException, SQLException {
        DonVi d = donViService.insert(dv);
        if (d == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }

    @PutMapping("/donvi/{id}")
    public ResponseEntity<DonVi> editDonVi(@PathVariable String id, @RequestBody DonVi dv) throws ParseException, SQLException {
        DonVi d = donViService.update(id, dv);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @GetMapping("/donvi")
    public ResponseEntity<DonVi> getDonViByID(@RequestParam(name = "id")
                                              String id) throws ParseException, SQLException {
        DonVi d = donViService.getByIdDonVi(id);
        if (d == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(d, HttpStatus.OK);
    }
    @GetMapping("/donvi/{ten}")
    public ResponseEntity<DonVi> getDonViByTen(@PathVariable String ten) throws ParseException, SQLException {
        DonVi d = donViService.getDonViByName(ten);
        if (d == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/donvi/{id}")
    public ResponseEntity<DonVi> deleteDonVi(@PathVariable String id) throws ParseException, SQLException {
        donViService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
