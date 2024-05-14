package idh.java;

//This class represents an account in our bank.
 
public class Account {
	private int id;
	private int balance;

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

    public void setBalance(int balance) {
	this.balance = balance;
    }

    /**
     * Withdraws a sum of money from the account
     * 
     * @param sum
     */
    public void withdraw(int amount) {
	balance -= amount;
    }

}
