import java.awt.geom.GeneralPath;
import java.util.Random;


public class Room
{

    Random rand = new Random();

    private int exits;
    private boolean hasItem;
    private boolean hasEnemy;
    private Character goblin = new Goblin();

    public Room()
    {
        exits = 1 + rand.nextInt(4);
        hasItem = rand.nextBoolean();
        hasEnemy = rand.nextBoolean();
    }

    public int getExits()
    {
        return this.exits;
    }

    public boolean HasEnemy() {
        return hasEnemy;
    }

    public boolean HasItem() {
        return hasItem;
    }
}
