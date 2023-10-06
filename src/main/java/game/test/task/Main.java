package game.test.task;

import game.test.task.essences.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] damage = new int[2];
        damage[0] = 8;
        damage[1] = 11;
        Player iAm = new Player(3, 4, 31, damage);
        System.out.print("Damage array: ");

        // [0, 0] вывод массива наносимого урона
        System.out.println(Arrays.toString(iAm.getDamage()));
        //System.out.print(iAm.getCurentHealth());


        // тест метода расчёта модификатора атаки
        //int modifier = iAm.attackModCalc(2);
        //System.out.println(modifier);


        // тест успешности броска
        boolean isSuccessful = iAm.isAttackSuccessful(2);
        System.out.println(isSuccessful);


        //тест нанесения урона
        System.out.println(iAm.hit(isSuccessful));


        //тест получения урона
        iAm.getHit(7);
        System.out.println(iAm.getCurentHealth());
    }
}