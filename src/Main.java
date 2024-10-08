interface TShirtInterface {
    void buy();
}

interface SweaterInterface {
    void buy();
}

class SportTShirt implements TShirtInterface {
    public void buy() {
        System.out.println("SportTShirt");
    }
}

class ClassicTShirt implements TShirtInterface {
    public void buy() {
        System.out.println("ClassicTShirt");
    }
}

class SportSweater implements SweaterInterface {
    public void buy() {
        System.out.println("SportSweater");
    }
}

class ClassicSweater implements SweaterInterface {
    public void buy() {
        System.out.println("ClassicSweater");
    }
}

interface ClothingFactoryInterface {
    TShirtInterface createTShirt();
    SweaterInterface createSweater();
}

class SportClothingFactory implements ClothingFactoryInterface {
    public TShirtInterface createTShirt() {
        return new SportTShirt();
    }

    public SweaterInterface createSweater() {
        return new SportSweater();
    }
}

class ClassicClothingFactory implements ClothingFactoryInterface {
    public TShirtInterface createTShirt() {
        return new ClassicTShirt();
    }

    public SweaterInterface createSweater() {
        return new ClassicSweater();
    }
}

public class Main {
    public static void main(String[] args) {
        ClothingFactoryInterface sportFactory = new SportClothingFactory();
        ClothingFactoryInterface classicFactory = new ClassicClothingFactory();

        TShirtInterface sportTShirt = sportFactory.createTShirt();
        SweaterInterface sportSweater = sportFactory.createSweater();
        sportTShirt.buy();
        sportSweater.buy();

        TShirtInterface classicTShirt = classicFactory.createTShirt();
        SweaterInterface classicSweater = classicFactory.createSweater();
        classicTShirt.buy();
        classicSweater.buy();
    }
}
