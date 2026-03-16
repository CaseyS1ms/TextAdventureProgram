package Enemies;

import Characters.Character;
import Items.Weapon;

public class Boss extends Enemy {
    public Boss() {
        super(150, 50, "Boss", 500);
    }

    @Override
    public String attack(Character target, Weapon weapon) {
        target.takeDamage(this.getAttackPower());
        return "The Boss hit you and dealt " + this.getAttackPower() + " hitpoints";
    }
}
