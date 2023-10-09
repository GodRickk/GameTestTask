package game.test.task.essences;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;

public abstract class Creature {
    protected int attack;
    protected int defense;
    protected int curentHealth;
    protected int maxHealth;
    protected int[] damage = new int[2];

    public Creature(int attack, int defense, int maxHealth, int[] damage) {
        try {
            if (attack < 1 || attack > 30) {
                throw new IllegalArgumentException("Parameter 'attack' must be from range [1,30]");
            }
            this.attack = attack;

            if (defense < 1 || defense > 30) {
                throw new IllegalArgumentException("Parameter 'defense' must be from range [1,30]");
            }
            this.defense = defense;

            if (maxHealth <=0) {
                throw new IllegalArgumentException("Parameter 'maxHealth' must be from range natural number other than zero when created");
            }
            this.maxHealth = maxHealth;
            this.curentHealth = maxHealth;

            if (damage.length != 2) {
                throw new IllegalArgumentException("Parameter 'damage' must be two numbers");
            }
            if ((damage[0] <= 0 || damage[1] <= 0)) {
                throw new IllegalArgumentException("Parameter 'damage' must contains natural numbers");
            }

            this.damage[0] = damage[0];
            this.damage[1] = damage[1];
            Arrays.sort(this.damage);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            //e.printStackTrace();
        }
    }

    public abstract int getAttack();

    public abstract int getDefense();

    public abstract int getCurentHealth();

    public abstract int getMaxHealth();

    public abstract int[] getDamage();

    private int attackModCalc(int opponentDefense) {
        if (((attack - opponentDefense) + 1) <= 0) {
            // критический успех
            return 1;
        }
        else {
            return (attack - opponentDefense) + 1;
        }

    }

    private boolean isAttackSuccessful (int modifier) {
       for (int i = 0; i < modifier; i++) {
           Random random = new Random();
           int x = random.nextInt(6) + 1; // + 1 т.к. целочисленный диапазон [0, 6)
           if (x == 5 || x == 6) {
               return true;
           }
       }
       return false;
    }

    private int hit (boolean isSuccessful) {
        if (isSuccessful) {
            // взятие случайного числа из диапазона урона [x, y]
            int dealtDamage = (int)(( Math.random() * (this.damage[1] - this.damage[0] + 1) + this.damage[0]));
            return dealtDamage;
        }
        else {
            return 0;
        }
    }

    private void getHit(int opponentDamage) {
        this.curentHealth = curentHealth - opponentDamage;
    }

    public boolean isDead() {
        return curentHealth <= 0;
    }

    public int attackAlgorithm(Creature opponent) {
        int dealtDamage = 0;
        try {
        if (opponent == null) {
            throw new NullPointerException("Your enemy is not exist, who you are going to fight with?");
        }

        if (opponent == this) {
            throw new IllegalArgumentException("Wow, self-harm mechanic is not provided, and you are not Tyler Durden");
        }
        if (opponent.getDefense() < 1 || opponent.getDefense() > 30) {
            throw new IllegalArgumentException("Your opponent has wrong defense stat");
        }

        int modifier = attackModCalc(opponent.getDefense());
        System.out.print("Attack modifier: ");
        System.out.println(modifier);

        boolean isSuccessful = isAttackSuccessful(modifier);
        System.out.print("Is attack successful: ");
        System.out.println(isSuccessful);

        dealtDamage = hit(isSuccessful);
        System.out.print("Dealt damage: ");
        System.out.println(dealtDamage);

        System.out.print("Opponent health before hit: ");
        System.out.println(opponent.getCurentHealth());
        opponent.getHit(dealtDamage);
        System.out.print("Opponent health after hit: ");
        System.out.println(opponent.getCurentHealth());

        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e);
            //e.printStackTrace();
        }
        return dealtDamage;
    }

}
