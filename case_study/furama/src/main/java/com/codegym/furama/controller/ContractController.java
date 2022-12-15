package com.codegym.furama.controller;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.model.contract.IContract;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.model.facility.FacilityType;
import com.codegym.furama.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IFacilityService iFacilityService;
    @ModelAttribute("customerList")
    public List<Customer> getListCustomer(){
        return (List<Customer>) iCustomerService.findAll();
    }
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @ModelAttribute("facilityTypeList")
    public List<FacilityType> getListFacilityType(){
        return (List<FacilityType>) iFacilityTypeService.findAll();
    }

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getList(){
        return (List<AttachFacility>) iAttachFacilityService.findAll();
    }
        @ModelAttribute("ContractDetailList")
    public  List<ContractDetail> getListContractDetail(){
        return (List<ContractDetail>) iContractDetailService.findAll();
    }
    @ModelAttribute("facilityList")
    public List<Facility> getListFacility(){
        return (List<Facility>) iFacilityService.findAll();
    }


    @GetMapping("")
    public String showList(Model model){
        List<IContract> iContractList = iContractService.listContract();
        model.addAttribute("contractList",iContractList);
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("contract",new Contract());
        return "/contract/list";
    }
//    @GetMapping("/create")
//    public String showFormCreate(Model model) {
//        model.addAttribute("contract", new Contract());
//        return "contract/create";
//    }
    @PostMapping("/create")
    public String create(@ModelAttribute("contract") Contract contract,
                       RedirectAttributes redirectAttributes) {
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("messages", "thêm mới thành công");
        return ("redirect:/contract");
    }
    @PostMapping("/create/contractDetail")
    public String createContractDetail(@ModelAttribute("contractDetail")ContractDetail contractDetail,RedirectAttributes redirectAttributes){
iContractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("messages","Thêm mới thành công");
        return "redirect:/contract";
    }


}
