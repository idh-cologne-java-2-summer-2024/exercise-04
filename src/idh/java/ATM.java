package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//TODO: implement Iterator-class Methods
public class ATM {
	AccountIterator accIT = new AccountIterator();
	// initial cash in the ATM
	int cash = 100;
	// accounts known to the ATM
//	Account[] accounts = new Account[5];
    ArrayList<Account> accs = new ArrayList<Account>();
    Iterator <Account> it = accs.iterator();

	/**
	 * create accounts with varying balances, each account is assigned an ID(i) and
	 * a random balance(random.nextInt)
	 * @apiNote right now, the accounts created in the seem to disappear the moment the <code>run()-method</code> is called
	 */
	
	public ATM() {

		Random random = new Random();
//	for (int i = 0; i < accounts.length; i++) {
//		Create 10 Account Objects
		int id = 0;
		while (accIT.hasNext() && id <= 10) {
		accs.add((new Account(id,random.nextInt(100))));
		id++;
//			accs[accIT.pos] = new Account(accIT.pos, random.nextInt(1000));
		}
	}

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 * @apiNote added the current balance of the account that is being chosen by the user
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("There are " + accs.size() + "accounts registered"+ "Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Current balance: " + accs.get(accountNumber).balance + "\nEnter the amount to withdraw: ");
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
//		System.out.println(atm.accs.get(0).balance); //this seems to work
		atm.run();
			
	};

	/**
	 * Retrieves the account given an id.
	 * 
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id) {
//		for (int i = 0; i < accounts.length; i++) {
//		iterate over ArrayList
		while(it.hasNext()) {
//			if (accounts[i].getId() == id)
			if(accs.contains(accs.get(id)))
				return accs.get(id);
		}
		return accs.get(id);
	}

}
