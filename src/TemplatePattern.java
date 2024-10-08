// Абстрактний клас
abstract class OrderProcessTemplate {
    public final void processOrder() {
        selectItem();
        makePayment();
        deliver();
    }

    protected abstract void selectItem();
    protected abstract void makePayment();
    protected abstract void deliver();
}

// Конкретний клас
class OnlineOrder extends OrderProcessTemplate {
    @Override
    protected void selectItem() {
        System.out.println("Товар обрано в онлайн магазині");
    }

    @Override
    protected void makePayment() {
        System.out.println("Оплата здійснена через онлайн банкінг");
    }

    @Override
    protected void deliver() {
        System.out.println("Товар доставлений кур'єром");
    }
}

// Використання
public class TemplatePattern {
    public static void main(String[] args) {
        OrderProcessTemplate order = new OnlineOrder();
        order.processOrder();
    }
}
