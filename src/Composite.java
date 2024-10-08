import java.util.ArrayList;
import java.util.List;

interface ProductComposite {
    double getPrice();
}

class TShirtComposite implements ProductComposite {
    @Override
    public double getPrice() {
        return 20.0;
    }
}

class ProductBundle implements ProductComposite {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public double getPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}

public class Composite {
    public static void main(String[] args) {
        ProductBundle bundle = new ProductBundle();
        bundle.addProduct(new TShirt());
        bundle.addProduct(new TShirt());
        System.out.println("Ціна набору: " + bundle.getPrice());
    }
}
