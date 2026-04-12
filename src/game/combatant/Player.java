package game.combatant;

import game.item.Item;
import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Combatant {
    private List<Item> inventory;
    private int specialSkillCooldown;

    public Player(String name, int maxHP, int attack, int defense, int speed) {
        super(name, maxHP, attack, defense, speed);
        this.inventory = new ArrayList<Item>();
        this.specialSkillCooldown = 0;
    }

    public List<Item> getInventory() { return inventory; }
    public int getSpecialSkillCooldown() { return specialSkillCooldown; }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void startCooldown(int turns) {
        specialSkillCooldown = turns;
    }

    public void reduceCooldown() {
        if (specialSkillCooldown > 0) {
            specialSkillCooldown = specialSkillCooldown - 1;
        }
    }

    public boolean isSpecialSkillReady() {
        return specialSkillCooldown <= 0;
    }
}
