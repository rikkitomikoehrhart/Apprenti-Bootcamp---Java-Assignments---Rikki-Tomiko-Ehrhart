//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    enum OrderStatus {
        ORDERED,
        WAREHOUSE,
        SHIPPED,
        DELIVERED,
        RETURNED
    }

    enum TrafficLight {
        RED,
        YELLOW,
        GREEN
    }

    public static void main(String[] args) {
        // order status, 1 ordered, 2 warehouse, 3 shipped, 4 delivered, 5 returned

        OrderStatus status = OrderStatus.WAREHOUSE;

        if (status == OrderStatus.WAREHOUSE) {
            // do stuff
        }

        System.out.println(OrderStatus.DELIVERED);
        System.out.println(OrderStatus.DELIVERED.ordinal());

        TrafficLight[] values = TrafficLight.values();
        TrafficLight light = values[2];

        System.out.println(light);
        System.out.println(light.ordinal());
    }
}