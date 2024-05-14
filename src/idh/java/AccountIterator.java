package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	Account accounts;
	int currentPosition = -1;
	
	public AccountIterator(Account accounts) {
		this.accounts = accounts;
	}

	public boolean hasNext() {
		return currentPosition < accounts.length() -1;
	}
	
	public Account next() {
		currentPosition++;
		return accounts[currentPosition];
	}
	}


