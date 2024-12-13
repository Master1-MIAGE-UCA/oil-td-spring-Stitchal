package fr.unica.miage.rosset.dice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RollController {

    @GetMapping("/rollDice")
    public String rollDice() {
        Dice dice = new Dice();
        dice.roll();
        return "The dice rolled a " + dice.getValue();
    }

    @GetMapping("/rollDice/{X}")
    public String rollDiceX(int X) {
        Dice dice = new Dice();
        int sum = 0;
        for (int i = 0; i < X; i++) {
            dice.roll();
            sum += dice.getValue();
        }
        return "The dice rolled a sum of " + sum;
    }
}
