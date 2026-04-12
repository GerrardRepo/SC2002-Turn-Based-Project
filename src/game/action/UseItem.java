package game.action;

import game.combatant.Combatant;
import game.combatant.Player;
import game.engine.BattleContext;
import game.item.Item;

public class UseItem implements Action {
    private Item item;

    public UseItem(Item item) {
        this.item = item;
    }

    public void execute(Combatant actor, BattleContext context) {
        if (actor instanceof Player) {
            Player player = (Player) actor;
            System.out.println(actor.getName() + " -> Item -> " + item.getName() + " used");
            item.use(player, context);
            player.removeItem(item);
        }
    }
}
