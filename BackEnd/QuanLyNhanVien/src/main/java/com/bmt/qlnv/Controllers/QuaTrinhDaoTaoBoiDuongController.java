package com.bmt.qlnv.Controllers;


import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.models.QuaTrinhDaoTaoBoiDuong;
import com.bmt.qlnv.service.HoSoServiceImpl;
import com.bmt.qlnv.service.QuaTrinhDaoTaoBoiDuongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuaTrinhDaoTaoBoiDuongController {
    @Autowired
    private QuaTrinhDaoTaoBoiDuongServiceImpl dtService;
    @Autowired
    private HoSoServiceImpl hoSoService;
    @GetMapping("/quatrinhdtbd/list")
    public ResponseEntity<List<QuaTrinhDaoTaoBoiDuong>> getAll() throws SQLException {
        List<QuaTrinhDaoTaoBoiDuong> ldt =  dtService.getAllQuaTrinhDaoTaoBoiDuong();
        return new ResponseEntity<>(ldt, HttpStatus.OK);
    }

    @GetMapping("/quatrinhdtbd/listbyhoso/{idhoso}")
    public ResponseEntity<List<QuaTrinhDaoTaoBoiDuong>> getAllByHS(@PathVariable long idhoso) throws SQLException {
        HoSo h = hoSoService.getByIdHoSo(idhoso);
        List<QuaTrinhDaoTaoBoiDuong> ldt =  dtService.getAllQuaTrinhDaoTaoBoiDuongByHoSo(h);
        return new ResponseEntity<>(ldt, HttpStatus.OK);
    }

    @GetMapping("/quatrinhdtbd/get/{id}")
    public ResponseEntity<QuaTrinhDaoTaoBoiDuong> getById(@PathVariable long id) throws ParseException, SQLException {
        QuaTrinhDaoTaoBoiDuong d = dtService.getByIdQuaTrinhDaoTaoBoiDuong(id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PostMapping("/quatrinhdtbd/add")
    public ResponseEntity<QuaTrinhDaoTaoBoiDuong> createQuaTrinhDaoTaoBoiDuong(@RequestBody QuaTrinhDaoTaoBoiDuong dt) throws ParseException, SQLException {
        QuaTrinhDaoTaoBoiDuong d = dtService.insert(dt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }
    @PutMapping("/quatrinhdtbd/{id}")
    public ResponseEntity<QuaTrinhDaoTaoBoiDuong> updateQuaTrinhDaoTaoBoiDuong(@PathVariable long id,
                                                   @RequestBody QuaTrinhDaoTaoBoiDuong dt) throws ParseException, SQLException {
        QuaTrinhDaoTaoBoiDuong d = dtService.update(id, dt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/quatrinhdtbd/{id}")
    public ResponseEntity<QuaTrinhDaoTaoBoiDuong> deleteById(@PathVariable int id) throws ParseException, SQLException {
       try{
           dtService.delete(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
