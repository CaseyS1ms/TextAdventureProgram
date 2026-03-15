import Characters.Character;
import Characters.Player;
import Enemies.Goblin;
import Enemies.Troll;
import Items.Item;
import Items.Sword;
import Items.Weapon;

import java.util.ArrayList;

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

                while(input != 0) {
                    room = new Room();
                    System.out.println("There are " + room.getExits() + " exits in this room");
                    if (room.HasEnemy()) {
                        System.out.println("There is an enemy in this room");
                        enemyEncounter(enemiesList.get(rand.nextInt(enemiesList.size())));
                    } else {
                        System.out.println("There isn't an enemy in this room");
                    }
                    if (room.HasItem()) {
                        Item item = itemsList.get(rand.nextInt(itemsList.size()));
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
                                        continue;
                                }
                                break;
                            case 2:
                                continue;
                        }
                    } else {
                        System.out.println("There is nothing here");
                    }

                    System.out.println("Press 1 to move on to the next Room");
                    input = scanner.nextInt();
                    scanner.nextLine();

                    switch(input)
                    {
                        case 1:
                            continue;
                        case 2:
                            input = 0;
                    }
                }

        }
    }


    public void enemyEncounter(Character type)
    {
        int enemyHealth = type.getHealth();

        while(!isDead(type))
        {
            System.out.println("you have come across a " + type.getName() + " what do you do\n1. Attack\n2. Run");

            int inputAttack = scanner.nextInt();
            scanner.nextLine();

            switch (inputAttack)
            {
                case 1:
                    player.attack(type, player.getCurrentlyEquipped());
                    System.out.println(type.getHealth());
                    break;
                case 2:
                    break;

            }


        }
        System.out.println("You have defeated the " + type.getName());
        type.setHealth(enemyHealth);

    }

    public boolean isDead(Characters.Character type)
    {
        return type.getHealth() <= 0;
    }

    public void enemiesListInit()
    {
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

}
