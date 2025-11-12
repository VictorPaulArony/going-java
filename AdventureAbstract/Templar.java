public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() { return healCapacity; }

    @Override
    public int getShield() { return shield; }

    @Override
    public void heal(Character target) {
        if (target != null) {
            int newHealth = Math.min(target.getCurrentHealth() + healCapacity, target.getMaxHealth());
            target.setCurrentHealth(newHealth);
        }
    }

    @Override
    public void attack(Character target) {
        if (target != null) {
            heal(this);
            target.takeDamage(6);
        }
    }

    @Override
    public void takeDamage(int amount) {
        if (amount < 0) return;
        int damageTaken = Math.max(amount - shield, 0);
        setCurrentHealth(getCurrentHealth() - damageTaken);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " has been beaten, even with its " + shield + " shield. Could heal " + healCapacity + " HP.";
        }
        return getName() + " is a strong Templar with " + getCurrentHealth() + " HP, shield " + shield + ", heal " + healCapacity;
    }
}