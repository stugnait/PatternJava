import java.util.ArrayList;
import java.util.List;

// Інтерфейс ітератора
interface IIterator {
    boolean hasNext();
    Object next();
}

// Інтерфейс колекції
interface Collection {
    Iterator getIterator();
}

// Клас товару
class IteratorProduct {
    public String name;

    public IteratorProduct(String name) {
        this.name = name;
    }
}

// Клас колекції товарів
class ProductCollection implements Collection {
    private List<IteratorProduct> products = new ArrayList<>();

    public void addProduct(IteratorProduct product) {
        products.add(product);
    }

    @Override
    public Iterator getIterator() {
        return new ProductIterator(products);
    }
}

class ProductIterator implements IIterator {
    private List<ProductIterator> products;
    private int position = 0;

    public ProductIterator(List<ProductIterator> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return position < products.size();
    }

    @Override
    public ProductIterator next() {
        return products.get(position++);
    }
}

// Використання
public class Iterator {
    public static void main(String[] args) {
        ProductCollection collection = new ProductCollection();
        collection.addProduct(new IteratorProduct("Футболка"));
        collection.addProduct(new IteratorProduct("Джинси"));
        collection.addProduct(new IteratorProduct("Куртка"));

        Iterator iterator = collection.getIterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product.name);
        }
    }
}
