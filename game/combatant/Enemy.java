package game.combatant;

public abstract class Enemy extends Combatant {

    public Enemy(String name, int maxHP, int attack, int defense, int speed) {
        super(name, maxHP, attack, defense, speed);
    }

    // defualt: basicAttack
    @Override
    public void basicAttack(Combatant target) {
        target.takeDamage(getAttack());
    }
}
