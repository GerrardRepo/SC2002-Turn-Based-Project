package game.item;

import game.combatant.Player;

public interface Item {
    void use(Player player, BattleContext context);
    String getName();
}
