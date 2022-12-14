package com.codegym.furama.service.impl.contract;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.IContract;
import com.codegym.furama.repository.IContractRepository;
import com.codegym.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Iterable<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return iContractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public List<IContract> listContract() {
        return iContractRepository.listContract();
    }
}
