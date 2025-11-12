public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public void attack(Character target) {
        if (target != null) target.takeDamage(7);
    }

    @Override
    public void takeDamage(int amount) {
        if (amount < 0) return;
        int damage = (int) (amount * 0.8);
        setCurrentHealth(getCurrentHealth() - damage);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}