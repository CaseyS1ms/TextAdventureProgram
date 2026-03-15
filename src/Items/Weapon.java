package Items;

public abstract class Weapon extends Item {

    int damage;
    Weapon(String name, int value, String type, int damage) {
        super(name, value, type);
        this.damage = damage;
    }

    public int getDamage()
    {
        return damage;
    }
}
