package fr.unica.miage.rosset.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RollController {
    @Autowired
    DiceService diceService = new DiceService();

    @GetMapping("/rollDice")
    public int rollDice() {
        return diceService.rollDice();
    }

    @GetMapping("/rollDice/{amount}")
    public int[] rollDiceX(@PathVariable int amount) {
        return diceService.rollDices(amount);
    }
}
