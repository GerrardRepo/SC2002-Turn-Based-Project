package game.item;

public class Potion implements Item{
	public String getName() {
        return "Potion";
    }

    
    public void use(Combatant user, Combatant target) {
        int healAmount = 100;
        int currentHp = user.getHp();
        
        user.setHp(currentHp + healAmount); 
        System.out.println(user.getName() + " used Potion and healed 100 HP!");
    }
}
