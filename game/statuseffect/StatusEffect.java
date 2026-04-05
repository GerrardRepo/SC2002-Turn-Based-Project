package game.statuseffect;

import game.combatant.Combatant;

public abstract class StatusEffect {
    protected int duration;

    public StatusEffect(int duration) {
        this.duration = duration;
    }

    public abstract void applyTo(Combatant target);

    public abstract void removeFrom(Combatant target);

    public boolean preventsAction() { return false; }

    public boolean blocksDamage() { return false; }

    public boolean isExpired() { return duration <= 0; }

    public void tick() { duration--; }

    public int getDuration() { return duration; }
}
