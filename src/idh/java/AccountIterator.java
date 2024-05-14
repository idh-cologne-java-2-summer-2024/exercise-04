package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	private Account[] accounts;
	int accountCounter;
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
		accountCounter = 0;
	}
	
	public boolean hasNext() {
		return  accountCounter < accounts.length;
	}

	
	public Account next() {
		return accounts[accountCounter++];
	}

}
