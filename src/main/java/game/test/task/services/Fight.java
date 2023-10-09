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
        int playerTurnCount = 1;
        int monsterTurnCount = 1;
        System.out.println("==================================Fight with monster==================================");
        while (!player.isDead() && !monster.isDead()) {
            System.out.print("Player's turn: ");
            System.out.print(playerTurnCount);
            playerTurnCount++;

            player.attackAlgorithm(monster);
            if (player.getCurentHealth() <= (int) round((player.getMaxHealth() * 0.6))) {
                player.heal();
            }
            if (monster.isDead()) {
                winner = player;
                monster = null;
                break;
            }

            System.out.print("Monster's turn: ");
            System.out.print(monsterTurnCount);
            monsterTurnCount++;

            monster.attackAlgorithm(player);
            if (player.isDead()) {
                winner = monster;
                player = null;
                break;
            }
        }
        return winner;
    }
}
