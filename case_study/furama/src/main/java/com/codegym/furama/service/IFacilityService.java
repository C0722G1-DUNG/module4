package com.codegym.furama.service;

import com.codegym.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IFacilityService extends IGeneralService<Facility> {
    Page<Facility> searchAndShow(@Param("nameType")String nameType,@Param("name") String name, Pageable pageable );

}
