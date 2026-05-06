package ATM;

public class Customer {
    private String name;
    private String customerId;
    private Account account;
    public Customer(String name, String customerId, Account account) {
        this.name = name;
        this.customerId = customerId;
        this.account = account;
    }
    public Account getAccount() {
        return account;
    }
}