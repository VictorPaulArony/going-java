
import java.util.*;

public abstract class Character {

    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();
    private Weapon weapon;

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int health) {
        currentHealth = Math.max(0, health);
    }

    public abstract void takeDamage(int amount);

    public abstract void attack(Character target);

    public static Character fight(Character c1, Character c2) {
        while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
            c1.attack(c2);
            if (c2.getCurrentHealth() <= 0) {
                return c1;
            }
            c2.attack(c1);
            if (c1.getCurrentHealth() <= 0) {
                return c2;
            }
        }
        return null;
    }

    public static String printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");
        if (allCharacters.isEmpty()) {
            sb.append("Nobody's fighting right now !\n");
        } else {
            sb.append("Characters currently fighting :\n");
        }
        for (Character c : allCharacters) {
            sb.append(" - ").append(c).append("\n");
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return currentHealth == 0 ? name + " : KO" : name + " : " + currentHealth + "/" + maxHealth;
    }
}
