package fr.unica.miage.rosset.dice.service;

import fr.unica.miage.rosset.dice.Dice;
import fr.unica.miage.rosset.dice.DiceRollLog;
import fr.unica.miage.rosset.dice.repository.DiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiceService {
    @Autowired
    public DiceRepository diceRepository;
    @Autowired
    private Dice dice;

    public int rollDice() {
        return rollDices(1)[0];
    }

    public int[] rollDices(int diceCount) {
        DiceRollLog log = new DiceRollLog();
        int[] results = new int[diceCount];
        for (int i = 0; i < diceCount; i++) {
            dice.roll();
            results[i] = dice.getValue();
        }
        log.setDiceCount(diceCount);
        log.setResults(results);
        log.setTimestamp(new Date());
        diceRepository.save(log);
        return results;
    }


    public List<DiceRollLog> getAllDiceLogs() {
        return diceRepository.findAll();
    }
}
