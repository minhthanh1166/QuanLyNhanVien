package com.bmt.qlnv.Controllers;

import com.bmt.qlnv.models.TaiKhoan;
import com.bmt.qlnv.models.TonGiao;
import com.bmt.qlnv.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("localhost:4200")
@RequestMapping("/api")
public class TaiKhoanController {
    private final TaiKhoanService tkService;

    @Autowired
    public TaiKhoanController(TaiKhoanService tkService) {
        this.tkService = tkService;
    }


    @GetMapping("/taikhoan/{id}")
    public ResponseEntity<TaiKhoan> getById(@PathVariable int id) throws ParseException, SQLException {
        try {
            TaiKhoan d = tkService.getTKById(id);
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/taikhoan/list")
    public ResponseEntity<List<TaiKhoan>> getAll() throws ParseException, SQLException {
        try {
            List<TaiKhoan> d = tkService.getAllTaiKhoan();
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/taikhoan")
    public ResponseEntity<TaiKhoan> getByUserName(@RequestParam() String u) throws ParseException, SQLException {
        try {
            TaiKhoan d = tkService.getTKByUsername(u);
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/taikhoan/listbyusername")
    public ResponseEntity<ArrayList<TaiKhoan>> listByUserName(@RequestParam() String u) throws ParseException, SQLException {
        try {
            ArrayList<TaiKhoan> d = tkService.listTKByUsername(u);
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/taikhoan")
    public ResponseEntity<TaiKhoan> getTKByUandP(@RequestParam(required = false, name = "u") String username,
                                                 @RequestParam(required = false, name = "p") String password) throws ParseException, SQLException {
        try {
            TaiKhoan d = tkService.getTKByUsernameAndPassword(username, password);
            return new ResponseEntity<>(d, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/taikhoan/add")
    public ResponseEntity<TaiKhoan> addTaiKhoan(@RequestBody TaiKhoan tk) throws Throwable {
        try {
            TaiKhoan ins = tkService.insertTK(tk);
            if (ins != null) {
                return new ResponseEntity<>(ins, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/taikhoan/update")
    public ResponseEntity<TaiKhoan> putTK(@RequestParam("id") int id,
                                        @RequestBody TaiKhoan tk) {
        try {
            TaiKhoan putById = tkService.updateTTTK(id, tk);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/taikhoan/update/quyen")
    public ResponseEntity<TaiKhoan> putQuyenTK(@RequestParam("id") int id,
                                          @RequestBody TaiKhoan tk) {
        try {
            TaiKhoan putById = tkService.updateQandTT(id, tk);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/taikhoan/update/mk")
    public ResponseEntity<TaiKhoan> putQuyenTK(@RequestParam("id") int id,
                                               @RequestParam("mk") String mk) {
        try {
            TaiKhoan putById = tkService.updateMK(id, mk);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/taikhoan/{id}")
    public ResponseEntity<TonGiao> deleteById(@PathVariable int id) throws ParseException, SQLException {
        try{
            tkService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
