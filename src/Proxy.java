
interface ProductProxy {
    double getPrice();
}

class RealTShirt implements ProductProxy {
    @Override
    public double getPrice() {
        return 20.0;
    }
}

class TShirtProxy implements ProductProxy {
    private RealTShirt realTShirt;

    @Override
    public double getPrice() {
        if (realTShirt == null) {
            realTShirt = new RealTShirt();
        }
        return realTShirt.getPrice();
    }
}

public class Proxy {
    public static void main(String[] args) {
        ProductProxy proxy = new TShirtProxy();
        System.out.println(proxy.getPrice());
    }
}
