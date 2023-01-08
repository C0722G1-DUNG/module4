package com.codegym.module4.controller;

import com.codegym.module4.dto.QuestionContentDto;
import com.codegym.module4.model.QuestionContent;
import com.codegym.module4.model.QuestionType;
import com.codegym.module4.service.IQuestionContentService;
import com.codegym.module4.service.IQuestionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionContentController {
    @Autowired
    private IQuestionContentService iQuestionContentService;
    @Autowired
    private IQuestionTypeService iQuestionTypeService;

    @ModelAttribute("questionTypeList")
    public List<QuestionType> getList() {
        return (List<QuestionType>) iQuestionTypeService.findAll();
    }

    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "title", defaultValue = "") String title
            , @PageableDefault(page = 0, value = 2) Pageable pageable) {
        model.addAttribute("title", title);
//        model.addAttribute("questionContentList",iQuestionContentService.searchAndShowList1(title,idQuestionType,pageable));
        model.addAttribute("questionContentList", iQuestionContentService.searchAndShowList(title, pageable));
        return "/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteById") int id, RedirectAttributes redirectAttributes) {
        iQuestionContentService.remove(id);
        redirectAttributes.addFlashAttribute("messages", "xóa thành công");
        return "redirect:/question";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("questionContentDto", new QuestionContentDto());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("questionContentDto") QuestionContentDto questionContentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new QuestionContentDto().validate(questionContentDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionContentDto, questionContent);
        iQuestionContentService.save(questionContent);
        redirectAttributes.addFlashAttribute("messages", "Thêm mới thành công");
        return "redirect:create";
    }

}
