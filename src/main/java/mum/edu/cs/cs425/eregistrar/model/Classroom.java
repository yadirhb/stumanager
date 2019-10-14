package mum.edu.cs.cs425.eregistrar.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private Integer id;

    private String buildingName;

    private String roomNumber;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "classroom_students")
    private List<Student> students;

    public Classroom() {
        super();
        this.students = new ArrayList<>();
    }

    public Classroom(String buildingName, String roomNumber) {
        this();
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
