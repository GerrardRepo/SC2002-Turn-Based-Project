package game.combatant;
import java.util.ArrayList;
import java.util.List;
public abstract class Combatant {
    private final String name;
    private final int maxHP;
    private int currentHP;
    private int attack;
    private int defense;
    private final int speed;
    private final List<StatusEffect> statusEffects = new ArrayList<>();

    public Combatant(String name, int maxHP, int attack, int defense, int speed) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public void takeDamage(int damage) {
        for (StatusEffect effect : statusEffects) {
            if (effect.blocksDamage()) {
                damage = 0;
                break;// Checks for Smokebomb flag
            }
        }
        currentHP = Math.max(0, currentHP - damage);//Prevent negative HP
    }

    public void heal(int amount) {
        currentHP = Math.min(maxHP, currentHP + amount);//Prevent overhealing
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public boolean isStunned() {
        for (StatusEffect effect : statusEffects) {
            if (effect.preventsAction()) return true; //Checks combatant's list of effects for preventsAction flag
        }
        return false;
    }

    public void addStatusEffect(StatusEffect effect) {
        statusEffects.add(effect);
        effect.applyTo(this);//applies status effect, sets applied flag, if set already, does nothing.
    }

    public void removeExpiredEffects() {
        List<StatusEffect> expired = new ArrayList<>();
        for (StatusEffect e : statusEffects) {
            if (e.isExpired()) expired.add(e); //Checks combatant statuseffects, if duration <= 0
                                                //add this effect to a list for reference to remove
        }
        for (StatusEffect e : expired) {
            e.removeFrom(this);//removes effects, for eg, undo defend by minusing defend stat
            statusEffects.remove(e); //refers to expired list and removes the effects from statuseffect list in combatant
        }
    }

    public void tickEffects() {
        for (StatusEffect e : statusEffects) {
            e.tick(); //iterates through the list of effects and decrements the duration
        }
    }

    // Getters
    public String getName() { return name; }
    public int getMaxHP() { return maxHP; }
    public int getCurrentHP() { return currentHP; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public List<StatusEffect> getStatusEffects() { return statusEffects; }

    // Setters for stat-modifying effects for arcane blast and defend
    public void setAttack(int attack) { this.attack = attack; }
    public void setDefense(int defense) { this.defense = defense; }
}
