package Enemies;

import Characters.Character;
import Items.Weapon;

public class Goblin extends Enemy
{
    public Goblin()
    {
        super(20, 5, "Goblin", 5);
    }

    @Override
    public void attack(Character target, Weapon weapon)
    {
        target.takeDamage(this.getAttackPower());
        target.takeDamage(this.getAttackPower());
    }
}
