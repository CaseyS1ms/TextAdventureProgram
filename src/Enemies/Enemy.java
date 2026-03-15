package Enemies;

import Characters.Character ;

public abstract class Enemy extends Character
{

    int reward;


    public Enemy(int health, int attackPower, String name, int reward) {
        super(health, attackPower, name);
        this.reward = reward;
    }


}
