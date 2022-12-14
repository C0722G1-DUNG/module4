package com.codegym.furama.controller;

import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.service.IAttachFacilityService;
import com.codegym.furama.service.IContractDetailService;
import com.codegym.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contractDetail")
@CrossOrigin("*")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @GetMapping("/id")
    public ResponseEntity<List<ContractDetail> > showList(){
  List<ContractDetail> contractDetail = (List<ContractDetail>) iContractDetailService.findAll();
  if (contractDetail.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  return new ResponseEntity<>(contractDetail,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity create(@RequestBody ContractDetail contractDetail) {
        Optional<Contract> contract =iContractService.findById(contractDetail.getContract().getId());
        Optional<AttachFacility> attachFacility = iAttachFacilityService.findById(contractDetail.getAttachFacility().getId());
        contractDetail.setContract(contract.get());
        contractDetail.setAttachFacility(attachFacility.get());
        iContractDetailService.save(contractDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
