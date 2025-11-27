public abstract class RacletteDecorator implements Raclette {
    Raclette raclette;

    public RacletteDecorator() {
    };

    public RacletteDecorator(Raclette raclette) {
        this.raclette = raclette;
    };

    public abstract int getCalories();

    public abstract String getIngredients();

}