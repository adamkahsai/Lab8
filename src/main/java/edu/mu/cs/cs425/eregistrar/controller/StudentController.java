package edu.mu.cs.cs425.eregistrar.controller;

import java.util.List;
import edu.mu.cs.cs425.eregistrar.model.Student;
import edu.mu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {

    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/student/new"})
    public String addStudent (Model model){
        model.addAttribute("student", new Student());
        return "student/new";
    }
    @PostMapping(value = {"/student/new"})
    public String addNewStudent(@Valid
                             @ModelAttribute("student") Student student,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping(value = {"/student/list"})
    public ModelAndView listStudent() {
        var modelAndView = new ModelAndView();
        List<Student> students = studentService.getStudents();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = studentService.getBook(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("student", student);
        return "student/new";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Student student = studentService.getBook(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        studentService.delete(student);
        return "redirect:/student/list";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setStudentId(id);
            return "student/update";
        }

        studentService.saveStudent(student);
        return "redirect:/student/list";
    }

}
