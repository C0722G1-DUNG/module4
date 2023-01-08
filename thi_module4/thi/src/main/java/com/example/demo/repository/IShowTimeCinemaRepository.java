package com.example.demo.repository;


import com.example.demo.model.ShowTimeCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IShowTimeCinemaRepository extends JpaRepository<ShowTimeCinema,Integer> {
 @Query(value="select * from show_time_cinema where status = 1",countQuery ="select * from show_time_cinema where status = 1",nativeQuery = true)
    List<ShowTimeCinema> findAllStatusOne();
 @Transactional
    @Modifying
    @Query(value="update show_time_cinema set `status`=0 where id = :deleteByCinemaCode",countQuery="update show_time_cinema set `status`=0 where id = :deleteByCinemaCode",nativeQuery = true)
    void delete(@Param("deleteByCinemaCode") String deleteByCinemaCode);
}
