package game.combatant;

public class Wolf extends Enemy {

    public Wolf(String name, EnemyActionStrategy strategy) {
        super(name, 40, 45, 5, 35, strategy);
    }
}
