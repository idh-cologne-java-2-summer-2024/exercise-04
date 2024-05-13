package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ATM {

    // initial cash in the ATM
    int cash = 1000;

  
    Bank owner;
    
   

    public ATM(Bank owner) {
	// create accounts with varying balances
    this.owner = owner;
	
    }
    
    public Bank getBank() {
	 return this.owner;
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
	Account account = owner.getAcc(accountNumber);
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
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
	ATM test = new ATM(new Bank(10));
	//test.run();

	System.out.println(test.getBank().getDescription());

	AccountIterator iter = new AccountIterator(test.getBank());

	while (iter.hasNext()) {
	    System.out.println(iter.next().getId() );
	}
	System.out.println();

    }
// Aufgabe 2
    protected Account getAccount(int id) {
		for (Account account : owner) {
			if (account.getId() == id)
				return account;
			}
		
		return null;
   
    }
		
    }


