package mum.edu.cs.cs425.eregistrar.service.impl;

import mum.edu.cs.cs425.eregistrar.model.Student;
import mum.edu.cs.cs425.eregistrar.repository.StudentRepository;
import mum.edu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public List<Student> sortAllStudentsByLastName() {
        return StreamSupport.stream(repository.findAll(Sort.by("lastName")).spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteById(Integer studentId) {
        repository.deleteById(studentId);
    }

    @Override
    public Student getById(Integer studentId) {
        return repository.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> findByName(String name) {
        return repository.findByName(name);
    }
}
