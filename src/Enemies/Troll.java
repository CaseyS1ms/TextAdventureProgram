package Enemies;

import Characters.Character;
import Items.Weapon;

public class Troll extends Enemy {
    public Troll() {
        super(120, 20, "Troll", 50);
    }

    @Override
    public String attack(Character target, Weapon weapon) {
        target.takeDamage(20);

        return "you were hit for " + this.getAttackPower() + "your new health is" + target.getHealth();

    }
}
