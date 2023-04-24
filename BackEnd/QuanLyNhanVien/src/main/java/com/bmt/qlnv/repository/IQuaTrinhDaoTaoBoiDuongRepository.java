package com.bmt.qlnv.repository;


import com.bmt.qlnv.models.HoSo;
import com.bmt.qlnv.models.QuaTrinhDaoTaoBoiDuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuaTrinhDaoTaoBoiDuongRepository extends JpaRepository<QuaTrinhDaoTaoBoiDuong, Long> {

    List<QuaTrinhDaoTaoBoiDuong> findAllByHoSo(HoSo hs);

    QuaTrinhDaoTaoBoiDuong findById(long id);
}
