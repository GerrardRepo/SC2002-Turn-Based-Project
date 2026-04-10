package game.item;

public class PowerStone implements Item{
	public String getName() {
        return "Power Stone";
    }

    
    public void use(Combatant user, Combatant target) {
        
        if (user instanceof Player) {
            Player player = (Player) user;
            
            player.executeSkillEffect(target); 
            System.out.println(player.getName() + " used Power Stone! Special skill triggered without affecting cooldown.");
        }
    }
}
