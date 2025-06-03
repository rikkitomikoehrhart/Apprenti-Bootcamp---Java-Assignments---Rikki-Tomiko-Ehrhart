public class Demo {
    public static void main(String[] args) {
        Bank bank = new Bank("12345789", "JP Morgan Chase");

        Owner o = new Owner("Eric Wise", "1234567890");

        Account acct = new Account(bank, o, "000001234", 100);

        acct.deposit(500);
        acct.withdraw(250);
        acct.withdraw(50);

        System.out.println(acct.getAccountInfo());
        System.out.println(acct.getTransactionHistory());
    }
}

/*

1. We write what we need to do in detail, in english
2. Nouns are candidates for Classes
3. Verbs are candidates for Methods
4. Adjectives are candidates for fields
    a. Fields are almost always private.
    b. Add get* and set* methods as needed to manipulate field values after object creation
5. Constructors in classes can have none, some, or all of the default field values. (It depends)
6. Classes can contain fields that are other classes (composition)
7. The goal is to have classes only contain "tightly related" fields and methods.


Volatility = how likely is it that my product will change (and with that the code)
 */