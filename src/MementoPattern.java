import java.util.ArrayList;
import java.util.List;

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class MementoProduct {
    private String state;

    public void setState(String state) {
        System.out.println("Збереження стану: " + state);
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("Відновлення стану: " + state);
    }
}

class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

public class MementoPattern {
    public static void main(String[] args) {
        MementoProduct product = new MementoProduct();
        Caretaker caretaker = new Caretaker();

        product.setState("Стан #1");
        caretaker.add(product.saveStateToMemento());

        product.setState("Стан #2");
        caretaker.add(product.saveStateToMemento());

        product.setState("Стан #3");
        product.getStateFromMemento(caretaker.get(1));
    }
}
