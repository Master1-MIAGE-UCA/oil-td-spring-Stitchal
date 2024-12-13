package fr.unica.miage.rosset.dice;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class DiceRollLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diceCount")
    private int diceCount;

    @Column(name = "results")
    private int[] results;

    @Column(name = "timestamp")
    private Date timestamp;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
