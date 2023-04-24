package com.bmt.qlnv.service;

import com.bmt.qlnv.models.DanToc;
import com.bmt.qlnv.repository.IDanTocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DanTocService {

    private final IDanTocRepository repo;
    @Autowired
    public DanTocService(IDanTocRepository repo) {
        this.repo = repo;
    }

    public List<DanToc> getAll() {
        List<DanToc> listFromDb = new ArrayList<>();
        listFromDb = repo.findAll();
        return listFromDb;
    }


    public void delete(int id) {
        repo.deleteById(id);
    }


    public DanToc getById(int id) {
        return repo.findByMaDanToc(id);
    }


    public DanToc update(int id, DanToc dt) {
        DanToc editDT = repo.findByMaDanToc(id);
        editDT.setTenDanToc(dt.getTenDanToc());
        return repo.save(editDT);
    }


    public DanToc insert(DanToc t) {
        return repo.save(t);
    }

}
