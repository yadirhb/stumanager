package mum.edu.cs.cs425.eregistrar.repository;

import mum.edu.cs.cs425.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT a FROM Student a WHERE firstName = ?1 OR lastName = ?1")
    List<Student> findByName(String name);
}
