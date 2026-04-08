package game.action;

import game.combatant.Combatant;

public class BasicAttack implements Action 
{
	@Override
	public void execute(Combatant actor, BattleContext context)
	{
		Combatant target = context.selectTarget(actor);
		
		int damage = Math.max(0,  actor.getAttack() - target.getDefense());
		
		target.takeDamage(damage);
		
		context.log(actor.getName() + " attacks " + target.getName() + " and deals " + damage + " damage.");
	}
}