package edu.mum.cs.cs425.stumanager;

import edu.mum.cs.cs425.stumanager.model.Classroom;
import edu.mum.cs.cs425.stumanager.model.Student;
import edu.mum.cs.cs425.stumanager.model.Transcript;
import edu.mum.cs.cs425.stumanager.repository.ClassroomRepository;
import edu.mum.cs.cs425.stumanager.repository.StudentRepository;
import edu.mum.cs.cs425.stumanager.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TranscriptRepository transcriptRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtApp.class, args);
    }

    void saveStudent() {
        Transcript transcript = new Transcript();
        transcript.setDegreeTitle("BS Computer Science");

        Student student = new Student();
        student.setNumber("000-61-0001");
        student.setFirstName("Anna");
        student.setMiddleName("Lynn");
        student.setLastName("Smith");
        student.setCgpa(3.45);
        student.setDateOfEnrollment(LocalDate.of(2019, 5, 24));

        student.setTranscript(transcriptRepository.save(transcript));

        student = studentRepository.save(student);

        Classroom classroom = new Classroom();
        classroom.setBuildingName("McLaughlin building");
        classroom.setRoomNumber("M105");
        classroom.setStudent(student);
        classroomRepository.save(classroom);
        System.out.println("Added student:");
        System.out.println(student.toString());
    }

    @Override
    public void run(String... args) throws Exception {
        saveStudent();
    }
}
