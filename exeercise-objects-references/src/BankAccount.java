public class BankAccount {
    String owner;
    double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void displayBalance() {
        System.out.printf("Balance (%s): $%.2f%n", owner, balance);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
