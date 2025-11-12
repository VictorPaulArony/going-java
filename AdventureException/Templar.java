
public class Templar extends Character implements Healer, Tank {

    private final int healCapacity;
    private final int shield;
    private Weapon weapon;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public int getShield() {
        return shield;
    }

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
            if (getWeapon() != null) {
                target.takeDamage(getWeapon().getDamage());
            } else {
                target.takeDamage(6);
            }
        }
    }

    @Override
    public void takeDamage(int amount) {
        if (amount < 0) {
            return;
        }
        int damageTaken = Math.max(amount - shield, 0);
        setCurrentHealth(getCurrentHealth() - damageTaken);
    }


    @Override
    public String toString() {
        if (super.getCurrentHealth() == 0) {
            return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", super.getName(), getShield(), healCapacity)+ " He has the weapon " + getWeapon().toString()+".";
        }

        return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.",
                super.getName(), super.getCurrentHealth(), healCapacity, getShield())+ " He has the weapon " + getWeapon().toString()+".";
    }
}
