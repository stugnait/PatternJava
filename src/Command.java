import java.util.ArrayList;
import java.util.List;

interface ICommand {
    void execute();
}

class ShoppingCart {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
        System.out.println("Товар " + item + " додано в кошик.");
    }

    public void removeItem(String item) {
        if (items.remove(item)) {
            System.out.println("Товар " + item + " видалено з кошика.");
        }
    }

    public void purchase() {
        if (items.isEmpty()) {
            System.out.println("Кошик порожній, нічого купувати.");
        } else {
            System.out.println("Товари " + String.join(", ", items) + " придбані.");
            items.clear();
        }
    }
}

class AddItemCommand implements ICommand {
    private ShoppingCart cart;
    private String item;

    public AddItemCommand(ShoppingCart cart, String item) {
        this.cart = cart;
        this.item = item;
    }

    @Override
    public void execute() {
        cart.addItem(item);
    }
}

class RemoveItemCommand implements ICommand {
    private ShoppingCart cart;
    private String item;

    public RemoveItemCommand(ShoppingCart cart, String item) {
        this.cart = cart;
        this.item = item;
    }

    @Override
    public void execute() {
        cart.removeItem(item);
    }
}

// Команда для здійснення покупки
class PurchaseCommand implements ICommand {
    private ShoppingCart cart;

    public PurchaseCommand(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.purchase();
    }
}

public class Command {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        ICommand addTShirt = new AddItemCommand(cart, "Футболка");
        ICommand addJeans = new AddItemCommand(cart, "Джинси");
        ICommand removeJeans = new RemoveItemCommand(cart, "Джинси");
        ICommand purchase = new PurchaseCommand(cart);

        addTShirt.execute();
        addJeans.execute();
        removeJeans.execute();
        purchase.execute();
    }
}
