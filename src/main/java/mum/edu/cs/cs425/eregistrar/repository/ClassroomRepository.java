package mum.edu.cs.cs425.eregistrar.repository;

import mum.edu.cs.cs425.eregistrar.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
