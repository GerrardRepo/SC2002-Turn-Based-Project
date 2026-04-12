package game.engine;

import game.action.Action;
import game.combatant.Combatant;
import game.combatant.Enemy;
import game.combatant.Player;
import java.util.List;

public class BattleEngine {
    private BattleContext context;
    private TurnOrderStrategy turnOrderStrategy;
    private BattleSetup setup;

    public BattleEngine(BattleSetup setup, TurnOrderStrategy turnOrderStrategy) {
        this.setup = setup;
        this.turnOrderStrategy = turnOrderStrategy;
    }

    public BattleContext initializeBattle() {
        List<Enemy> enemies = setup.createInitialEnemies();
        this.context = new BattleContext(setup.getPlayer(), enemies);
        return context;
    }

    public void playTurn(Combatant combatant, Action action) {
        if (!combatant.isAlive()) {
            return;
        }

        if (combatant.isStunned()) {
            System.out.println(combatant.getName() + " -> STUNNED: Turn skipped");
        } else if (action != null) {
            action.execute(combatant, context);
        }
    }

    public void endOfRound() {
        // Tick and remove expired effects for all alive combatants
        List<Combatant> alive = context.getAllAliveCombatants();
        for (int i = 0; i < alive.size(); i++) {
            alive.get(i).tickEffects();
            alive.get(i).removeExpiredEffects();
        }

        // Also tick effects on dead combatants (e.g. stun expiring on dead enemy)
        List<Enemy> allEnemies = context.getEnemies();
        for (int i = 0; i < allEnemies.size(); i++) {
            if (!allEnemies.get(i).isAlive()) {
                allEnemies.get(i).tickEffects();
                allEnemies.get(i).removeExpiredEffects();
            }
        }
    }

    public BattleContext getContext() {
        return context;
    }

    public boolean isBattleOver() {
        if (context.isPlayerDefeated()) {
            return true;
        }
        if (context.allEnemiesDefeated() && !canBackupSpawn()) {
            return true;
        }
        return false;
    }

    private boolean canBackupSpawn() {
        return setup.hasBackupSpawn() && !context.isBackupSpawned();
    }

    public boolean shouldSpawnBackup() {
        return context.allEnemiesDefeated() && canBackupSpawn();
    }

    public void spawnBackup() {
        List<Enemy> backup = setup.createBackupEnemies();
        context.addEnemies(backup);
        context.setBackupSpawned(true);

        System.out.println();
        System.out.println("===================================================");
        System.out.println("  BACKUP SPAWN! New enemies enter the battle!");
        for (int i = 0; i < backup.size(); i++) {
            System.out.println("  > " + backup.get(i).getName() + " (HP: " + backup.get(i).getCurrentHP() + ")");
        }
        System.out.println("===================================================");
    }

    public boolean isVictory() {
        return context.getPlayer().isAlive() && context.allEnemiesDefeated();
    }

    public List<Combatant> getTurnOrder() {
        return turnOrderStrategy.determineTurnOrder(context.getAllAliveCombatants());
    }
}
