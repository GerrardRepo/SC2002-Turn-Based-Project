package game.statuseffect;

import game.combatant.Combatant;

public class StunEffect extends StatusEffect {

    public StunEffect(int duration) {
        super(duration);
    }

    @Override
    public void applyTo(Combatant target) { }

    @Override
    public void removeFrom(Combatant target) { }

    @Override
    public boolean preventsAction() { return true; }

    @Override
    public String toString() {
        return "STUNNED (" + duration + " turns remaining)";
    }
}
/*This status effect just adds a flag preventsAction. */