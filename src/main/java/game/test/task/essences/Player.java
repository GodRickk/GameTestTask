package game.test.task.essences;

import static java.lang.Math.round;

public class Player extends Creature{
    private int healsCount;
    public Player(int attack, int defense, int maxHealth, int[] damage) {
        super(attack, defense, maxHealth, damage);
        healsCount = 0;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    @Override
    public int getCurentHealth() {
        return this.curentHealth;
    }

    @Override
    public int getMaxHealth() {
        return this.maxHealth;
    }

    @Override
    public int[] getDamage() {
        return this.damage;
    }

    public void heal() {
        if (healsCount <= 3) {
            if (maxHealth < (int) round((curentHealth + maxHealth * 0.3))) {
                curentHealth = maxHealth;
            }
            else {
                curentHealth = (int) round((curentHealth + maxHealth * 0.3));
            }
            healsCount++;
        }
        else {
            System.out.println("Maximum number of healings reached");
            return;
        }
    }
}
