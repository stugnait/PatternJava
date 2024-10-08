// Інтерфейс товару
interface Product {
    double getPrice();
    String getDescription();
}

// Базовий товар
class TShirt implements Product {
    @Override
    public double getPrice() {
        return 20.0;
    }

    @Override
    public String getDescription() {
        return "Футболка";
    }
}

// Декоратор
abstract class ProductDecorator implements Product {
    protected Product product;

    public ProductDecorator(Product product) {
        this.product = product;
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }
}

// Подарункова упаковка
class GiftWrap extends ProductDecorator {
    public GiftWrap(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return product.getPrice() + 5.0;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " у подарунковій упаковці";
    }
}

// Використання
public class Decorator {
    public static void main(String[] args) {
        Product tshirt = new TShirt();
        Product giftWrappedTshirt = new GiftWrap(tshirt);
        System.out.println(giftWrappedTshirt.getDescription() + " коштує " + giftWrappedTshirt.getPrice());
    }
}
