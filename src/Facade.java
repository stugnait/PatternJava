// Клас для оплати
class PaymentService {
    public void processPayment(double amount) {
        System.out.println("Оплата на суму: " + amount + " грн.");
    }
}

// Клас для доставки
class ShippingService {
    public void shipItem(String item) {
        System.out.println("Відправка товару: " + item);
    }
}

// Фасад
class ShopFacade {
    private PaymentService paymentService;
    private ShippingService shippingService;

    public ShopFacade() {
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
    }

    public void buyItem(String item, double amount) {
        paymentService.processPayment(amount);
        shippingService.shipItem(item);
    }
}

// Використання
public class Facade {
    public static void main(String[] args) {
        ShopFacade shop = new ShopFacade();
        shop.buyItem("Футболка", 200);
    }
}
