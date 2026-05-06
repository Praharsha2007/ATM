package ATM;

public abstract class Transaction {
    protected String transactionId;
    protected double amount;
    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }
    public abstract boolean execute(Account account);
    
    public String toString() {
        return "ID: " + transactionId + " | Amount: " + amount;
    }
}