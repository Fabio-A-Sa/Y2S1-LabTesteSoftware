public class HumanClient implements Client {

    private OrderingStrategy strategy;
    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;

    public HumanClient() {
        super();
    }

    public HumanClient(OrderingStrategy strategy) {
        super();
        this.strategy = strategy;
    }

    public void wants (StringDrink drink, StringRecipe recipe, StringBar bar) {
        strategy.wants(drink, recipe, bar);
        this.recipe = recipe;
        this.bar = bar;
        this.drink = drink;
    }

    public void happyHourStarted(Bar bar) {
        this.recipe.mix(this.drink);
    }

    public void happyHourEnded(Bar bar) {
        bar.endHappyHour();
    }
}