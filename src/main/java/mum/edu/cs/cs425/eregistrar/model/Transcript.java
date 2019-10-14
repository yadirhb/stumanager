package mum.edu.cs.cs425.eregistrar.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transcripts")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transcript_id")
    private Integer id;

    private String degreeTitle;

    @OneToOne
    @JoinColumn(name = "student_fk")
    private Student student;

    public Transcript() {
        super();
    }

    public Transcript(String degreeTitle, Student student) {
        this.degreeTitle = degreeTitle;
        this.student = student;
    }
}
