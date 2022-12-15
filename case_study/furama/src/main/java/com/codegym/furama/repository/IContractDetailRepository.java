package com.codegym.furama.repository;

import com.codegym.furama.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    List<ContractDetail> findAllById(@Param("id")int id);
        @Query(value="select cd.id,cd.quantity,cd.attach_facility_id,cd.contract_id ,  sum(ifnull(cd.quantity,0)) as total from contract_detail cd where cd.contract_id= :id group by cd.contract_id",countQuery = "select cd.id,cd.quantity,cd.attach_facility_id,cd.contract_id , sum(ifnull(cd.quantity,0)) as total from contract_detail cd where cd.contract_id= :id group by cd.contract_id",nativeQuery = true)
    List<ContractDetail> findByAllByIdEqualContractId(@Param("id")int id);
}
