package game.statuseffect;

import game.combatant.Combatant;

public class StunEffect extends StatusEffect {

    public StunEffect(int duration) {
        super(duration);
    }
    public void applyTo(Combatant target) { }

    public void removeFrom(Combatant target) { }

    public boolean preventsAction() { return true; }

    public String toString() {
        return "STUNNED (" + duration + " turns remaining)";
    }
}
/*This status effect just adds a flag preventsAction. */