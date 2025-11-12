
public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void attack(Character target) {
        if (target != null) {
            if (getWeapon() != null) {
                target.takeDamage(getWeapon().getDamage());
            } else {
                target.takeDamage(7);
            }
        }
    }

    @Override
    public void takeDamage(int amount) {
        int damage = (int) (amount * 0.8);
        setCurrentHealth(getCurrentHealth() - damage);
    }

    @Override
    public String toString() {
        if (super.getCurrentHealth() > 0) {
            return super.getName() + " is a monster with " + String.valueOf(super.getCurrentHealth()) + " HP." + " He has the weapon " + getWeapon().toString()+".";
        }
        return super.getName() + " is a monster and is dead." + " He has the weapon " + getWeapon().toString()+".";

    }

}
