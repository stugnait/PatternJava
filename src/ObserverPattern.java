import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

class ObserverProduct implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}

class CustomerObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Клієнт отримав повідомлення: " + message);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        ObserverProduct product = new ObserverProduct();
        Observer customer1 = new CustomerObserver();
        Observer customer2 = new CustomerObserver();

        product.attach(customer1);
        product.attach(customer2);

        product.setState("Товар оновлено");
    }
}
