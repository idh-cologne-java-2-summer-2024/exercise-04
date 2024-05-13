package idh.java;

import java.io.BufferedReader;
import java.util.Iterator;
import java.io.InputStreamReader;
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

   
    class AccountIterator implements Iterator<Account>{
    	Account[]bank_accounts; 
    	int c=0;
    	
		AccountIterator(Account[]bank_account) {
			this.bank_accounts=bank_account; 
		}
		
		public boolean hasNext() {
			if (c>=bank_accounts.length) {
				return true; 	
			}
			return false;
		}

		public Account next() {
			return this.bank_accounts[c++] ;
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
			
	

	AccountIterator aIter= new AccountIterator (this.accounts);
	Account account = null;
	while(aIter.hasNext()){
		account=aIter.next(); 
		if(accountNumber== account.id) {
			break;
		}
		else account=null; 
	}
	if (account==null) {
		System.out.println("Sorry, this account does not exists.");
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
	atm.run();
	 
			
		}
    }

