package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {
	
	private Account[] accounts;
	
	public Bank(int size) {
		accounts = new Account [size];
		init();
	}

	public Bank() {
		accounts = new Account[100];
		init();
	}
	
	public void init() {
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account (i, 100);
			}
	}
}
