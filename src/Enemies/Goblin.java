package Enemies;

import Characters.Character;

public class Goblin extends Enemy
{
    Goblin() {
        super(20, 5, "Enemies.Goblin", 5);
    }

    @Override
    void attack(Character target)
    {
        target.takeDamage(this.getAttackPower());
        target.takeDamage(this.getAttackPower());
    }
}
