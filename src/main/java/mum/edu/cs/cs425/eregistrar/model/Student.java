package mum.edu.cs.cs425.eregistrar.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

    @NotBlank(message = "* Student's number is required.")
    @Column(name = "student_number", nullable = false)
    private String number;

    @NotBlank(message = "* Student's first name is required.")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @NotBlank(message = "* Student's last_name is required.")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "cpga")
    private Double cgpa;

    @Column(name = "enrollment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEnrollment;

    @Column(nullable = false)
    private Boolean isInternational = true;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Transcript transcript;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Classroom> classes;

    public Student() {
        super();
        this.classes = new ArrayList<>();
    }

    public Student(@NotBlank(message = "* Student's number is required.") String number, @NotBlank(message = "* Student's first name is required.") String firstName, String middleName, @NotBlank(message = "* Student's last_name is required.") String lastName, Double cgpa, LocalDate dateOfEnrollment) {
        this();
        this.number = number;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public void addClass(Classroom classroom) {
        this.classes.add(classroom);
    }
}
