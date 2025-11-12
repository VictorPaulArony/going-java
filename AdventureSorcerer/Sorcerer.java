
public class Sorcerer extends Character implements Healer {

    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public void heal(Character c) {
        c.setCurrentHealth(c.getCurrentHealth() + healCapacity);
        if (c.getCurrentHealth() > c.getMaxHealth()) {
            c.setCurrentHealth(c.getMaxHealth());
        }
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (super.getCurrentHealth() > 0) {
            return s.append(super.getName()).append(" is a sorcerer with ").append(super.getCurrentHealth())
                    .append(" HP. It can heal ").append(healCapacity).append(" HP.").toString();
        }
        return s.append(super.getName()).append(" is a dead sorcerer. So bad, it could heal ").append(healCapacity)
                .append(" HP.").toString();
    }

     public static void main(String[] args) {
        Sorcerer gandalf = new Sorcerer("Gandalf", 20, 5);
        Character frodon = new Character("Frodon", 20);
        Sorcerer saroumane = new Sorcerer("saroumane", 10, 3);

        Character.fight(frodon, saroumane);
        
        gandalf.heal(frodon);

        System.out.println(Character.printStatus());
    }
}