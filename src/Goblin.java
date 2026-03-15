

public class Goblin extends Enemy
{
    Goblin() {
        super(20, 5, "Goblin", 5);
    }

    @Override
    void attack(Character target)
    {
        target.takeDamage(this.getAttackPower());
        target.takeDamage(this.getAttackPower());
    }
}
