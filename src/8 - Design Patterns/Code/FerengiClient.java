public class FerengiClient extends AlienClient {

    private OrderingStrategy strategy;

    protected OrderingStrategy createOrderingStrategy() {
        return new SmartStrategy();
    }

    public FerengiClient() {
        super();
        this.strategy = createOrderingStrategy();
    }

    @Override
    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted((StringBar) bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        strategy.happyHourEnded((StringBar) bar);
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        strategy.wants(drink, recipe, bar);
    }

}
