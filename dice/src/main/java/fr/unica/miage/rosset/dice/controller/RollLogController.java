package fr.unica.miage.rosset.dice.controller;

import fr.unica.miage.rosset.dice.DiceRollLog;
import fr.unica.miage.rosset.dice.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RollLogController {
    @Autowired
    private DiceService diceService;

    @GetMapping("/diceLogs")
    public String getDiceLogs(){
        List<DiceRollLog> logs = diceService.getAllDiceLogs();
        StringBuilder sb = new StringBuilder();
        for (DiceRollLog log : logs) {
            sb.append(log.getTimestamp())
                    .append(" : ")
                    .append(log.getDiceCount())
                    .append(" dice(s) rolled : ")
                    .append(Arrays.toString(log.getResults()))
                    .append("\n");
        }
        return sb.toString();
    }

}
