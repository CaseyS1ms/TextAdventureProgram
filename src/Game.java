import java.util.Scanner;

public class Game
{
    Room room;
    Character player = new Player();
    Character goblin = new Goblin();
    Scanner scanner = new Scanner(System.in);

    public void mainLoop()
    {
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
                        enemyEncounter(goblin);
                    } else {
                        System.out.println("There isn't an enemy in this room");
                    }
                    if (room.HasItem()) {
                        System.out.println("There is an item in this room");
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
        System.out.println("you have come across a " + type.getName() + " what do you do\n1. Attack\n2. Run");

        int inputAttack = scanner.nextInt();
        scanner.nextLine();

        while(!isDead(type))
        {

            switch (inputAttack)
            {
                case 1:
                    player.attack(type);
                    System.out.println(type.getHealth());
                    break;
                case 2:
                    break;

            }

            inputAttack = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("You have defeated the " + type.getName());

    }

    public boolean isDead(Character type)
    {
        return type.getHealth() <= 0;
    }

}
