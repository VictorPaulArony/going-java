public class Main {
    public static void main(String[] args) {
        Domestic domestic = new Domestic();

        Animals dog = new Animals("dog,", "security");
        Animals cat = new Animals("cat,", "catch mice");

        domestic.addAnimal(dog);
        domestic.addAnimal(cat);

        domestic.display();
    }
}