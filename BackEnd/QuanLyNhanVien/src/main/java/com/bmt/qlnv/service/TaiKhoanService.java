package com.bmt.qlnv.service;

import com.bmt.qlnv.models.TaiKhoan;
import com.bmt.qlnv.repository.ITaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaiKhoanService {
    private final ITaiKhoanRepository taiKhoanRepository;

    @Autowired
    public TaiKhoanService(ITaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanRepository.findAll();
    }

    public TaiKhoan getTKById(int id) {
        return taiKhoanRepository.findTaiKhoanById(id);
    }

    public TaiKhoan getTKByUsernameAndPassword(String u, String p) {
        TaiKhoan tk = taiKhoanRepository.findTaiKhoanByTenDangNhapAndMatKhau(u, p);
        if (tk != null) {
            return taiKhoanRepository.findTaiKhoanByTenDangNhapAndMatKhau(u, p);
        } else {
            return null;
        }
    }

    public TaiKhoan getTKByUsername(String u) {
        return taiKhoanRepository.findTaiKhoanByTenDangNhap(u);
    }

    public ArrayList<TaiKhoan> listTKByUsername(String u) {
        return taiKhoanRepository.findByTenDangNhap(u);
    }

    public TaiKhoan insertTK(TaiKhoan t) {
        if (taiKhoanRepository.findTaiKhoanByTenDangNhap(t.getTenDangNhap()) != null) {
            return null;
        }
        return taiKhoanRepository.save(t);
    }

    public TaiKhoan updateTTTK(int id, TaiKhoan tk) {
        TaiKhoan edit = taiKhoanRepository.findTaiKhoanById(id);
        if (edit != null) {
            edit.setHoVaTen(tk.getHoVaTen());
            edit.setEmail(tk.getEmail());
            edit.setDienThoaiDiDong(tk.getDienThoaiDiDong());
            edit.setSoCmnd(tk.getSoCmnd());
            return taiKhoanRepository.save(edit);
        } else {
            return null;
        }
    }

    public TaiKhoan updateQandTT(int id, TaiKhoan tk) {
        TaiKhoan edit = taiKhoanRepository.findTaiKhoanById(id);
        if (edit != null) {
            edit.setTenDangNhap(tk.getTenDangNhap());

            edit.setQuyen(tk.getQuyen());
            edit.setKichHoat(tk.getKichHoat());
            return taiKhoanRepository.save(edit);
        } else {
            return null;
        }
    }

    public TaiKhoan updateMK(int id, String pw) {
        TaiKhoan edit = taiKhoanRepository.findTaiKhoanById(id);
        if (edit != null) {
            edit.setMatKhau(pw);
            return taiKhoanRepository.save(edit);
        } else {
            return null;
        }
    }

    public void delete(int id) {
        taiKhoanRepository.deleteById(id);
    }

    public TaiKhoan updateMK(String user, String passwdChange) {
        TaiKhoan edit = taiKhoanRepository.findTaiKhoanByTenDangNhap(user);
        edit.setMatKhau(passwdChange);
        return taiKhoanRepository.save(edit);
    }


}
