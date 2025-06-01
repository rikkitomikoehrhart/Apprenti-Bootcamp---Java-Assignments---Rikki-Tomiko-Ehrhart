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
        FREE_SHIPPING
    }

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        // Product Details
        int productID = 1;
        int productCategory = 2;
        double productCost = 2.56f;
        double productPrice = 4.99f;
        int productQuantity = 78;
        String[] shippingAddresses = {"123 Main St", "456 Main St", "789 Main St"};
        String[] productSizes = {"small", "medium", "large"};
        String shipTo = "";
        String size = "";



        while (true) {
            // Exercise Shopping Cart Console IO
            System.out.print("Are you tax exempt? (Y or y for yes, anything else for no): ");
            String tax_response = io.nextLine();
            Boolean taxExempt;

            if (tax_response.equals("y") || tax_response.equals("Y")) {
                taxExempt = true;
            } else {
                taxExempt = false;
            }

            System.out.println("\n\n");
            System.out.println("Which shipping option would you like?");
            System.out.println("1. Standard (default)");
            System.out.println("2. Two-Day");
            System.out.println("3. Overnight");
            System.out.print("Make a selection : ");
            int shipSelection = Integer.parseInt(io.nextLine());
            ShippingStatus shipStatus = ShippingStatus.STANDARD;
            if (shipSelection == 2) {
                shipStatus = ShippingStatus.TWO_DAY;
            } else if (shipSelection == 3) {
                shipStatus = ShippingStatus.OVERNIGHT;
            } else {
                shipStatus = ShippingStatus.STANDARD;
            }

            System.out.println("\n\n");
            System.out.println("Product Sizes:");
            for (int i = 0; i < productSizes.length; i++) {
                System.out.println(i+1 + ". " + productSizes[i]);
            }
            System.out.print("Enter size: ");
            int sizeChoice = Integer.parseInt(io.nextLine());
            size = productSizes[sizeChoice-1];


            System.out.println("\n\n");
            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(io.nextLine());




            System.out.println("\n\n");
            System.out.println("Shipping Addresses:");
            for (int i = 0; i < shippingAddresses.length; i++) {
                System.out.println(i+1 + ". " + shippingAddresses[i]);
            }
            System.out.print("Which address: ");
            int shipToChoice = Integer.parseInt(io.nextLine());
            shipTo = shippingAddresses[shipToChoice-1];



            System.out.println("\n\n");
            System.out.print("Enter Promo Code for free shipping: ");
            String promoCode = io.nextLine();



            double billSubTotal = quantity * productPrice;
            double discount = 0;
            double taxRate;
            double twoDayShipping = 5.00f;
            double overNightShipping = 10.00f;

            if (taxExempt) {
                // no tax
                System.out.println("Tax rate 0");
                taxRate = 0.0f;
            } else {
                System.out.println("Tax rate 7%");
                taxRate = 0.07f;
            }

            if (billSubTotal > 100.0f) {
                discount = 0.05;
            } else if (billSubTotal > 500.0f) {
                discount = 0.1f;
            }

            String currentPromo = "SUMMERSHIP";
            if (promoCode.equals(currentPromo)) {
                shipStatus = ShippingStatus.FREE_SHIPPING;
            }

            double shippingCost = switch (shipStatus) {
                case ShippingStatus.TWO_DAY -> twoDayShipping;
                case ShippingStatus.OVERNIGHT -> overNightShipping;
                default -> 0.00f;
            };

            System.out.println("\n\n\n==========================================");
            System.out.println("\nTax amount: " + (billSubTotal * taxRate));
            System.out.println("Shipping cost: " + shippingCost);
            System.out.println("Subtotal: " + billSubTotal);
            System.out.println("Discount: " + (billSubTotal * discount));
            double finalBill = (billSubTotal * taxRate) + shippingCost + billSubTotal - (billSubTotal * discount);

            System.out.printf("%nYour final bill is $%.2f", finalBill);

            System.out.println("\n\n");
            System.out.print("Confirm Order (y to confirm, anything else to start over): ");

            String confirmation = io.nextLine();

            if (!confirmation.equals("y")) {
                continue;
            }
            break;
        }

        System.out.println("Thank you for your order");














    }
}