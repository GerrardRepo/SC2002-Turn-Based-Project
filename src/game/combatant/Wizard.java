package game.combatant;

public class Wizard extends Player {

    public Wizard() {
        super("Wizard", 200, 50, 10, 20);
    }

    public void addArcaneBlastBonus(int bonus) {
        setAttack(getAttack() + bonus);
    }
}
