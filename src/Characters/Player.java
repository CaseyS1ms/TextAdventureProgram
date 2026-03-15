package Characters;

import Items.Item;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Characters.Character
{


    Random rand = new Random();
    ArrayList<Item> inventory = new ArrayList<>();




    public Player()
    {
        super(100, 20, "Characters.Player");
    }

    @Override
    void attack(Character target)
    {
        target.takeDamage(this.getAttackPower());
        System.out.println("Dealt " + this.getAttackPower() + " Damage");
    }
}
