// Інтерфейс посередника
interface IMediator {
    void notify(Object sender, String event);
}

// Клас посередника, що координує компоненти
class ShopMediator implements IMediator {
    private Customer customer;
    private Product product;
    private Order order;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public void notify(Object sender, String event) {
        if (event.equals("buy")) {
            product.checkAvailability();
            order.createOrder();
            customer.sendNotification();
        }
    }
}

// Клас клієнта
class MediatorCustomer {
    private IMediator mediator;

    public MediatorCustomer(Mediator mediator) {
        this.mediator = mediator;
    }

    public void buyProduct() {
        System.out.println("Клієнт хоче купити товар");
        mediator.notify(this, "buy");
    }

    public void sendNotification() {
        System.out.println("Клієнту надіслано повідомлення про покупку");
    }
}

// Клас товару
class MediatorProduct {
    private MediatorCustomer mediator;

    public MediatorProduct(Mediator mediator) {
        this.mediator = mediator;
    }

    public void checkAvailability() {
        System.out.println("Товар є в наявності");
    }
}

// Клас замовлення
class Order {
    private Mediator mediator;

    public Order(Mediator mediator) {
        this.mediator = mediator;
    }

    public void createOrder() {
        System.out.println("Замовлення створено");
    }
}

// Використання
public class Mediator {
    public static void main(String[] args) {
        ShopMediator mediator = new ShopMediator();

        Customer customer = new Customer(mediator);
        Product product = new Product(mediator);
        Order order = new Order(mediator);

        mediator.setCustomer(customer);
        mediator.setProduct(product);
        mediator.setOrder(order);

        customer.buyProduct();
    }
}
