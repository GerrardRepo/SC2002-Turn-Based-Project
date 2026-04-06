package game.combatant;

import java.util.List;

public class Wizard extends Player {

    public Wizard(String name) {
        super(name, 80, 25, 8, 15);
    }

    // attack all enemies
    public void arcaneBlast(List<Combatant> enemies) {
        for (Combatant enemy : enemies) {
            enemy.takeDamage(getAttack());
        }
    }

    @Override
    public void basicAttack(Combatant target) {
        target.takeDamage(getAttack());
    }
}
