package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	ATM atm;
	int currentPosition = -1;
	
	public AccountIterator () {
		this.atm = atm;
	}

	
	@Override
	public boolean hasNext() {
		return currentPosition < atm.getAccount(currentPosition);
	
	}

	@Override
	public Account next() {
		currentPosition++;
		return atm.getAccount(currentPosition);
	}

}
