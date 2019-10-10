package edu.mum.cs.cs425.stumanager.model;

import javax.persistence.*;

@Entity
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String degreeTitle;

    @OneToOne(mappedBy="transcript")
    private Student student;

    public Transcript() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
