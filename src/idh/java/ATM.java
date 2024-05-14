package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ATM {

    // initial cash in the ATM
    int cash = 100;

    // accounts known to the ATM
    Account[] accounts = new Account[5];

    public ATM() {
	// create accounts with varying balances
	Random random = new Random();
	for (int i = 0; i < accounts.length; i++) {
	    accounts[i] = new Account(i, random.nextInt(1000));
	}
    }

    /**
     * Main command loop of the ATM Asks the user to enter a number, and passes this
     * number to the function cashout(...) which actually does the calculation and
     * produces money. If the user enters anything else than an integer number, the
     * loop breaks and the program exists
     */
    public void run() {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	while (true) {
	    try {
		System.out.print("Enter your account number: ");
		int accountNumber = Integer.parseInt(br.readLine());
		System.out.print("Enter the amount to withdraw: ");
		int amount = Integer.parseInt(br.readLine());
		cashout(accountNumber, amount);
	    } catch (Exception e) {
		e.printStackTrace();
		break;
	    }
	}
    }

    public void cashout(int accountNumber, int amount) {
	// check for cash in the ATM
	if (amount > cash) {
	    System.out.println("Sorry, not enough cash left.");
	    return;
	}

	// check for existence of the account
	Account account = getAccount(accountNumber);
	if (account == null) {
	    System.out.println("Sorry, this account doesn't exist.");
	    return;
	}

	// check for balance of the account
	if (amount > account.getBalance()) {
	    System.out.println("Sorry, you're out of money.");
	    return;
	}

	// withdraw
	account.withdraw(amount);
	cash += amount;
	System.out.println("Ok, here is your money, enjoy!");

    };

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
	ATM atm = new ATM();
	atm.accessAccounts1();
	atm.run();
    };

    /**
     * Retrieves the account given an id.
     * 
     * @param id
     * @return
     */
    protected Account getAccount(int id) {
	for (int i = 0; i < accounts.length; i++) {
	    if (accounts[i].getId() == id)
		return accounts[i];
	}
	return null;
    }
 // ...
    private class AccountIterator implements Iterator<Account> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < accounts.length && accounts[currentIndex] != null;
        }

        @Override
        public Account next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return accounts[currentIndex++];
        }
    }

    // Method to retrieve an iterator for accounts
    public Iterator<Account> getAccountIterator1() {
        return new AccountIterator();
    }

    // Accessing accounts using while loop and iterator
    public void accessAccounts1() {
        Iterator<Account> iterator = getAccountIterator1();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            // Do something with the account
            System.out.println("Account ID: " + account.getId() + ", Balance: " + account.getBalance());
        }
    }
    
    // AccountIterator
    private class AccountIterator1 implements Iterator<Account> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < accounts.length && accounts[currentIndex] != null;
        }

        @Override
        public Account next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return accounts[currentIndex++];
        }
    }

    // retrieve an iterator for accounts
    public Iterator<Account> getAccountIterator() {
        return new AccountIterator();
    }

    // Accessing accounts using while-loop
    public void accessAccounts() {
        Iterator<Account> iterator = getAccountIterator1();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            // Do something with the account
            System.out.println("Account ID: " + account.getId() + ", Balance: " + account.getBalance());
        }
    }
}
