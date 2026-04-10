package game.item;

public class SmokeBomb implements Item{
	public String getName() {
        return "Smoke Bomb";
    }

    
    public void use(Combatant user, Combatant target) {
        user.addEffect(new SmokeBombEffect(2)); 
        System.out.println(user.getName() + " used Smoke Bomb! Enemy attacks will deal 0 damage for 2 turns.");
    }
}
