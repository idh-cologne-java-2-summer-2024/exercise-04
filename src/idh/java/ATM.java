package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ATM {

    // initial cash in the ATM
    int cash = 1000;

    // accounts known to the ATM
    Account[] accounts;
    
    
    int nextPosition = 0;

    public ATM(int numberOfAccounts) {
	// create accounts with varying balances
   this.accounts = new Account[numberOfAccounts];
	Random random = new Random();
	for (int i = 0; i < accounts.length; i++) {
	    accounts[i] = new Account(i, random.nextInt(1000));
	}
	
    }
    
    public int size() {
    	return accounts.length;
        }

        public Account getAcc(int account) {
    	return accounts[account];
        }

       
    
    public void addAccount(int id, int status) throws Exception {
    	if (nextPosition < accounts.length)
    	    accounts[nextPosition++] = new Account(id,status);
    	else
    	    throw new Exception("Class full");
        }
    public String getDescription() {
    	StringBuilder buf = new StringBuilder();
    	buf.append(("ATM Management "+'\n'));
    	    buf.append('-');
    	buf.append('\n');
    	buf.append("Accounts: ");
    	buf.append(accounts);
    	buf.append('\n');
    	return buf.toString();
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
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
	ATM test = new ATM(10);
	test.run();

	System.out.println(test.getDescription());

	AccountIterator iter = new AccountIterator(test);

	while (iter.hasNext()) {
	    System.out.println(iter.next().getId() );
	}
	System.out.println();

    }

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

}
