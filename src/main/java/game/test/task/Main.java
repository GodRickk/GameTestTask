package game.test.task;

import game.test.task.essences.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Player iAm = new Player(3, 4, 31, new int[2]);
        System.out.print("Hello world! ");

        // [0, 0] вывод массива наносимого урона
        System.out.println(Arrays.toString(iAm.getDamage()));
        //System.out.print(iAm.getCurentHealth());


        //int modifier = iAm.attackModCalc(2);
        //System.out.println(modifier);


        System.out.println(iAm.isAttackSuccessful(2)); // true
    }
}