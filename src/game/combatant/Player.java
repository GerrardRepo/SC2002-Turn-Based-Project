package game.combatant;
import java.util.ArrayList;
import java.util.List;
public abstract class Player extends Combatant {
    private final List<Item> inventory = new ArrayList<>();
    private int specialSkillCooldown = 0;

    public Player(String name, int maxHP, int attack, int defense, int speed) {
        super(name, maxHP, attack, defense, speed);
    }

    public List<Item> getInventory() { return inventory; }
    public int getSpecialSkillCooldown() { return specialSkillCooldown; }

    public void addItem(Item item) { inventory.add(item); }
    public void removeItem(Item item) { inventory.remove(item); }

    public void startCooldown(int turns) { specialSkillCooldown = turns; }

    public void reduceCooldown() {
        if (specialSkillCooldown > 0) specialSkillCooldown--;
    }

    public boolean isSpecialSkillReady() { return specialSkillCooldown <= 0; }
}