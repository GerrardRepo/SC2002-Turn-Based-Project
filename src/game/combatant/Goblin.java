package game.combatant;

import game.strategy.EnemyActionStrategy;

public class Goblin extends Enemy {
    public Goblin(String name, EnemyActionStrategy strategy) {
        super(name, 55, 35, 15, 25, strategy);
    }
}
