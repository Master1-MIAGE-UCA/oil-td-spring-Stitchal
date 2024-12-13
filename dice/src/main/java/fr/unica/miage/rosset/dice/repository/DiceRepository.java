package fr.unica.miage.rosset.dice.repository;

import fr.unica.miage.rosset.dice.DiceRollLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceRepository extends JpaRepository<DiceRollLog, Long> {

}
