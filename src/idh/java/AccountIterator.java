package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
	
	private Account[] accounts;
	
	private int position;
	
	public AccountIterator(Account[] accounts) {
	 this.accounts = accounts;
	 position = 0;
}

	@Override
	public boolean hasNext() {
		
		return position < accounts.length;
	}

	@Override
	public Account next() {
		Account returnAccount = accounts[position];
		position++;
		return returnAccount;
	}

}
