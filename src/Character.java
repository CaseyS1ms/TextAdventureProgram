public abstract class Character
{
    private int health;
    private String name;
    private int attackPower;


    Character(int health,int attackPower, String name)
    {
        this.health = health;
        this.attackPower = attackPower;
        this.name = name;
    }

    abstract void attack(Character target);

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damageAmount) {
        this.health = health - damageAmount;
        System.out.println("Damage taken -" + damageAmount + " hitpoints");
    }


}
