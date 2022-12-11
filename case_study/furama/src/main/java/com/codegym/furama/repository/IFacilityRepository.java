package com.codegym.furama.repository;

import com.codegym.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
 @Query(value="select * from facility f join facility_type ft on ft.id= f.facility_type_id join rent_type r on r.id = f.rent_type_id where ft.name like concat('%', :nameType,'%')  and f.name like concat('%', :name,'%') order by f.id "
         ,countQuery="select * from (select * from facility f join facility_type ft on ft.id= f.facility_type_id join rent_type r on r.id = f.rent_type_id where ft.name like concat('%', :nameType,'%')  and f.name like concat('%', :name,'%') order by f.id ) as abc",nativeQuery = true)
    Page<Facility> searchAndShow(@Param("nameType")String nameType,@Param("name") String name, Pageable pageable );

//    @Query(value="select f.id,ft.id, f.area ,f.cost,f.description_other_covenience,f.facility_free,f.max_people,f.name,f.number_of_floors,f.poll_area,f.standard_room,ft.name,r.name\n" +
//            " from facility f join facility_type ft on ft.id= f.facility_type_id join rent_type r on r.id = f.rent_type_id  where ft.name like concat('%', :nameType,'%')  and f.name like concat('%', :name,'%') order by f.id "
//            ,countQuery="select * from (select f.id,ft.id, f.area ,f.cost,f.description_other_covenience,f.facility_free,f.max_people,f.name,f.number_of_floors,f.poll_area,f.standard_room,ft.name,r.name\n" +
//            " from facility f join facility_type ft on ft.id= f.facility_type_id join rent_type r on r.id = f.rent_type_id  where ft.name like concat('%', :nameType,'%')  and f.name like concat('%', :name,'%') order by f.id ) as abc",nativeQuery = true)
//    Page<Facility> searchAndShow(@Param("nameType")String nameType,@Param("name") String name, Pageable pageable );
}
