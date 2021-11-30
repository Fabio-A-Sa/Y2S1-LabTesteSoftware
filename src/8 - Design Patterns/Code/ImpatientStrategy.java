public class ImpatientStrategy implements OrderingStrategy {

    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;
        recipe.mix(drink);
    }

    public void happyHourStarted(StringBar bar) {

    }

    public void happyHourEnded(StringBar bar) {

    }

}
