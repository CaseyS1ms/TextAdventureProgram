package Characters;

import Items.Item;
import Items.Weapon;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Character
{


    Random rand = new Random();
    ArrayList<Item> inventory = new ArrayList<>();

    boolean hasWeapon;
    Weapon currentlyEquipped;



    public Player(boolean hasWeapon)
    {
        super(100, 20, "Player");
        this.hasWeapon = hasWeapon;
    }

    @Override
    public void attack(Character target, Weapon weapon)
    {
        int damageDealt = this.getAttackPower();
        if(weapon != null)
        {
            damageDealt = this.getAttackPower() + weapon.getDamage();
        }


        target.takeDamage(damageDealt);
        System.out.println("Dealt " + damageDealt + " Damage");
    }

    public void pickUpItem(Item item)
    {
        inventory.add(item);
    }

    public void setCurrentlyEquipped(Weapon currentlyEquipped) {
        this.currentlyEquipped = currentlyEquipped;
    }

    public Weapon getCurrentlyEquipped() {
        return currentlyEquipped;
    }
}
