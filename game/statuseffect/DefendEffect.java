package game.statuseffect;

import game.combatant.Combatant;

public class DefendEffect extends StatusEffect {
    private static final int DEFENSE_BOOST = 10;
    private boolean applied = false;

    public DefendEffect(int duration) {
        super(duration);
    }

    @Override
    public void applyTo(Combatant target) {
        if (!applied) {
            target.setDefense(target.getDefense() + DEFENSE_BOOST);
            applied = true;
        }
    }

    @Override
    public void removeFrom(Combatant target) {
        if (applied) {
            target.setDefense(target.getDefense() - DEFENSE_BOOST);
            applied = false;
        }
    }

    @Override
    public String toString() {
        return "DEFENDING (" + duration + " turns remaining)";
    }
}
/*This status sets new defense */