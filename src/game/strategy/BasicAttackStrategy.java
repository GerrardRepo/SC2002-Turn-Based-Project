package game.strategy;

import game.action.Action;
import game.action.BasicAttack;
import game.combatant.Combatant;
import game.engine.BattleContext;
import java.util.List;

public class BasicAttackStrategy implements EnemyActionStrategy {

    public Action decideAction(Combatant enemy, BattleContext context) {
        List<Combatant> targets = context.getAlivePlayers();
        if (targets.isEmpty()) {
            return null;
        }
        // Always attack the first (only) player
        return new BasicAttack(targets.get(0));
    }
}
