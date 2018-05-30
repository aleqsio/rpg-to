package com.to.rpg;

import com.to.rpg.people.Human;

import java.util.List;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 */
public class War {
    private Human attacker;
    private Human defender;

    public class WarResult {
        private final Human winner;
        private final Human looser;

        public WarResult(Human winner, Human looser) {
            this.winner = winner;
            this.looser = looser;
        }

        public Human getWinner() {
            return winner;
        }

        public Human getLooser() {
            return looser;
        }
    }

    public War(Human attacker, Human defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public WarResult wage() {
        List<Human> attackers = attacker.getSubordinates();
        List<Human> defenders = defender.getSubordinates();
        double attackingForce = Human.getCombinedStat(attackers);
        double defendingForce = Human.getCombinedStat(defenders);
        WarResult result;
        if (attackingForce > defendingForce) {
            result = new WarResult(attacker, defender);
            defender.transferGoods(attacker);
        } else {
            result = new WarResult(defender, attacker);
            attacker.transferGoods(defender);
        }
        return result;
    }
}
