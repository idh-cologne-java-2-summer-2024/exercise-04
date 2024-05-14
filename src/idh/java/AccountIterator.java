package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	
	Account[] account;
	int currentPosition = -1;
	
	
	public AccountIterator(Account[] acc) {
		this.account = acc;
	}


	@Override
	public boolean hasNext() {
		return currentPosition < account.length -1;
	}


	@Override
	public Account next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
