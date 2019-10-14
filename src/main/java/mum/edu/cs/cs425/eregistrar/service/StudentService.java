package mum.edu.cs.cs425.eregistrar.service;

import mum.edu.cs.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> sortAllStudentsByLastName();

    Student save(Student student);

    void deleteById(Integer studentId);

    Student getById(Integer studentId);

    List<Student> findByName(String name);
}
