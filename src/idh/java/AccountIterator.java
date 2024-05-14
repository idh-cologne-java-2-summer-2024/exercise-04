package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator <Account[]> {

	private Account[] accounts;
	
	int currentPosition = -1;
	
	public AccountIterator (Account[] accarr) {
	this.accounts = accarr;	}
	
	@Override
	public boolean hasNext() {
		return currentPosition < accounts.length - 1;
	}

	@Override
	public Account next() {
		currentPosition++;
		return accounts[currentPosition];
	}

	

}
	
	


