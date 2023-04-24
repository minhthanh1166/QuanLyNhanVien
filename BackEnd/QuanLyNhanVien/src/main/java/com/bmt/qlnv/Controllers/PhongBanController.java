package com.bmt.qlnv.Controllers;


import com.bmt.qlnv.models.DonVi;
import com.bmt.qlnv.models.PhongBan;
import com.bmt.qlnv.service.PhongBanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhongBanController {
    @Autowired
    private PhongBanServiceImpl dtService;

    @GetMapping("/phongban/list")
    public ResponseEntity<List<PhongBan>> getAll() throws SQLException {
        List<PhongBan> ldt =  dtService.getAllPhongBan();
        return new ResponseEntity<>(ldt, HttpStatus.OK);
    }

    @PostMapping("/phongban/listbydonvi")
    public ResponseEntity<List<PhongBan>> getAllByDonVi(@RequestBody DonVi dv) throws SQLException {
        List<PhongBan> ldt =  dtService.getAllPhongBanByDonVi(dv);
        return new ResponseEntity<>(ldt, HttpStatus.OK);
    }

    @GetMapping("/phongban/get/{id}")
    public ResponseEntity<PhongBan> getById(@PathVariable long id) throws ParseException, SQLException {
        PhongBan d = dtService.getByIdPhongBan(id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PostMapping("/phongban/add")
    public ResponseEntity<PhongBan> createPhongBan(@RequestBody PhongBan dt) throws ParseException, SQLException {
        PhongBan d = dtService.insert(dt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }
    @PutMapping("/phongban/{id}")
    public ResponseEntity<PhongBan> updatePhongBan(@PathVariable long id,
                                                   @RequestBody PhongBan dt) throws ParseException, SQLException {
        PhongBan d = dtService.update(id, dt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/phongban/{id}")
    public ResponseEntity<PhongBan> deleteById(@PathVariable int id) throws ParseException, SQLException {
       try{
           dtService.delete(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
