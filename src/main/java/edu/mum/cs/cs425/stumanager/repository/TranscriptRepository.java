package edu.mum.cs.cs425.stumanager.repository;

import edu.mum.cs.cs425.stumanager.model.Transcript;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends CrudRepository<Transcript, Long> {
}
