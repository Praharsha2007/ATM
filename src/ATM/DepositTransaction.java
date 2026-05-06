package ATM;
public class DepositTransaction extends Transaction {
    public DepositTransaction(String transactionId, double amount) {
        super(transactionId, amount);
    }
    @Override
    public boolean execute(Account account) {
        account.setBalance(account.getBalance() + amount);
        return true;
    }
    public String toString() {
        return super.toString() + " | Type: Deposit";
    }
}