package com.codegym.furama.controller;
import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.dto.FacilityDto;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.service.IFacilityService;
import com.codegym.furama.service.IFacilityTypeService;
import com.codegym.furama.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @GetMapping("")
    public String showList(@RequestParam(value = "nameType",defaultValue = "")String nameType,@RequestParam(value = "name",defaultValue = "")String name
            , Model model, @PageableDefault(value = 5) Pageable pageable){
//        model.addAttribute("facilityList",iFacilityService.searchAndShow(nameType,name,pageable));
        model.addAttribute("facilityList",iFacilityService.findAll());
        return "facility/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {

        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeDtoList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypeDtoList", iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", iRentTypeService.findAll());
            return ("facility/create");
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("messages", "thêm mới thành công");
        return ("redirect:/facility/create");
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteById") int id, RedirectAttributes redirectAttributes) {
        iFacilityService.remove(id);
        redirectAttributes.addFlashAttribute("messages", "xóa thành công");
        return "redirect:/facility";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id , Model model){
        Optional<Facility> facility = iFacilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility.get(),facilityDto);
        model.addAttribute("facilityTypeDtoList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("facilityDto",facilityDto);

        return "/facility/update";
    }
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto ,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new FacilityDto().validate(facilityDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("facilityTypeDtoList", iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", iRentTypeService.findAll());

            return "/facility/update";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("messages","update thành công");
        return "redirect:/facility";
    }
}
