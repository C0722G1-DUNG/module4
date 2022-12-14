package com.codegym.furama.model.contract;

public interface IContract {
    int getId();
    int getEmployeeId();
    int getCustomerId();
    int getFacilityId();
    int getContractDetailId();
    int getAttachId();
    String getNameFacility();
    String getNameCustomer();
    String getStartDate();
    String getEndDate();
    String getDeposit();
    String getTotal();


}
