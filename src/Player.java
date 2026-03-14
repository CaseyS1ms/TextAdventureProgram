import java.util.Random;

public class Player extends Character
{


    Random rand = new Random();




    Player()
    {
        super(100, 20, "Player");
    }

    @Override
    void attack(Character target)
    {
        target.takeDamage(this.getAttackPower());
    }
}
