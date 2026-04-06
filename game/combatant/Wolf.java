package game.combatant;

public class Wolf extends Enemy {

    public Wolf() {
        super("Wolf", 50, 18, 4, 20);
    }

    @Override
    public void basicAttack(Combatant target) {
        target.takeDamage(getAttack());
    }
}
