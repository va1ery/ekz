package com.max.ekz.Controllers;

import com.max.ekz.Models.Student;
import com.max.ekz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    final StudentService studentService;

    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.getStudentsWithBigMark());
        return "MainPage";
    }

    @PostMapping("/newStudent")
    public String newStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "MainPage";
        studentService.save(student);
        return "redirect:";
    }


}
