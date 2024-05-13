package idh.java;

/**
 * This class represents an account in our bank.
 * 
 * @author reiterns
 *
 */
public class Account {
    // the balance of the account
    private int balance;
    // the maximum withdrawal amount
    private int maxWithdrawal;
    // the id of the account
    private int id;

    public Account(int id, int status, int maxWithdrawal) {
        this.id = id;
        this.balance = status;
        this.maxWithdrawal = maxWithdrawal;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public int getMaxWithdrawal() {
        return maxWithdrawal;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}