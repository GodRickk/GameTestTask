package game.test.task.services;

import game.test.task.essences.Creature;
import game.test.task.essences.Monster;
import game.test.task.essences.Player;

import static java.lang.Math.round;

public class Fight {

    public Fight() {

    }

    public Creature doFight (Player player, Monster monster) {
        Creature winner = null;
        while (!player.isDead() && !monster.isDead()) {

            player.attackAlgorithm(monster);
            if (player.getCurentHealth() <= (int) round((player.getMaxHealth() * 0.6))) {
                player.heal();
            }
            if (monster.isDead()) {
                winner = player;
                break;
            }

            monster.attackAlgorithm(player);
            if (player.isDead()) {
                winner = monster;
                break;
            }
        }
        return winner;
    }
}
