package com.bmt.qlnv.Controllers;

import com.bmt.qlnv.models.TinhLuong;
import com.bmt.qlnv.service.TinhLuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TinhLuongController {
    private final TinhLuongService tinhLuongService;

    @Autowired
    public TinhLuongController(TinhLuongService tinhLuongService) {
        this.tinhLuongService = tinhLuongService;
    }


    @GetMapping("/tinhluong/list")
    public ResponseEntity<List<TinhLuong>> getAll() throws SQLException {
        List<TinhLuong> ltinhLuong =  tinhLuongService.getAllTinhLuong();
        return new ResponseEntity<>(ltinhLuong, HttpStatus.OK);
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
