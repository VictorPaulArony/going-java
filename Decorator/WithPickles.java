public class WithPickles extends RacletteDecorator {

    private Raclette raclette;

    public WithPickles(Raclette raclette) {
        super(raclette);
        super.raclette = raclette;
    }

    public int getCalories() {
        return 50 + super.raclette.getCalories();
    }

    public String getIngredients() {
        return super.raclette.getIngredients() + ", cornichons";
    }

    @Override
    public String toString() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }
}