public class WithColdMeats extends RacletteDecorator {
    public Raclette decoratedRaclette;

    public WithColdMeats(Raclette raclette) {
        super(raclette);
        decoratedRaclette = raclette;
    }

    public int getCalories() {
        return decoratedRaclette.getCalories() + 350;
    }

    public String getIngredients() {
        return decoratedRaclette.getIngredients() + ", charcuterie";
    }

    @Override
    public String toString() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }
}
