package ATM;
import java.util.*;

public class ATM {
    private List<Customer> customers = new ArrayList<>();
    private Random rand = new Random();
    private FileManager fileManager = new FileManager();

    public ATM() {
        customers.add(new Customer("Harsha", "h1", new Account("12345", 1000, 1234)));
        customers.add(new Customer("karthik", "r1", new Account("67890", 2000, 5678)));
        customers.add(new Customer("sumadhur", "s1", new Account("45665", 5000, 1111)));
        customers.add(new Customer("zubair", "z1", new Account("61561", 8000, 8585)));
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
        String id = "ID" + (100000 + rand.nextInt(900000));
        Transaction t = new DepositTransaction(id, amount);
        return performTransaction(acc, t);
    }
    public String withdraw(Account acc, double amount) {
        String id = "ID" + (100000 + rand.nextInt(900000));
        Transaction t = new WithdrawTransaction(id, amount);
        return performTransaction(acc, t);
    }
    private String performTransaction(Account acc, Transaction t) {
        boolean success = t.execute(acc);
        if (success) {
            acc.getTransactions().add(t);
            fileManager.saveData(t.toString());
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