package fr.unica.miage.rosset.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RollService {
    @Autowired
    Repository repository;

    public int[] rollDice(int X) {
        Dice dice = new Dice();
        int[] results = new int[X];
        for (int i = 0; i < X; i++) {
            dice.roll();
            results[i] = dice.getValue();
        }
        return results;
    }

    private void save(int[] results) {
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(results.length);
        log.setResults(results);
        log.setTimestamp(new java.util.Date());
        repository.save(log);
    }

    public List<DiceRollLog> getAllDiceLogs() {
        return repository.findAll();
    }
}
