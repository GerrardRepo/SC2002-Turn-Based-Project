package game.statuseffect;

import game.combatant.Combatant;

public class StunEffect extends StatusEffect {

    public StunEffect(int duration) {
        super(duration);
    }

    public void applyTo(Combatant target) {
        // Stun does not change any stats
    }

    public void removeFrom(Combatant target) {
        // Nothing to undo
    }

    public boolean preventsAction() {
        return true;
    }

    public String toString() {
        return "STUNNED (" + duration + " turns remaining)";
    }
}
