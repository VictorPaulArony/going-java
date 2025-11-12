public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() { return healCapacity; }

    @Override
    public void heal(Character target) {
        if (target != null && target.getCurrentHealth() > 0) {
            int newHealth = Math.min(target.getCurrentHealth() + healCapacity, target.getMaxHealth());
            target.setCurrentHealth(newHealth);
        }
    }

    @Override
    public void attack(Character target) {
        if (target != null) {
            heal(this);
            target.takeDamage(10);
        }
    }

    @Override
    public void takeDamage(int amount) {
        if (amount < 0) return;
        setCurrentHealth(getCurrentHealth() - amount);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) return getName() + " is a dead sorcerer. Could heal " + healCapacity + " HP.";
        return getName() + " is a sorcerer with " + getCurrentHealth() + " HP. Can heal " + healCapacity + " HP.";
    }
}