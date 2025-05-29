//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED
    }

    enum ShippingStatus {
        STANDARD,
        TWO_DAY,
        OVERNIGHT,
    }

    public static void main(String[] args) {
        // Product Details
        int productID = 1;
        int productCategory = 2;
        double productCost = 2.56f;
        double productPrice = 4.99f;
        int productQuantity = 78;
        String businessName;
        String contactInformation;
        String itemDescription;

        OrderStatus orderStatus = OrderStatus.PROCESSING;
        ShippingStatus shipStatus = ShippingStatus.TWO_DAY;

        System.out.println("ID: " + productID + "\nCategory: "+ productCategory + "\nCost: $" + productCost + "\nPrice: $" + productPrice + "\nQuantity: " + productQuantity);


        // Calculate total cost
        double totalCost = productCost * productQuantity;
        System.out.println("Total Cost: $" + totalCost);

        // Calculate profile margin
        double profitMargin = productPrice - productCost;
        System.out.println("Profit Margin: $" + profitMargin);

        // Potential Profit
        double potentialProfit = profitMargin * productQuantity;
        System.out.println("Potential Profit: $" + potentialProfit);


        // Print Statuses
        System.out.println(ShippingStatus.STANDARD);
        System.out.println(ShippingStatus.TWO_DAY);
        System.out.println(ShippingStatus.OVERNIGHT);

        orderStatus = OrderStatus.PROCESSING;
        System.out.println("Order Status: " + orderStatus);

        System.out.println(OrderStatus.PENDING);
        System.out.println(OrderStatus.PROCESSING);
        System.out.println(OrderStatus.SHIPPED);
        System.out.println(OrderStatus.DELIVERED);

        shipStatus = ShippingStatus.TWO_DAY;
        System.out.println("Ship Status: " + shipStatus);
    }
}