package idh.java;

import java.util.Random;
import java.util.Iterator;

public class Bank implements Iterable<Account> {
	
	Account[] accounts = new Account[5];
	
	AccountIterator iter = new AccountIterator(accounts);
	
	public Bank() {
		// create accounts with varying balances
		Random random = new Random();
		for (int i = 0; i < accounts.length; i++) {
		    accounts[i] = new Account(i+1, random.nextInt(1000));
		}
 	}

	public Iterator<Account> iterator() {
		return new AccountIterator(accounts);
	}
}
