import java.util.HashMap;
import java.util.Map;

// Інтерфейс одягу
interface FlyClothing {
    String getType();
}

class FlyTShirt implements FlyClothing {
    @Override
    public String getType() {
        return "Футболка";
    }
}

class FlyJeans implements FlyClothing {
    @Override
    public String getType() {
        return "Джинси";
    }
}

// Flyweight фабрика
class ClothingFactory {
    private Map<String, FlyClothing> clothingPool = new HashMap<>();

    public FlyClothing getClothing(String type) {
        if (!clothingPool.containsKey(type)) {
            switch (type) {
                case "TShirt":
                    clothingPool.put(type, new FlyTShirt());
                    break;
                case "Jeans":
                    clothingPool.put(type, new FlyJeans());
                    break;
            }
        }
        return clothingPool.get(type);
    }
}


public class Flyweight {
    public static void main(String[] args) {
        ClothingFactory factory = new ClothingFactory();
        FlyClothing tshirt = factory.getClothing("TShirt");
        FlyClothing jeans = factory.getClothing("Jeans");

        System.out.println(tshirt.getType());  // Виведе: Футболка
        System.out.println(jeans.getType());   // Виведе: Джинси
    }
}
