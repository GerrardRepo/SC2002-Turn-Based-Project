package game.action;

import game.combatant.Combatant;
import game.statuseffect.DefendEffect;

public class Defend implements Action
{
	@Override
	public void execute(Combatant actor, BattleContext context)
	{
		actor.addStatusEffect(new DefendEffect(2));
		
		context.log(actor.getName() + " is defending (+10 DEFENCE for current and next round).");
	}
}