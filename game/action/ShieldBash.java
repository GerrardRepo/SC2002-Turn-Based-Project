package game.action;

import game.combatant.Combatant;
import game.statuseffect.StunEffect;

public class ShieldBash implements Action
{
	@Override
	public void execute(Combatant actor, BattleContext context)
	{
		Combatant target = context.selectTarget(actor);
		
		int damage = Math.max(0, actor.getAttack() - target.getDefense());
		
		target.takeDamage(damage);
		
		target.addStatusEffect(new StunEffect(2));
		
		context.log(actor.getName() + " uses Shield Bash on " + target.getName() + " dealing " + damage + " damage and stunning the target.");
	}
}