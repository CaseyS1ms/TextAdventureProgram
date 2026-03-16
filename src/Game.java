import Characters.Character;
import Characters.Player;
import Enemies.Boss;
import Enemies.Goblin;
import Enemies.Troll;
import Items.Item;
import Items.Sword;
import Items.Weapon;

import java.util.ArrayList;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Game
{
    Room room;
    ArrayList<Character> enemiesList;
    ArrayList<Item> itemsList;

    Player player = new Player(false);

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();


    public void mainLoop()
    {
        //ON LOAD
        enemiesListInit();
        itemsListInit();


        //
        System.out.println("Welcome to the Text Adventure Game\n1. Start Game\n2. Exit Game");

        int input = scanner.nextInt();
        scanner.nextLine();

        switch(input)
        {
            case 1:
                boolean endgame = false;
                int count = 0;
                while(input != 0 && !isDead(player)) {
                    count ++;
                    room = new Room();
                    System.out.println("There are " + room.getExits() + " exits in this room");
                    if (room.HasEnemy()) {

                        Character enemy = enemiesList.get(rand.nextInt(enemiesList.size()));
                        if(count > 10)
                        {
                            enemy = new Boss();
                            endgame = true;
                        }
                        System.out.println("There is a " + enemy.getName() + " in this room");
                        enemyEncounter(enemy);
                        if(endgame)
                        {
                            System.out.println("You have survived!");
                            return;
                        }

                    } else {
                        System.out.println("There isn't an enemy in this room");
                    }
                    if(isDead(player))
                    {
                        System.out.println("You have Died");
                        return;
                    }
                    handleItem(itemsList.get(rand.nextInt(itemsList.size())));
                    handleRoom();


                }

        }
    }


    public void enemyEncounter(Character type)
    {
        int enemyHealth = type.getHealth();

        while(!isDead(type) && !isDead(player))
        {

            handlePlayerTurn(type);
            handleEnemyTurn(type);

        }
        if(!isDead(player))
        {
            System.out.println("You have defeated the " + type.getName());
        }

        type.setHealth(enemyHealth);

    }

    public boolean isDead(Character type)
    {
        return type.getHealth() <= 0;
    }

    public void enemiesListInit()
    {
        //add enemies here

        enemiesList = new ArrayList<>();
        Character goblin = new Goblin();
        Character troll = new Troll();

        enemiesList.add(goblin);
        enemiesList.add(troll);

    }

    public void itemsListInit()
    {
        itemsList = new ArrayList<>();
        Item sword = new Sword();
        itemsList.add(sword);
    }

    private void handleItem(Item item)
    {
        if (room.HasItem()) {
            System.out.println("There is a " + item.getName() + " in this room\n1. Pick up\n2. Leave");
            int input2 = scanner.nextInt();
            scanner.nextLine();
            switch(input2)
            {
                case 1:
                    player.pickUpItem(item);
                    System.out.println("item picked up. would you like to equip?\n1. Yes\n2. No");
                    int input3 = scanner.nextInt();
                    scanner.nextLine();
                    switch(input3)
                    {
                        case 1:
                            player.setCurrentlyEquipped((Weapon) item);
                            System.out.println("Successfully Equipped");
                            break;
                        case 2:

                    }
                    break;
                case 2:

            }
        } else {
            System.out.println("There is nothing here");
        }
    }

    private void handleRoom()
    {

        System.out.println("Press 1 to move on to the next Room");
        int input = scanner.nextInt();
        scanner.nextLine();

        switch(input)
        {
            case 1:

            case 2:
                input = 0;
        }
    }

    private void handlePlayerTurn(Character enemy)
    {
        System.out.println("1. Attack\n2. Run");
        int inputAttack = scanner.nextInt();
        scanner.nextLine();

        switch (inputAttack)
        {
            case 1:
                System.out.println(player.attack(enemy, player.getCurrentlyEquipped()));
                System.out.println(enemy.getHealth());
                break;
            case 2:
                break;

        }

    }

    private void handleEnemyTurn(Character enemy)
    {
        System.out.println(enemy.attack(player, null));
    }


}
