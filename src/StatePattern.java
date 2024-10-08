// Інтерфейс Стану
interface State {
    void handle();
}

// Конкретні стани
class AvailableState implements State {
    @Override
    public void handle() {
        System.out.println("Товар доступний для замовлення.");
    }
}

class OutOfStockState implements State {
    @Override
    public void handle() {
        System.out.println("Товар недоступний, немає в наявності.");
    }
}

// Контекст
class StateProduct {
    private State state;

    public StateProduct(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle();
    }
}

// Використання
public class StatePattern {
    public static void main(String[] args) {
        StateProduct product = new StateProduct(new AvailableState());
        product.request();

        product.setState(new OutOfStockState());
        product.request();
    }
}
