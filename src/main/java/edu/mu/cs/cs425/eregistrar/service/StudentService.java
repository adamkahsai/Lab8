package edu.mu.cs.cs425.eregistrar.service;


import edu.mu.cs.cs425.eregistrar.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    public abstract List<Student> getStudents();
    public abstract Student saveStudent(Student book);

    Optional<Student> getBook(long id);

    void delete(Student student);
}
