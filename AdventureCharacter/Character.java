public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public Character(String name, int maxHealth){
        this.name=name;
        this.maxHealth=maxHealth;
        this.currentHealth=maxHealth;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
     public int getCurrentHealth(){
        return currentHealth;
    }
     public String getName(){
        return name;
    }

    public void takeDamage(int param){
        currentHealth-=param;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public void attack(Character c) {
        c.takeDamage(9);

    }


    @Override
    public String toString() {
        if (currentHealth == 0 ) {
            return name + " : KO";
        }
        return name+ " : " + currentHealth + "/" + maxHealth;
        
    }


     public static void main(String[] args) {
        Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 5);
        
        System.out.println(aragorn.toString());
        System.out.println(uruk.toString());
        
        aragorn.attack(uruk);

        System.out.println(uruk.toString());
        
        aragorn.takeDamage(12);

        System.out.println(aragorn.toString());
    }
}
