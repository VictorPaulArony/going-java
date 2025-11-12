public class Templar extends Character implements Tank, Healer {
    private final int healCapacity;
    private final int shield;


    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity=healCapacity;
        this.shield=shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character c) {
        c.setCurrentHealth(c.getCurrentHealth() + healCapacity);
        if (c.getCurrentHealth() > c.getMaxHealth()) {
            c.setCurrentHealth(c.getMaxHealth());
        }
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (super.getCurrentHealth() > 0) {
            return str.append(super.getName()).append(" is a strong Templar with ")
            .append(super.getCurrentHealth()).append(" HP. It can heal ")
            .append(healCapacity).append(" HP and has a shield of ").append(shield).append(".").toString();
        }
        return str.append(super.getName()).append(" has been beaten, even with its ")
        .append(shield).append(" shield. So bad, it could heal ").append(healCapacity).append(" HP.").toString();

    }

   public static void main(String[] args) {
        Templar alistair = new Templar("Alistair", 20, 5, 4);
        Templar roderick = new Templar("Roderick", 10, 3, 2);

        Character.fight(alistair, roderick);

        alistair.heal(alistair);

        System.out.println(Character.printStatus());
    }


}
