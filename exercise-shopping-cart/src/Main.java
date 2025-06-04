import java.util.Scanner;


public class Main {
    static Scanner io = new Scanner(System.in);



    public static void main(String[] args) {
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
            // Tax Exempt
            String tax_response = promptUserForString("Are you tax exempt? (Y or y for yes, anything else for no): ", new String[]{"y", "Y", "n", "N"});
            Boolean taxExempt;

            if (tax_response.equals("y") || tax_response.equals("Y")) {
                taxExempt = true;
            } else {
                taxExempt = false;
            }


            // Shipping Option
            System.out.println("\n\n");
            System.out.println("Which shipping option would you like?");
            String[] shippingChoices = {"Standard (default)", "Two-Day", "Overnight"};
            displayChoices(shippingChoices);


            int shipSelection = promptUserForInt("Make a selection: ", shippingChoices.length);
            ShippingStatus shipStatus = ShippingStatus.STANDARD;
            if (shipSelection == 2) {
                shipStatus = ShippingStatus.TWO_DAY;
            } else if (shipSelection == 3) {
                shipStatus = ShippingStatus.OVERNIGHT;
            } else {
                shipStatus = ShippingStatus.STANDARD;
            }


            // Product Sizes
            System.out.println("\n\n");
            System.out.println("Product Sizes:");
            displayChoices(productSizes);
            int sizeChoice = promptUserForInt("Enter size: ", productSizes.length);
            size = productSizes[sizeChoice-1];


            // Quantity
            System.out.println("\n\n");
            int quantity = promptUserForInt("Enter quantity: ", productQuantity);


            // Shipping Address
            System.out.println("\n\n");
            System.out.println("Shipping Addresses:");
            displayChoices(shippingAddresses);
            int shipToChoice = promptUserForInt("Which address: ", shippingAddresses.length);
            shipTo = shippingAddresses[shipToChoice-1];


            // Promo Code
            System.out.println("\n\n");
            String promoCode = promptUserForString("Enter Promo Code for free shipping (or none): ", new String[]{"FREE", "none", "NONE", "None"});



            // Bill Calculations
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

    private static void displayChoices(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i+1) + ". " + choices[i]);
        }
    }

    private static String promptUserForString(String prompt, String[]validResponses) {
        System.out.println(prompt);
        String response;
        while (true) {
            try {
                response = io.nextLine();
                if (response == null || response.trim().isEmpty()) {
                    throw new IllegalArgumentException("Your response cannot be blank");
                }
                boolean validResponse = false;
                for (int i = 0; i < validResponses.length; i++) {
                    if (response.equals(validResponses[i])) {
                        validResponse = true;
                    }
                }

                if (!validResponse) {
                    throw new InvalidResponse("Invalid response.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Your response cannot be blank.");
            } catch (InvalidResponse e) {
                System.out.println("Your response is invalid.");
            }
        }


        return response;
    }

    private static int promptUserForInt(String prompt, int validResponses) {
        int response;

        while (true) {
            try {
                System.out.println(prompt);
                response = Integer.parseInt(io.nextLine());
                if (response > validResponses || response <= 0) {
                    throw new InvalidResponse("Your response is out of range.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                continue;
            } catch (InvalidResponse e) {
                System.out.println("Invalid selection.");
                continue;
            }
        }

        return response;
    }




}