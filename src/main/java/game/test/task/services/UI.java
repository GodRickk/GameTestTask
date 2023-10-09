package game.test.task.services;

import game.test.task.essences.Creature;
import game.test.task.essences.Monster;
import game.test.task.essences.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UI {
    private final Fight fightService = new Fight();


    public void uiBootstrap() {
        System.out.println("Hello, seeker! Are you ready for an adventure?");
        Scanner scanner = new Scanner(System.in);


        //создание персонажа
        System.out.println("Let's create your character");
        System.out.println("There are 4 parameters: 'attack', 'defense', 'health', 'damage'");

        HashMap<String, Integer> playersParameters = getUserParameters(scanner);
        int[] playerDamage = new int[2];
        playerDamage[0] = playersParameters.get("DamageFirstNumber");
        playerDamage[1] = playersParameters.get("DamageSecondNumber");

        Player player = new Player( playersParameters.get("attack").intValue(),
                                    playersParameters.get("defense").intValue(),
                                    playersParameters.get("health").intValue(),
                                    playerDamage);


        //выбор кол-ва монстров
        System.out.println("How many monsters would you like to fight? ");
        int amountOfMonsters = scanner.nextInt();

        //создание монстров
        System.out.println("Let's create your monsters");
        System.out.println("There are 4 parameters: 'attack', 'defense', 'health', 'damage'");
        ArrayList<Monster> monsterList = new ArrayList<Monster>();
        for (int i = 0; i < amountOfMonsters; i++) {
            HashMap<String, Integer> monsterParameters = getUserParameters(scanner);

            int[] monsterDamage = new int[2];
            playerDamage[0] = monsterParameters.get("DamageFirstNumber");
            playerDamage[1] = monsterParameters.get("DamageSecondNumber");
            Monster monster = new Monster(monsterParameters.get("attack").intValue(),
                    monsterParameters.get("defense").intValue(),
                    monsterParameters.get("health").intValue(),
                    playerDamage);

            monsterList.add(monster);
        }


        //сражеине
        for (Monster monster : monsterList) {
            Creature winner = fightService.doFight(player, monster);
            if (winner instanceof Monster) {
                System.out.println("Your hero is defeated!");
                break;
            } else if (winner instanceof Player) {
                System.out.println("Your hero won this fight, congratulations!");
            }
        }

    }


    private HashMap<String, Integer> getUserParameters(Scanner scanner) {
        int playerAttack = 0;
        int playerDefense = 0;
        int playerHealth = 0;
        int playerDamageFirstNumber = 0;
        int playerDamageSecondNumber = 0;
        while (true) {
            System.out.println("Enter 'attack' parameter it's should be in range from 1 to 30");
            playerAttack = scanner.nextInt();
            if (playerAttack < 1 || playerAttack > 30) {
                System.out.println("Please, enter correct data for 'attack' parameter");
                continue;
            }
            else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter 'defense' parameter it's should be in range from 1 to 30");
            playerDefense = scanner.nextInt();
            if (playerDefense < 1 || playerDefense > 30) {
                System.out.println("Please, enter correct data for 'defense' parameter");
                continue;
            }
            else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter 'health' parameter it's should be natural number");
            playerHealth = scanner.nextInt();
            if (playerHealth <= 0) {
                System.out.println("Please, enter correct data for 'health' parameter");
                continue;
            }
            else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter fisrt number of 'damage' parameter it's should be natural number");
            playerDamageFirstNumber = scanner.nextInt();
            if (playerDamageFirstNumber <= 0) {
                System.out.println("Please, enter correct data for 'damage' parameter");
                continue;
            }
            else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter second number of 'damage' parameter it's should be natural number");
            playerDamageSecondNumber = scanner.nextInt();
            if (playerDamageSecondNumber <= 0) {
                System.out.println("Please, enter correct data for 'damage' parameter");
                continue;
            }
            else {
                break;
            }
        }

        HashMap<String, Integer> creaturePrameters = new HashMap<>();
        creaturePrameters.put("attack", playerAttack);
        creaturePrameters.put("defense", playerDefense);
        creaturePrameters.put("health", playerHealth);
        creaturePrameters.put("DamageFirstNumber", playerDamageFirstNumber);
        creaturePrameters.put("DamageSecondNumber", playerDamageSecondNumber);

        return creaturePrameters;
    }

}
