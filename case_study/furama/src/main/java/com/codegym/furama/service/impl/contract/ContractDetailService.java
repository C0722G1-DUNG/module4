package com.codegym.furama.service.impl.contract;

import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.repository.IContractDetailRepository;
import com.codegym.furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public Iterable<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public Optional<ContractDetail> findById(Integer id) {
        return iContractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<ContractDetail> findAllById(int id) {
        return iContractDetailRepository.findAllById(id);
    }

    @Override
    public List<ContractDetail> findByAllByIdEqualContractId(int id) {
        return iContractDetailRepository.findByAllByIdEqualContractId(id);
    }
}
