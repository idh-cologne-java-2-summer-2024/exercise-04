package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	
	ATM atm;
	int currentPosition = -1;
	
	public AccountIterator (ATM atm) {
		this.atm = atm;
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
