
interface DiscountStrategy {
    double getDiscount(double price);
}

class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double getDiscount(double price) {
        return price;
    }
}

class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double getDiscount(double price) {
        return price - (price * percentage / 100);
    }
}

class StrategyProduct {
    private DiscountStrategy strategy;

    public StrategyProduct(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price) {
        return strategy.getDiscount(price);
    }
}


public class StrategyPattern {
    public static void main(String[] args) {
        StrategyProduct product = new StrategyProduct(new NoDiscountStrategy());
        System.out.println("Ціна без знижки: " + product.getPrice(100));

        product.setStrategy(new PercentageDiscountStrategy(10));
        System.out.println("Ціна зі знижкою 10%: " + product.getPrice(100));
    }
}
