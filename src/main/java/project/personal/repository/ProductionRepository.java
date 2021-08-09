package project.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.personal.model.Production;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {
}
