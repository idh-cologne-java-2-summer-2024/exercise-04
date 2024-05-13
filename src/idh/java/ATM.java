package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Random;

public class ATM {

    // initial cash in the ATM
    int cash = 1000;

    Bank bank;
    public ATM(Bank bank) {
    	this.bank = bank;
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
	Account account = bank.getAccount(accountNumber);
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
        // Create Bank
        Bank bank = new Bank();
        // Initialize accounts in the bank
        bank.initializeAccounts();
        // Create bank reference
        ATM atm = new ATM(bank);
        // show accounts
        atm.iterateAccounts();
        atm.run();
    };

   
   

    public void iterateAccounts() {
    	  for (Account account : bank) {
            System.out.println("Account ID: " + account.getId() + ", Balance: " + account.getBalance());
        }
    }
    }


    /**
    * Class bank
    */
    class Bank implements Iterable<Account> {
    // accounts stored in the bank
       Account[] accounts = new Account[5];

     /**
     * Initialize accounts
     */
    public void initializeAccounts() {
       Random random = new Random();
       for (int i = 0; i < accounts.length; i++) {
       accounts[i] = new Account(i, random.nextInt(1000));
     }
    }
    
    /**
     * Retrieves the account given an id.
     * 
     * @param id
     * @return
     */
    
    public Account getAccount(int id) {
       for (int i = 0; i < accounts.length; i++) {
       if (accounts[i].getId() == id)
         return accounts[i];
    }
         return null;
    }
    
    
    
    public Iterator<Account> iterator() {
         return new AccountIterator();
    }


    /**
     * iterating accounts
     */
    private class AccountIterator implements Iterator<Account> {
    private int currentIndex;

    public AccountIterator() {
       this.currentIndex = 0;
    }

    public boolean hasNext() {
       return currentIndex < accounts.length;
    }

    public Account next() {
       return accounts[currentIndex++];
     }
    }
    
     
}
