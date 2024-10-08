// Інтерфейс обробника
interface DiscountHandler {
    void setNext(DiscountHandler handler);
    double applyDiscount(double price);
}

// Базовий клас обробника
abstract class BaseDiscountHandler implements DiscountHandler {
    private DiscountHandler nextHandler;

    @Override
    public void setNext(DiscountHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public double applyDiscount(double price) {
        if (nextHandler != null) {
            return nextHandler.applyDiscount(price);
        }
        return price;
    }
}

// Обробник для звичайного клієнта
class RegularCustomerDiscountHandler extends BaseDiscountHandler {
    @Override
    public double applyDiscount(double price) {
        if (price > 100) {
            price *= 0.95; // 5% знижка для звичайних клієнтів
        }
        return super.applyDiscount(price);
    }
}

// Обробник для VIP клієнта
class VipCustomerDiscountHandler extends BaseDiscountHandler {
    @Override
    public double applyDiscount(double price) {
        if (price > 200) {
            price *= 0.90; // 10% знижка для VIP клієнтів
        }
        return super.applyDiscount(price);
    }
}

// Обробник для святкових знижок
class HolidayDiscountHandler extends BaseDiscountHandler {
    @Override
    public double applyDiscount(double price) {
        price *= 0.85; // 15% знижка на свята
        return super.applyDiscount(price);
    }
}

// Використання
public class Chain {
    public static void main(String[] args) {
        DiscountHandler regularHandler = new RegularCustomerDiscountHandler();
        DiscountHandler vipHandler = new VipCustomerDiscountHandler();
        DiscountHandler holidayHandler = new HolidayDiscountHandler();

        // Створюємо ланцюг: Regular -> VIP -> Holiday
        regularHandler.setNext(vipHandler);
        vipHandler.setNext(holidayHandler);

        double price = 250;
        System.out.println("Оригінальна ціна: " + price + " грн");
        double finalPrice = regularHandler.applyDiscount(price);
        System.out.println("Фінальна ціна зі знижкою: " + finalPrice + " грн");
    }
}
