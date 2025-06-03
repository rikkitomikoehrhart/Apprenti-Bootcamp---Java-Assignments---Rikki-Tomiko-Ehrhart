public class Transaction {
    private double amount;
    private String date;
    private TransactionType type;

    public Transaction(double amount, String date, TransactionType type) {
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public String getTransactionInfo() {
        return String.format("%s | %s | $%.2f", type, date, amount);
    }
}
