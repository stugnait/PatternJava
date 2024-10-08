// Інтерфейс кольору
interface Color {
    String applyColor();
}

// Реалізація кольорів
class RedColor implements Color {
    @Override
    public String applyColor() {
        return "Червоний";
    }
}

class BlueColor implements Color {
    @Override
    public String applyColor() {
        return "Синій";
    }
}

// Абстракція одягу
abstract class Clothing {
    protected Color color;

    public Clothing(Color color) {
        this.color = color;
    }

    abstract String getDescription();
}

// Реалізація одягу (Футболка)
class BridgeTShirt extends Clothing {
    public BridgeTShirt(Color color) {
        super(color);
    }

    @Override
    public String getDescription() {
        return "Футболка кольору " + color.applyColor();
    }
}

// Використання
public class Bridge {
    public static void main(String[] args) {
        Clothing tshirt = new BridgeTShirt(new RedColor());
        System.out.println(tshirt.getDescription());  // Виведе: Футболка кольору Червоний
    }
}
