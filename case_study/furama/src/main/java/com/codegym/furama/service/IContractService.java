package com.codegym.furama.service;

import com.codegym.furama.model.contract.Contract;

import java.util.List;

public interface IContractService extends IGeneralService<Contract> {
    List<Contract> listContract();
}
