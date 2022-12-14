package com.codegym.furama.repository;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.IContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select   c.id,c.employee_id as EmployeeId , c.customer_id as CustomerId , c.facility_id as FacilityId,cd.id as ContractDetailId,a.id as AttachId, f.name as NameFacility, cs.name as NameCustomer,c.start_date as StartDate,c.end_date as EndDate,c.deposit, ifnull(f.cost,0)+sum(ifnull(cd.quantity,0)*ifnull(a.cost,0)) as total from contract c\n" +
            "left join customer cs on c.customer_id= cs.id left join facility f on f.id = c.facility_id left join contract_detail cd on cd.contract_id = c.id left join attach_facility a on cd.attach_facility_id = a.id group by c.customer_id order by cs.id"
            , countQuery = "select * from(select c.id,c.employee_id as EmployeeId , c.customer_id as CustomerId , c.facility_id as FacilityId,cd.id as ContractDetailId,a.id as AttachId, f.name as NameFacility, cs.name as NameCustomer,c.start_date as StartDate,c.end_date as EndDate,c.deposit, ifnull(f.cost,0)+sum(ifnull(cd.quantity,0)*ifnull(a.cost,0)) as total from contract c\n" +
            "left join customer cs on c.customer_id= cs.id left join facility f on f.id = c.facility_id left join contract_detail cd on cd.contract_id = c.id left join attach_facility a on cd.attach_facility_id = a.id group by c.customer_id order by cs.id)abc ", nativeQuery = true)
    List<IContract> listContract();
}
