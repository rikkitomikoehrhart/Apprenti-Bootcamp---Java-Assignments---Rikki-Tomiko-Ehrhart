/*
   Bank / Financial Institution (id routing number)
   Keeps track of your money (balance)
   It has a unique ID (account number)
   Withdraw money
   Transaction History
   Deposit Money
   Owner (Name, Tax ID, address)

   Data:
        - Routing Number
        - Balance
        - Account Number
        - Transaction History (Type: Debit/Credit, Amount, Date,)
        - Owner (Name, Tax ID, Address)


   Behaviors:
        - Withdraw
        - Deposit
        - View Balance
        - View Transaction History
        - View Account Info


    "Has-a" versus "Is-a"
    ex. Does the "Owner" "Has-A" account or "Is-a" account.


 */

public class Account {
    // composition!
    private Bank bank;
    private Owner owner;
    private Transaction[] transactionHistory;
    private String accountid;
    private double balance;
    private int currentIndex = 0;

    public Account(Bank bank, Owner owner, String accountid, double balance) {
        this.bank = bank;
        this.owner = owner;
        this.accountid = accountid;
        this.balance = balance;

        transactionHistory = new Transaction[10];
    }

    public boolean withdraw(double amount) {
        // foreign transaction fee
        if (balance - amount < 0) {
            return false;
        } else {
            balance -= amount;
            this.transactionHistory[currentIndex] = new Transaction(amount, "6/3/2025", TransactionType.DEBIT);
            currentIndex++;
            return true;
        }
    }

    public void deposit(double amount) {
        balance += amount;
        this.transactionHistory[currentIndex] = new Transaction(amount, "6/3/2025", TransactionType.CREDIT);
        currentIndex++;
    }

    public String getAccountInfo() {
        return String.format("Account Information%n=======================%n" +
                "Bank Info: %s%n" +
                "Account Number: %s%n" +
                "Owner Name: %s%n" +
                "Balance: $%.2f", this.bank.getBankInfo(), this.getAccountid(), this.owner.getName(), this.balance);
    }

    public String getAccountid() {
        if (accountid.length() < 4) {
            return "xxx";
        }

        return "x" + accountid.substring(accountid.length() - 4);
    }

    public String getTransactionHistory() {
        String output = "";

        for (int i = 0; i < transactionHistory.length; i++) {
            if (transactionHistory[i] != null) {
                output += String.format("%s%n", transactionHistory[i].getTransactionInfo());
            }
        }

        return output;
    }
    /*
    How do I organize this? Single Reponsibility Principle
    "Has-a" vs "Is-A", Duplication, Simplicity
     */
}