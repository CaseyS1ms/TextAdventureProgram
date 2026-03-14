import java.util.Scanner;

public class Game
{

    Scanner scanner = new Scanner(System.in);

    public void mainLoop()
    {
        System.out.println("Welcome to Text Adventure Game!\n1. Start Game\n2. Load Game\n3. Settings");
        int input = scanner.nextInt();
        scanner.nextLine();

        switch(input)
        {
            case 1:
                createPlayer();
        }
    }

    public Character createPlayer()
    {
        return new Player();
    }


}
