package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	
	Account[] account;
	int currentPosition = -1;
	
	
	public AccountIterator(Account[] acc) {
		this.account = acc;
	}


	public boolean hasNext() {
		return currentPosition < account.length -1;
	}


	public Account next() {
		return account[currentPosition++];
	}
	
}
