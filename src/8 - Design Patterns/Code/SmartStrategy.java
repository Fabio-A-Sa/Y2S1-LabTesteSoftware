public class SmartStrategy implements OrderingStrategy {

    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;

        if (bar.isHappyHour()) {
            this.recipe.mix(this.drink);
        }
    }

    public void happyHourStarted(StringBar bar) {
        this.recipe.mix(this.drink);
    }

    public void happyHourEnded(StringBar bar) {
        System.out.println("Not applicable");
    }

}