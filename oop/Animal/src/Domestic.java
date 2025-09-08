import java.util.ArrayList;

public class Domestic {

    private ArrayList<Animals> animals;

    public Domestic() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animals animal) {
        animals.add(animal);
    }

    public void display() {
        for (Animals animal : animals) {
            System.out.println("Animal: "+ animal.getName() + " Usage: " + animal.getUsage());
        }
    }
}
