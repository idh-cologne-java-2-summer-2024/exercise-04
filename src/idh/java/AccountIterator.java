package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	private Account[] accounts;
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts; 
	}
	
	@Override 
	public boolean hasNext() {
		return false;
	}

	@Override 
	public Account next() {
		return null;
	}
}
