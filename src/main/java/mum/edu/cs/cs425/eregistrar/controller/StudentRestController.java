package mum.edu.cs.cs425.eregistrar.controller;

import mum.edu.cs.cs425.eregistrar.model.Student;
import mum.edu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/student")
@CrossOrigin(origins = {"http://127.0.0.1:5501", "http://localhost:81"}, allowedHeaders = "*")
public class StudentRestController {
    private StudentService service;

    public StudentRestController(StudentService service) {
        this.service = service;
    }

    @GetMapping(value = {"/list"})
    public List<Student> list(){
        return service.sortAllStudentsByLastName();
    }
}
