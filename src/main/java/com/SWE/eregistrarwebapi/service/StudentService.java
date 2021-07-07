package com.SWE.eregistrarwebapi.service;


import com.SWE.eregistrarwebapi.model.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    public abstract List<Student> getStudents();

    public abstract Student saveStudent(Student book);

    Optional<Student> getStudent(long id);

    void delete(Student student);

    void deleteStudent(Long studentId);

    Student updateStudent(Student s, Long studentId);
}
