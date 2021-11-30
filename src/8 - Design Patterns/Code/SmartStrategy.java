public class SmartStrategy implements OrderingStrategy {

    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;
        if (bar.isHappyHour()) recipe.mix(drink);
    }

    void happyHourStarted(StringBar bar);
    void happyHourEnded(StringBar bar);

}