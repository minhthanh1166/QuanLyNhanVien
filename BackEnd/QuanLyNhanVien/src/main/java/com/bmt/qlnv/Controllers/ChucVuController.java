package com.bmt.qlnv.Controllers;


import com.bmt.qlnv.models.ChucVu;
import com.bmt.qlnv.service.IChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChucVuController {
    private final IChucVuService chucVuService;


    @Autowired
    public ChucVuController(IChucVuService chucVuService) {
        this.chucVuService = chucVuService;
    }

    @GetMapping("/chucvu/list")
    public ResponseEntity<List<ChucVu>> getAll() throws SQLException {
        List<ChucVu> ds =  chucVuService.getAllChucVu();
        return new ResponseEntity<>(ds, HttpStatus.OK);
    }

    @GetMapping("/chucvu/{id}")
    public ResponseEntity<ChucVu> getById(@PathVariable String id) throws ParseException, SQLException {
        try {
            ChucVu d = chucVuService.getByIdChucVu(id);
            return new ResponseEntity<>(d, HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/chucvu/add")
    public ResponseEntity<ChucVu> createChucVu(@RequestBody ChucVu entity) throws ParseException, SQLException {
       try {
           ChucVu d = chucVuService.insert(entity);
           return new ResponseEntity<>(d, HttpStatus.CREATED);
       }
       catch (Exception e){
           System.out.println(e.getMessage());
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PutMapping("/chucvu/{id}")
    public ResponseEntity<ChucVu> updateChucVu(@PathVariable String id, @RequestBody ChucVu entity) throws ParseException, SQLException {
       try {
           ChucVu d = chucVuService.update(id, entity);
           return new ResponseEntity<>(d, HttpStatus.ACCEPTED);
       }
       catch (Exception e){
           System.out.println(e.getMessage());
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/chucvu/{id}")
    public ResponseEntity<ChucVu> deleteById(@PathVariable String id) throws ParseException, SQLException {
        try{
            chucVuService.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
