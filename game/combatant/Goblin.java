package game.combatant;

public class Goblin extends Enemy {

    public Goblin() {
        super("Goblin", 60, 15, 5, 10);
    }

    @Override
    public void basicAttack(Combatant target) {
        target.takeDamage(getAttack());
    }
}
