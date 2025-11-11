import java.util.ArrayList;
import java.util.List;

public class Character {

    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth){
        this.name=name;
        this.maxHealth=maxHealth;
        this.currentHealth=maxHealth;
        allCharacters.add(this);
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
 
    public static String printStatus() {
        StringBuilder str = new StringBuilder();
        str.append("------------------------------------------\n");
        if(allCharacters.isEmpty()) {
        str.append("Nobody's fighting right now !\n");
        }else{
            str.append("Characters currently fighting :\n");
            for(Character c : allCharacters) {
                str.append(" - ").append(c.toString()).append("\n");
            }
        }
        str.append("------------------------------------------\n");
        return str.toString();
    }
    
    public static Character fight(Character c1, Character c2) {
        c1.attack(c2);
        if(c2.getCurrentHealth() == 0) {
            return c1;
        }

        c2.attack(c1);
        if (c1.getCurrentHealth()== 0) {
            return c2;
        }
        return fight(c1, c2);
    }
}
