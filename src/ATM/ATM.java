package ATM;
import java.util.*;

public class ATM {
    private List<Customer> customers = new ArrayList<>();
    private Random rand = new Random();

    public ATM() {
        customers.add(new Customer("Harsha", "C001", new Account("12345", 1000, 1234)));
        customers.add(new Customer("Rahul", "C002", new Account("67890", 2000, 5678)));
        customers.add(new Customer("Anu", "C003", new Account("11111", 500, 1111)));
    }
    public Account authenticate(int pin) {
        for (Customer c : customers) {
            if (c.getAccount().validatePin(pin)) {
                return c.getAccount();
            }
        }
        return null;
    }
    public String deposit(Account acc, double amount) {
        String txnId = "TXN" + (100000 + rand.nextInt(900000));
        Transaction t = new DepositTransaction(txnId, amount);
        return processTransaction(acc, t);
    }
    public String withdraw(Account acc, double amount) {
        String txnId = "TXN" + (100000 + rand.nextInt(900000));
        Transaction t = new WithdrawTransaction(txnId, amount);
        return processTransaction(acc, t);
    }
    private String processTransaction(Account acc, Transaction t) {
        boolean success = t.execute(acc);

        if (success) {
            acc.getTransactions().add(t);
            return "Transaction Successful";
        } else {
            return "Insufficient Balance";
        }
    }
    public double getBalance(Account acc) {
        return acc.getBalance();
    }
    public List<Transaction> getHistory(Account acc) {
        return acc.getTransactions();
    }
}