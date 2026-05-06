package ATM;
public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(String transactionId, double amount) {
        super(transactionId, amount);
    }
    @Override
    public boolean execute(Account account) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        return super.toString() + " | Type: Withdraw";
    }
}