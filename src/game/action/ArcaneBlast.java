package game.action;

import java.util.List;

import game.combatant.Combatant;

public class ArcaneBlast implements Action
{
	@Override
	public void execute(Combatant actor, BattleContext context)
	{
		List<Combatant> enemies = context.getEnemiesOf(actor);
		
		int kills = 0;
		
		for (Combatant enemy: enemies)
		{
			int damage = Math.max(0, actor.getAttack() - enemy.getDefense());
			
			enemy.takeDamage(damage);
			
			context.log(actor.getName() + " attacks " + enemy.getName() + " with Arcane Blast and deals " + damage + "damage.");
			
			if (!enemy.isAlive())
			{
				kills++;
			}
		}
		
		if (kills > 0)
		{
			actor.setAttack(actor.getAttack() + (kills * 10));
			
			context.log(actor.getName() + " gains " + (kills * 10) + " attack from Arcane Blast kills.");
		}
	}
}