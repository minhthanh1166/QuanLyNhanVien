package com.bmt.qlnv.Controllers;


import com.bmt.qlnv.models.TonGiao;
import com.bmt.qlnv.service.TonGiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TonGiaoController {

    private final TonGiaoService tgService;
    @Autowired
    public TonGiaoController(TonGiaoService tgService) {
        this.tgService = tgService;
    }

    @GetMapping("/tongiao/list")
    public ResponseEntity<List<TonGiao>> getAll() throws SQLException {
        List<TonGiao> listObj =  tgService.getAll();
        return new ResponseEntity<>(listObj, HttpStatus.OK);
    }

    @GetMapping("/tongiao/{id}")
    public ResponseEntity<TonGiao> getById(@PathVariable int id) throws ParseException, SQLException {
        TonGiao d = tgService.getById(id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PostMapping("/tongiao/add")
    public ResponseEntity<TonGiao> createTonGiao(@RequestBody TonGiao tg) throws ParseException, SQLException {
        TonGiao d = tgService.insert(tg);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PutMapping("/tongiao/{id}")
    public ResponseEntity<TonGiao> updateTonGiao(@PathVariable int id, @RequestBody TonGiao tg) throws ParseException, SQLException {
        TonGiao d = tgService.update(id, tg);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/tongiao/{id}")
    public ResponseEntity<TonGiao> deleteById(@PathVariable int id) throws ParseException, SQLException {
        try{
            tgService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
