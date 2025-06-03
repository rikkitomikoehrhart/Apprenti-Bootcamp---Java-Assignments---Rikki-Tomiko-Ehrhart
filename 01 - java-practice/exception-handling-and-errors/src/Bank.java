public class Bank {
    private String routingNumber;
    private String name;

    public Bank(String routingNumber, String name) {
        this.routingNumber = routingNumber;
        this.name = name;
    }

    public String getBankInfo() {
        return String.format("%s: %s", name, routingNumber);
    }
}