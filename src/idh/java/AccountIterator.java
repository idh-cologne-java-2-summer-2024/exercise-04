package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	
	Account[] accounts;
	int position = -1;

	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public boolean hasNext() {
		if(accounts[position + 1] != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Account next() {
		if(hasNext()) {
			return accounts[position++];
		}
		else {
			return null;
		}
	}
	

}
