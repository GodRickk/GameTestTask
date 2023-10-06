package game.test.task.essences;

import java.util.Random;

public abstract class Creature {
    protected int attack;
    protected int defense;
    protected int curentHealth;
    protected int maxHealth;
    protected int[] damage;

    public Creature(int attack, int defense, int maxHealth, int[] damage) {
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.curentHealth = maxHealth;
        this.damage = damage;
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

    public boolean isAttackSuccessful (int opponentDefense) {
       int modifier =  attackModCalc(opponentDefense);
       for (int i = 0; i < modifier; i++) {
           Random random = new Random();
           int x = random.nextInt(6) + 1; // + 1 т.к. целочисленный диапазон [0, 6)
           if (x == 5 || x == 6) {
               return true;
           }
       }
       return false;
    }

    public int hit (boolean isSuccessful) {
        if (isSuccessful) {
            // взятие случайного числа из диапазона урона [x, y]
            int dealtDamage = (int)(( Math.random() * (this.damage[1] - this.damage[0] + 1) + this.damage[0]));
            return dealtDamage;
        }
        else {
            return 0;
        }
    }

    public void getHit(int opponentDamage) {
        this.curentHealth = curentHealth - opponentDamage;
    }

//   public attackAlgorithm(int opponentDefense) {
//        int modifier = attackModCalc(opponentDefense);
//        boolean isSuccessful = isAttackSuccessful()
//   }

}
