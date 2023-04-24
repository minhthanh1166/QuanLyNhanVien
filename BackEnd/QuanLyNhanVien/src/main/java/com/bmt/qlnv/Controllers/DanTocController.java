package com.bmt.qlnv.Controllers;

import com.bmt.qlnv.models.DanToc;
import com.bmt.qlnv.service.DanTocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DanTocController {
    @Autowired
    private DanTocService dtService;

    @GetMapping("/dantoc/list")
    public ResponseEntity<List<DanToc>> getAll() throws SQLException {
        List<DanToc> ldt =  dtService.getAll();
        return new ResponseEntity<>(ldt, HttpStatus.OK);
    }

    @GetMapping("/dantoc/get/{id}")
    public ResponseEntity<DanToc> getById(@PathVariable int id) throws ParseException, SQLException {
        DanToc d = dtService.getById(id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PostMapping("/dantoc/add")
    public ResponseEntity<DanToc> createDanToc(@RequestBody DanToc dt) throws ParseException, SQLException {
        DanToc d = dtService.insert(dt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PutMapping("/dantoc/{id}")
    public ResponseEntity<DanToc> updateDanToc(@PathVariable int id, @RequestBody DanToc dt) throws ParseException, SQLException {
        DanToc d = dtService.update(id, dt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/dantoc/{id}")
    public ResponseEntity<DanToc> deleteById(@PathVariable int id) throws ParseException, SQLException {
       try{
           dtService.delete(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
