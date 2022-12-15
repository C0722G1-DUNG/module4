package com.codegym.furama.service;

import com.codegym.furama.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailService extends IGeneralService<ContractDetail> {
    List<ContractDetail> findAllById(@Param("id")int id);
    List<ContractDetail> findByAllByIdEqualContractId(@Param("id")int id);
}
