public class HumanClient implements Client {

    private OrderingStrategy strategy;

    public HumanClient() {
        super();
    }

    public HumanClient(OrderingStrategy strategy) {
        super();
        this.strategy = strategy;
    }

    public void wants (StringDrink drink, StringRecipe recipe, StringBar bar) {
        recipe.mix(drink);
    }

    public void happyHourStarted(Bar bar) {
        bar.startHappyHour();
    }

    public void happyHourEnded(Bar bar) {
        bar.endHappyHour();
    }
}
