package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	private Account[] accounts;
	private int currentPos; // i
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
		currentPos = 0;
	}
	
	@Override
	public boolean hasNext() {
		
		return currentPos < accounts.length;
	}

	@Override
	public Account next() {
		
		Account returnAcc = accounts[currentPos];
		currentPos++;
		return returnAcc;
	}

}
