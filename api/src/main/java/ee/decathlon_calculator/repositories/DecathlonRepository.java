package ee.decathlon_calculator.repositories;

import ee.decathlon_calculator.entities.DecathlonEvents;
import ee.decathlon_calculator.entities.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DecathlonRepository extends JpaRepository<DecathlonEvents, Long> {
    Optional<DecathlonEvents> findBySport(Sport sport);
}
