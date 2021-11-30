public class HumanClient implements Client {

    public HumanClient() {
        super();
    }

    public void wants (StringDrink drink, StringRecipe recipe, StringBar bar) {
        System.out.println("Test");
    }

    public void happyHourStarted(Bar bar) {
        bar.startHappyHour();
    }

    public void happyHourEnded(Bar bar) {
        bar.endHappyHour();
    }
}
