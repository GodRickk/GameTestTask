package game.test.task;

import game.test.task.essences.*;
import game.test.task.services.UI;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] playerDamage = new int[2];
        playerDamage[0] = 11;
        playerDamage[1] = 8;
        Player iAm = new Player(3, 4, 32, playerDamage);

        //тест алгоритма атаки
        int[] monsterDamage = new int[2];
        monsterDamage[0] = 1;
        monsterDamage[1] = 2;

        Monster garpy = new Monster(1, 1, 16, monsterDamage);

        int playerAttack = iAm.attackAlgorithm(garpy);
        System.out.print("Dealt to monster playerDamage: ");
        System.out.println(playerAttack);


        //тест алгоритма исцеления
        System.out.println("Player's health: ");
        System.out.println(iAm.getCurentHealth());
        int monsterAttack = garpy.attackAlgorithm(iAm);
        System.out.print("Dealt to player monsterDamage: ");
        System.out.println(monsterAttack);

        System.out.println("Player's health after hit: ");
        System.out.println(iAm.getCurentHealth());
        System.out.println("Player's health after Healing: ");
        iAm.heal();
        System.out.println(iAm.getCurentHealth());


        //тест валидации метода атаки
        iAm.attackAlgorithm(null);
        System.out.println();
        iAm.attackAlgorithm(iAm);

        int[] invalidDamageLength = new int[5];
        int[] invalidDamageValues = new int[2];
        invalidDamageValues[0] = 2;
        invalidDamageValues[1] = -3;


        System.out.println("============================InvalidMonster DamageLength============================");
        Monster invalidMonster = new Monster(-2, 3, -2, invalidDamageLength);


        System.out.println("=======================Params========================");
        System.out.println(invalidMonster);
        System.out.println(invalidMonster.getAttack());
        System.out.println(invalidMonster.getDefense());
        System.out.println(invalidMonster.getCurentHealth());
        System.out.println(invalidMonster.getDamage());


        System.out.println("=======================InvalidMonster Attack=======================");
        invalidMonster.attackAlgorithm(iAm);
        System.out.println(iAm.getCurentHealth());


        System.out.println("==============================================Game UI==============================================");
        UI uiForPlayer = new UI();
        uiForPlayer.uiBootstrap();
    }
}