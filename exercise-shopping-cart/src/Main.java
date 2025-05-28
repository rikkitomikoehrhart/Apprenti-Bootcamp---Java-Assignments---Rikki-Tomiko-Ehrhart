//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Product Details
        int productID = 1;
        int productCategory = 2;
        double productCost = 2.56f;
        double productPrice = 4.99f;
        int productQuantity = 78;

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
    }
}