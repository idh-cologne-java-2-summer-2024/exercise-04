package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account>{
	
    private Account[] accounts = new Account[200];
    
    public Bank() {
    	Random random = new Random();
    	for (int i = 0; i < accounts.length; i++) {
    	    accounts[i] = new Account(i, random.nextInt(1000));
    	}
    }

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(accounts);
	}
    
    

}
