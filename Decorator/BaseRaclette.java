public class BaseRaclette implements Raclette {
    public int getCalories() {
        return 1000;
    }

    public String getIngredients() {
        return "Patate, fromage à raclette";
    }
   @Override
    public String toString() {
        return getIngredients()+" pour "+getCalories()+" calories";
    }
}