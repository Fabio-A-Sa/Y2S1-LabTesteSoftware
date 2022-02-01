import java.util.ArrayList;
import java.util.List;

public abstract class Bar {

    private boolean happyHour;
    private List<BarObserver> observers;

    public Bar () {
        this.happyHour = false;
        this.observers = new ArrayList<>();
    }

    public boolean isHappyHour() {
        return happyHour;
    }

    public void startHappyHour() {
        this.happyHour = true;
        notifyObservers();
    }

    public void endHappyHour() {
        this.happyHour = false;
        notifyObservers();
    }

    public void addObserver(BarObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers) {
            if (isHappyHour()) {
                observer.happyHourStarted(this);
            }  else {
                observer.happyHourEnded(this);
            }
        }
    }
}
