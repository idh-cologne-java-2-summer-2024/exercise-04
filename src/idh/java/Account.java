package idh.java;

/**
 * This class represents an account in our bank.
 * 
 * @author reiterns
 *
 */
public class Account {
    // the balance of the account
    int balance;

    // the id of the account
    int id;
    //balance war mal status vor her 
    public Account(int id, int balance) {
	this.id = id;
	this.balance = balance;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getBalance() {
	return balance;
    }

    public void setBalance(int status) {
	this.balance = status;
    }

    
    
    /**
     * Withdraws a sum of money from the account
     * 
     * @param sum
     */
    public void withdraw(int sum) {
	this.balance = balance - sum;
    }

}
