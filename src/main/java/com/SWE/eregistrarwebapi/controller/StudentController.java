package com.SWE.eregistrarwebapi.controller;


import com.SWE.eregistrarwebapi.model.Student;
import com.SWE.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/list")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(value = "/register")
    public Student saveStudent(@Valid @RequestBody Student newStudent) {
        return studentService.saveStudent(newStudent);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping(value = "/get/{studentId}")
    public Optional<Student> getStudent(@PathVariable("studentId") Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PutMapping(value = "/update/{studentId}")
    public Student updateStudent(@PathVariable("studentId") Long studentId, @Valid @RequestBody Student s) {
        return studentService.updateStudent(s, studentId);

    }

    @GetMapping(value = "/studentList")
    public Student[] getStudentList() {
        List<Student> students = studentService.getStudents();

        Student[] st = new Student[students.size()];
        students.toArray(st);

//        StudentList studentList=new StudentList();
//        studentList.setStudents(students);
//        return studentList;
        return st;
    }

}

