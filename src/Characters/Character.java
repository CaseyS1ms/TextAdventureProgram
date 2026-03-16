package Characters;

import Items.Weapon;

public abstract class Character
{
    private int health;
    private String name;
    private int attackPower;


    public Character(int health,int attackPower, String name)
    {
        this.health = health;
        this.attackPower = attackPower;
        this.name = name;
    }

    abstract public String attack(Character target, Weapon weapon);

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getHealth() {
        return health;
    }

    public String takeDamage(int damageAmount) {
        this.health = health - damageAmount;
        return "DEBUG: Damage taken -" + damageAmount + " hitpoints";
    }

    public void setHealth(int health)
    {
        this.health = health;
    }


}
