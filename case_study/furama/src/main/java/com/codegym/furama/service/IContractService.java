package com.codegym.furama.service;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.IContract;

import java.util.List;

public interface IContractService extends IGeneralService<Contract> {
    List<IContract> listContract();
}
