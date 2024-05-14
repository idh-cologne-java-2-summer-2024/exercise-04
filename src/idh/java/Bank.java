package idh.java;

import java.util.Iterator;

public class Bank implements Iterable <Account> {
	
	Account[] accounts;

	public Bank (int size) {
		this.accounts = new Account[size];
		
	}
	
	public void init() {
		
		for(int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 100);
		}
	}
	
	public Iterator <Account> iterator() {
		return new AccountIterator(accounts);
	}
	
}
