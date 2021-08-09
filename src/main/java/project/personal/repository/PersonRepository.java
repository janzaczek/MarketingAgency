package project.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.personal.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
