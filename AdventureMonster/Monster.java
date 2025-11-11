public class Monster extends Character {

    public Monster(String name, int maxHealth){
        super(name, maxHealth);
    }

    @Override
    public String toString() {
        if (this.isAlive()) {
            return getName() + " is a monster with " + getCurrentHealth() + " HP";
        } else {
            return getName() + " is a monster and is dead";
        }
    }

    public static void main(String[] args) {
        Character aragorn = new Character("Aragorn", 20);
        Monster slime = new Monster("Slime", 15);

        System.out.println(Character.printStatus());

        Character winner = Character.fight(aragorn, slime);

        System.out.println(Character.printStatus());
    }
}
