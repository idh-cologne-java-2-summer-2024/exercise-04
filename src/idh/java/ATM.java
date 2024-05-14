package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Random;

public class ATM {

	// initial cash in the ATM
	int cash = 100;
	int nextPosition = 0;

	// accounts known to the ATM
	Account[] accounts = new Account[5];

	public ATM() {
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, random.nextInt(1000));
		}
	}
	// this.accounts = new Account(nextPosition);

	public void addAccount() throws Exception {
		if (nextPosition < accounts.length) {
			Random random = new Random();
			accounts[nextPosition++] = new Account(nextPosition, random.nextInt(1000));
		} else
			throw new Exception("Accountsystem full");

	}

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run(ATM atm) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			AccountIterator iter = new AccountIterator(accounts);
			try {
				while (iter.hasNext()) {

					System.out.print("Enter your account number: ");
					int accountNumber = Integer.parseInt(br.readLine());
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(accountNumber, amount);
				}
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

		atm.run(atm);
	};

	/**
	 * Retrieves the account given an id.
	 * 
	 * @param id
	 * @return
	 */
	protected Account getAccount(int id) {
		AccountIterator accIter = new AccountIterator(accounts);
		while (accIter.hasNext()) {
			Account current = accIter.next();
			if (current.id == id) {
				return current;

			}
		}
		return null;
	}

	public int getSize() {
		return accounts.length;
	}

}
