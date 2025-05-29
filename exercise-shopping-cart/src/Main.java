import java.util.Scanner;


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
        Scanner io = new Scanner(System.in);


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


        // Exercise Shopping Cart Console IO
        System.out.print("Are you tax exempt? (Y or y for yes, anything else for no): ");
        String tax_response = io.nextLine();
        Boolean taxExempt;

        if (tax_response.equals('y') || tax_response.equals('Y')) {
            taxExempt = true;
        } else {
            taxExempt = false;
        }

        System.out.println("Which shipping option would you like?");
        System.out.println("1. Standard (default)");
        System.out.println("2. Two-Day");
        System.out.println("3. Overnight");
        System.out.print("Make a selection : ");
        int shipSelection = Integer.parseInt(io.nextLine());

        if (shipSelection == 2) {
            shipStatus = ShippingStatus.TWO_DAY;
        } else if (shipSelection == 3) {
            shipStatus = ShippingStatus.OVERNIGHT;
        } else {
            shipStatus = ShippingStatus.STANDARD;
        }


        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(io.nextLine());

        System.out.print("Enter Promo Code for free shipping: ");
        String promoCode = io.nextLine();


        System.out.printf("Tax Exempt Status: %b%nShipping Selected: %s%nOrder Quantity: %d%nPromo Code: %s", taxExempt, shipStatus, quantity, promoCode);
    }
}