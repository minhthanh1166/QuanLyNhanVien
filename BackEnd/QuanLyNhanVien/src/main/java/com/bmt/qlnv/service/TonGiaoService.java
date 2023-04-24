package com.bmt.qlnv.service;


import com.bmt.qlnv.models.TonGiao;
import com.bmt.qlnv.repository.ITonGiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TonGiaoService {
    @Autowired
    private ITonGiaoRepository repo;


    public List<TonGiao> getAll() {
        List<TonGiao> listFromDb = new ArrayList<>();
        listFromDb = repo.findAll();
        return listFromDb;
    }


    public void delete(int id) {
        TonGiao entity = new TonGiao();
        entity = repo.findByMaTonGiao(id);
        if (entity == null) {
            throw new OptimisticLockingFailureException("Concurrent delete error");
        }
        repo.delete(entity);
    }


    public TonGiao getById(int id) {
        return repo.findByMaTonGiao(id);
    }


    public TonGiao update(long id, TonGiao obj) {
        TonGiao editTG = repo.findByMaTonGiao(id);
        editTG.setTenTonGiao(obj.getTenTonGiao());
        return repo.save(editTG);
    }


    public TonGiao insert(TonGiao t) {
        return repo.save(t);
    }

}
