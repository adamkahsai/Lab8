package com.SWE.eregistrarwebapi.service.Impl;

import com.SWE.eregistrarwebapi.model.Student;
import com.SWE.eregistrarwebapi.repository.IStudentRepository;
import com.SWE.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private IStudentRepository studentRepository;


    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudent(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Student s, Long studentId) {
        return studentRepository.findById(studentId).map(student -> {
            student.setCgpa(s.getCgpa());
            student.setFirst_name(s.getFirst_name());
            student.setIsInternational(s.getIsInternational());
            student.setLastName(s.getLastName());
            student.setMiddleName(s.getMiddleName());
            student.setStudentNumber(s.getStudentNumber());
            return studentRepository.save(student);
        }).orElseGet(() -> {
            return studentRepository.save(s);
        });
    }
}
