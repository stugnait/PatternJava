class OldDeliveryService {
    public void deliver(String item) {
        System.out.println("Доставка товару: " + item);
    }
}

// Новий інтерфейс
interface NewDeliveryService {
    void ship(String item);
}

// Адаптер
class DeliveryAdapter implements NewDeliveryService {
    private OldDeliveryService oldService;

    public DeliveryAdapter(OldDeliveryService oldService) {
        this.oldService = oldService;
    }

    @Override
    public void ship(String item) {
        oldService.deliver(item);
    }
}

// Використання
public class Adapter {
    public static void main(String[] args) {
        OldDeliveryService oldService = new OldDeliveryService();
        NewDeliveryService adapter = new DeliveryAdapter(oldService);
        adapter.ship("Футболка");
    }
}
