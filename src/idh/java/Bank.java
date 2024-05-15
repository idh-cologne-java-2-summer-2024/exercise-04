package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {
	
	public Account[] accounts;
	
	public Bank(int size) {
		accounts = new Account	[size];
		init();
	}
	
	 public void init() {
		// create accounts with varying balances
	   	Random random = new Random();
	   	for (int i = 0; i < accounts.length; i++) {
	   		accounts[i] = new Account(i, random.nextInt(1000));
	   	}
	 }

	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(accounts);
	}

}
