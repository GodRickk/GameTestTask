package game.test.task.essences;

public class Player extends Creature{

    public Player(int attack, int defense, int maxHealth, int[] damage) {
        super(attack, defense, maxHealth, damage);
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


}
