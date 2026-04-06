package game.combatant;

public class Warrior extends Player {

    public Warrior(String name) {
        super(name, 120, 20, 15, 10); // HP, attack, defense, speed
    }

    // Shield Bash
    public void shieldBash(Combatant target) {
        target.addStatusEffect(new StunEffect(2)); // period for 2 round
    }

    @Override
    public void basicAttack(Combatant target) {
        target.takeDamage(getAttack());
    }
}
