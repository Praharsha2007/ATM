package ATM;
import java.util.*;

public class Account {
    private String accountNumber;
    private double balance;
    private int pin;
    private List<Transaction> transactions;
    public Account(String accountNumber, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
        transactions = new ArrayList<>();
    }
    
    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }
    
    public String performTransaction(Transaction t) {
        boolean success = t.execute(this);
        if (success) {
            transactions.add(t);
            return "Transaction Successful";
        } else {
            return "Insufficient Balance";
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void showTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
}