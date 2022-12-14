package com.codegym.furama.repository;

import com.codegym.furama.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
}
