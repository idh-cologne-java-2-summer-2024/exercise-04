package idh.java;

import java.util.Iterator;
	
public class AccountIterator implements Iterator<Account>{
     //wichtig das es private ist 
	private Account[] accounts;
	
	private int pos;
	
	public AccountIterator(Account[]accounts) {
		this.accounts = accounts;
		pos=0;
	}
	
	@Override
	public boolean hasNext() {
	   // z.B.  5 < 10	
		return pos < accounts.length;
	}

	@Override
	public Account next() {
		Account returnAccount = accounts[pos];
		pos++;
		return returnAccount;
		//variable wichtig weil man sonnst accounts[pos] schon pos++ hat 
	}

}
